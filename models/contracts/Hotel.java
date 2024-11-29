package models.contracts;

import java.util.List;

public interface Hotel extends ActivityHistory {

    String getName();

    String getLocation();

    String getWebSite();

    String getTelephone();

    List<Room> getRooms();

  //  String printBill();

    void addRoom(Room room);

    void removeRoom(Room room);
}
