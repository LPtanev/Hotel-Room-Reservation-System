package models.contracts;

import models.enums.RoomStatus;
import models.enums.RoomType;

public interface Room {

    String getRoomNumber();

    double getPricePerNight();

    double getCancellationFee();

    RoomStatus getRoomStatus();

    RoomType getRoomType();

    int getMaximumOccupancy();

    void changeRoomStatus(RoomStatus roomStatus);

}