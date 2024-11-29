package models.enums;

public enum RoomType {

    DELUXE,

    SUITE,

    SINGLE,

    DOUBLE;

    public String toString() {
        switch (this) {
            case DELUXE:
                return "Deluxe";
            case SUITE:
                return "Suite";
            case SINGLE:
                return "Single";
            case DOUBLE:
                return "Double";
            default:
                throw new UnsupportedOperationException("Room type can be Deluxe, Suite, Single or Double.");

        }
    }
}