package cn.garymb.ygomobile.ex_card;


import static cn.garymb.ygomobile.Constants.URL_PRE_CARD;
import static cn.garymb.ygomobile.utils.StringUtils.mergeListDelimeter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import cn.garymb.ygomobile.lite.R;
import cn.garymb.ygomobile.loader.ImageLoader;
import cn.garymb.ygomobile.ui.plus.DialogPlus;
import cn.garymb.ygomobile.ui.plus.VUiKit;
import cn.garymb.ygomobile.utils.LogUtil;
import cn.garymb.ygomobile.utils.OkhttpUtil;
import cn.garymb.ygomobile.utils.glide.GlideCompat;
import okhttp3.Response;

public class ExCardListAdapter extends BaseQuickAdapter<ExCardData, BaseViewHolder> {
    private static final String TAG = ExCardListAdapter.class.getSimpleName();
    private ImageLoader imageLoader;

    public ExCardListAdapter(int layoutResId) {
        super(layoutResId);
    }

    public void loadData() {
        final DialogPlus dialog_read_ex = DialogPlus.show(getContext(), null, getContext().getString(R.string.fetch_ex_card));
        VUiKit.defer().when(() -> {
                    LogUtil.d(TAG, "start fetch");
                    List<ExCardData> exCardDataList = null;
                    try {
                        Response response = OkhttpUtil.synchronousGet(URL_PRE_CARD, null, null);
                        String responseBodyString = response.body().string();
                        Type listType = new TypeToken<List<ExCardData>>() {
                        }.getType();
                        Gson gson = new Gson();

                        // Convert JSON to Java object using Gson
                        exCardDataList = gson.fromJson(responseBodyString, listType);


                    } catch (IOException e) {
                        Log.e(TAG, "Error occured when fetching data from pre-card server");
                        return null;
                    }

                    if (exCardDataList.isEmpty()) {
                        return null;
                    } else {
                        return exCardDataList;
                    }

                })
                .fail((e) -> {
                    //关闭异常
                    if (dialog_read_ex.isShowing()) {
                        try {
                            dialog_read_ex.dismiss();
                        } catch (Exception ex) {
                        }
                    }

                    LogUtil.i(TAG, "webCrawler fail");
                })
                .done((exCardDataList) -> {

                    if (exCardDataList != null) {
                        LogUtil.i(TAG, "webCrawler done");

                        getData().clear();
                        addData(exCardDataList);
                        notifyDataSetChanged();
                    }
                    if (dialog_read_ex.isShowing()) {
                        try {
                            dialog_read_ex.dismiss();
                        } catch (Exception ex) {
                        }
                    }
                });

    }

    private static Boolean isMonster(List<String> list) {
        for (String data : list) {
            if (data.equals("怪兽")) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void convert(BaseViewHolder helper, ExCardData item) {
        helper.setText(R.id.ex_card_name, item.getName());
        helper.setText(R.id.ex_card_description, item.getDesc());
        helper.setText(R.id.ex_card_overall,item.getOverallString());

        ImageView imageview = helper.getView(R.id.ex_card_image);
        //the function cn.garymb.ygomobile.loader.ImageLoader.bindT(...)
        //cn.garymb.ygomobile.loader.ImageLoader.setDefaults(...)
        //is a private function,so I copied the content of it to here
        RequestBuilder<Drawable> resource = GlideCompat.with(imageview.getContext()).load(item.getPicUrl());
        resource.placeholder(R.drawable.unknown);
        resource.error(R.drawable.unknown);
        resource.into(imageview);

    }
}
