package cn.garymb.ygomobile.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.garymb.ygomobile.bean.Deck;
import cn.garymb.ygomobile.bean.DeckInfo;
import cn.garymb.ygomobile.bean.TextSelect;
import cn.garymb.ygomobile.bean.events.DeckFile;
import cn.garymb.ygomobile.lite.R;
import cn.garymb.ygomobile.loader.CardLoader;
import cn.garymb.ygomobile.loader.DeckLoader;
import cn.garymb.ygomobile.loader.ImageLoader;
import cn.garymb.ygomobile.ui.cards.deck.DeckAdapater;
import cn.garymb.ygomobile.ui.cards.deck.DeckItem;
import cn.garymb.ygomobile.ui.cards.deck.ImageTop;
import cn.garymb.ygomobile.utils.YGOUtil;
import ocgcore.data.LimitList;

public class DeckListAdapter<T extends TextSelect> extends BaseQuickAdapter<T, DeckViewHolder> {
    private ImageLoader imageLoader;
    private ImageTop mImageTop;
    private LimitList mLimitList;
    private CardLoader mCardLoader;
    private DeckLoader mDeckLoader;
    private DeckInfo deckInfo;
    private DeckFile deckFile;
    private OnItemSelectListener onItemSelectListener;
    private int selectPosition;
    private boolean isSelect;
    private boolean isManySelect;
    private List<T> selectList;

    public DeckListAdapter(Context context, List<T> data, int select) {
        super(R.layout.item_deck_list_swipe, data);
        this.selectPosition = select;
        if (select >= 0)
            isSelect = true;
        else
            isSelect = false;
        isManySelect = false;
        selectList = new ArrayList<>();
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isSelect && position == selectPosition)
                    return;
                selectPosition = position;
                notifyDataSetChanged();
                if (onItemSelectListener != null)
                    onItemSelectListener.onItemSelect(position, data.get(position).getObject());
            }
        });
         mCardLoader = new CardLoader(context);
        imageLoader = new ImageLoader();
        mLimitList = new LimitList();
        mDeckLoader = new DeckLoader();
        deckInfo = new DeckInfo();
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(DeckViewHolder holder, T item) {
        int position = holder.getAdapterPosition();
        //item是deckFile类型
        this.deckFile = (DeckFile) item;
        this.deckInfo = mDeckLoader.readDeck(mCardLoader, deckFile.getPathFile(), mLimitList);
        Log.i("看看3.9.7", deckInfo +"");
        //填入内容
        imageLoader.bindImage(holder.cardImage, deckFile.getFirstCode(), ImageLoader.Type.small);
        holder.deckName.setText(item.getName());
        holder.main.setText(String.valueOf(deckInfo.getMainCount()));
        holder.extra.setText(String.valueOf(deckInfo.getExtraCount()));
        holder.side.setText(String.valueOf(deckInfo.getSideCount()));
        //多选
        if (isManySelect) {
            if (selectList.contains(item))
                holder.item_deck_list.setBackgroundColor(YGOUtil.c(R.color.colorMain));
            else
                holder.item_deck_list.setBackgroundResource(Color.TRANSPARENT);
        } else if (isSelect) {
            if (position == selectPosition) {
                holder.item_deck_list.setBackgroundColor(YGOUtil.c(R.color.colorMain));
            } else {
                holder.item_deck_list.setBackgroundResource(Color.TRANSPARENT);
            }
        }else {
            holder.item_deck_list.setBackgroundResource(Color.TRANSPARENT);
        }

    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public boolean isManySelect() {
        return isManySelect;
    }

    public void addManySelect(T t) {
        if (selectList.contains(t))
            selectList.remove(t);
        else
            selectList.add(t);
    }

    public void setManySelect(boolean manySelect) {
        isManySelect = manySelect;
        if (!isManySelect) {
            selectList.clear();
            notifyDataSetChanged();
        }
    }

    public List<T> getSelectList() {
        return selectList;
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.onItemSelectListener = onItemSelectListener;
    }

    public interface OnItemSelectListener<T> {
        void onItemSelect(int position, T item);
    }
}
class DeckViewHolder extends com.chad.library.adapter.base.viewholder.BaseViewHolder {
    ImageView cardImage;
    ImageView prerelease_star;
    TextView deckName;
    TextView main;
    TextView extra;
    TextView side;
    View item_deck_list;

    public DeckViewHolder(View view) {
        super(view);
        view.setTag(view.getId(), this);
        item_deck_list = findView(R.id.item_deck_list);
        cardImage = findView(R.id.card_image);
        deckName = findView(R.id.deck_name);
        main = findView(R.id.count_main);
        extra = findView(R.id.count_ex);
        side = findView(R.id.count_side);
        prerelease_star = findView(R.id.prerelease_star);
    }
}