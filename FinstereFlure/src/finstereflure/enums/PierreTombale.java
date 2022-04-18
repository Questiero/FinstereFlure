package finstereflure.enums;

public enum PierreTombale {
    PAS_5,
    PAS_7,
    PAS_8,
    PAS_10,
    VICTIME_1,
    VICTIME_2;

    public int getValue() {

        switch (this) {
            case PAS_5:
                return 5;
            case PAS_7:
                return 7;
            case PAS_8:
                return 8;
            case PAS_10:
                return 10;
            case VICTIME_1:
                return 1;
            case VICTIME_2:
                return 2;
        }

        return 0;

    }

}
