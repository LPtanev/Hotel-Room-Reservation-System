package models;

import models.contracts.Hotel;
import models.contracts.Room;
import utils.EventLog;
import utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class HotelModel implements Hotel {

    private final static int MIN_HOTEL_NAME_LEN = 5;
    private final static int MAX_HOTEL_NAME_LEN = 15;
    private final static String NO_AVAILABLE_ROOMS = "There are no available rooms at the moment!";
    private static final String INVALID_NAME_LEN = format(
            "Hotel name length must be between %d and %d!",
            MIN_HOTEL_NAME_LEN,
            MAX_HOTEL_NAME_LEN);
    private final static int MIN_AND_MAX_HOTEL_TELEPHONE_LEN = 10;
    private static final String INVALID_HOTEL_TELEPHONE_LEN = format(
            "Hotel name length must be exactly %d numbers!",
            MIN_AND_MAX_HOTEL_TELEPHONE_LEN);
    private final static int MIN_HOTEL_WEBSITE_LEN = 7;
    private final static int MAX_HOTEL_WEBSITE_LEN = 25;
    private static final String INVALID_HOTEL_WEBSITE_LEN = format(
            "Hotel website length must be between %d and %d!",
            MIN_HOTEL_WEBSITE_LEN,
            MAX_HOTEL_WEBSITE_LEN);

    private String hotelName;

    private final String hotelLocation;

    private String hotelWebSite;

    private String hotelTelephone;

    private List<Room> hotelRooms;

    private final List<EventLog> activityHistory;


    public HotelModel(String hotelName, String hotelLocation, String hotelWebSite, String hotelTelephone) {
        setHotelName(hotelName);
        this.hotelLocation = hotelLocation;
        setHotelWebSite(hotelWebSite);
        setHotelTelephone(hotelTelephone);
        this.hotelRooms = new ArrayList<>();
        activityHistory = new ArrayList<>();
    }

    @Override
    public String getName() {
        return hotelName;
    }

    private void setHotelName(String hotelName) {
        ValidationHelpers.validateStringLength(hotelName, MIN_HOTEL_NAME_LEN, MAX_HOTEL_NAME_LEN, INVALID_NAME_LEN);
        this.hotelName = hotelName;
    }

    @Override
    public String getLocation() {
        return hotelLocation;
    }

    @Override
    public String getWebSite() {
        return hotelWebSite;
    }

    public void setHotelWebSite(String hotelWebSite) {
        ValidationHelpers.validateStringLength(hotelWebSite, MIN_HOTEL_WEBSITE_LEN,
                MAX_HOTEL_WEBSITE_LEN, INVALID_HOTEL_WEBSITE_LEN);
        this.hotelWebSite = hotelWebSite;
    }

    @Override
    public String getTelephone() {
        return hotelTelephone;
    }

    public void setHotelTelephone(String hotelTelephone) {
        ValidationHelpers.validateStringLength(hotelTelephone, MIN_AND_MAX_HOTEL_TELEPHONE_LEN,
                MIN_AND_MAX_HOTEL_TELEPHONE_LEN, INVALID_HOTEL_TELEPHONE_LEN);
        this.hotelTelephone = hotelTelephone;
    }

    @Override
    public List<Room> getRooms() {
        return new ArrayList<>(hotelRooms);
    }

    //  @Override
    // public String printBill() {
    //     return null;
    // }

    @Override
    public void addRoom(Room room) {
        this.hotelRooms.add(room);
        activityHistory.add(new EventLog("Room [%s] [%d] added".formatted(room.getRoomType(), room.getRoomNumber())));
    }

    @Override
    public void removeRoom(Room room) {
        this.hotelRooms.remove(room);
        activityHistory.add(new EventLog("Room [%s] [%d] removed".formatted(room.getRoomType(), room.getRoomNumber())));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel: %s".formatted(getName())).append(System.lineSeparator());
        sb.append("Location: %s".formatted(getLocation())).append(System.lineSeparator());
        sb.append("WebSite: %s".formatted(getWebSite())).append(System.lineSeparator());
        sb.append("Telephone: %s".formatted(getTelephone())).append(System.lineSeparator());
        sb.append("Rooms: ").append(System.lineSeparator());
        if (getRooms().isEmpty()) {
            sb.append(NO_AVAILABLE_ROOMS).append(System.lineSeparator());
        } else {
            int counter = 1;
            for (Room room : getRooms()) {
                sb.append("%d. %s".formatted(counter, room.toString())).append(System.lineSeparator());
                counter++;
            }
        }
        return sb.toString();
    }

    @Override
    public List<EventLog> getActivityHistory() {
        return new ArrayList<>(activityHistory);
    }
}