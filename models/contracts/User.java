package models.contracts;

import java.util.Date;
import java.util.List;

public interface User {

    String getFirstName();

    String getLastName();

    String getPassword();

    String getTelephoneNumber();

    boolean isAdmin();

    int getReservationPeriod();

    Date getArriveDate();

    Date getLeaveDate();

    void bookRoom(Room room, User user, Date startDate, Date endDate);

    void cancelBooking(Room room, User user);

// List<BookingSummary> getUserBookingHistory();

}