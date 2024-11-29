package models.enums;

public enum RoomStatus {

    AVAILABLE,

    BOOKED;

    public String toString() {
        switch (this) {
            case AVAILABLE:
                return "available";
            case BOOKED:
                return "booked";
            default:
                throw new UnsupportedOperationException("Room status can be available or booked.");

        }
    }
}