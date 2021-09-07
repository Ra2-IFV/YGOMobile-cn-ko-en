package ocgcore.enums;

import androidx.annotation.Nullable;

public enum CardOt {
    ALL(0),
    OCG(1, 1240),
    TCG(2, 1241),
    NO_EXCLUSIVE(3, 1242),
    CUSTOM(4, 1243),
    SC_OCG(8);

    private final int value;
    //1240
    private final int lang_index;

    CardOt(int value) {
        this(value, 0);
    }

    CardOt(int value, int lang_index) {
        this.value = value;
        this.lang_index = lang_index;
    }

    public int getLanguageIndex() {
        return lang_index;
    }

    public int getId() {
        return value;
    }

    public static @Nullable CardOt valueOf(int value) {
        for (CardOt cardOt : values()) {
            if (cardOt.value == value) {
                return cardOt;
            }
        }
        return null;
    }
}
