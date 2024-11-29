package models;

import models.contracts.BookingSummary;
import models.contracts.Room;

public class BookingModel implements BookingSummary {
    @Override
    public double getTotalIncome() {
        return 0;
    }

    @Override
    public double getTotalCancellationFees() {
        return 0;
    }
}