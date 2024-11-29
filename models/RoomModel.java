package models;

import models.contracts.Room;
import models.enums.RoomStatus;
import models.enums.RoomType;
import utils.EventLog;

import java.util.ArrayList;
import java.util.List;

public class RoomModel implements Room {

    public static final int ROOM_NUMBER_MIN_LENGTH = 3;
    private static final String STATUS_SWITCHED_MESSAGE = "The status of the room with number %s switched from %s to %s.";
    public static final String CHECK_STATUS_MESSAGE = "This status is not suitable for rooms status.";
    private final String roomNumber;

    private double pricePerNight;

    private double cancellationFee;

    private int maximumOccupancy;

    private RoomStatus roomStatus;

    private RoomType roomType;

    private final List<EventLog> activityHistory;

    public RoomModel(String roomNumber, double pricePerNight, double cancellationFee,
                     int maximumOccupancy, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.cancellationFee = cancellationFee;
        this.maximumOccupancy = maximumOccupancy;
        roomStatus = RoomStatus.AVAILABLE;
        this.roomType = roomType;
        activityHistory=new ArrayList<>();
        activityHistory.add(new EventLog("New room with number %s, type %s and maxOccupancy %d created."
                .formatted(getRoomNumber(), getRoomType(), getMaximumOccupancy())));
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public double getCancellationFee() {
        return cancellationFee;
    }

    @Override
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public int getMaximumOccupancy() {
        return maximumOccupancy;
    }

    @Override
    public void changeRoomStatus(RoomStatus roomStatus) {
        checkStatusForRoom(roomStatus);
        activityHistory.add(new EventLog(STATUS_SWITCHED_MESSAGE.formatted(getRoomNumber(),getRoomStatus(),roomStatus)));
        this.roomStatus = roomStatus;
    }

    protected void checkStatusForRoom(RoomStatus roomStatus) {
        switch (roomStatus) {
            case AVAILABLE, BOOKED:
                break;
            default:
                throw new IllegalArgumentException(CHECK_STATUS_MESSAGE);
        }
    }
}
