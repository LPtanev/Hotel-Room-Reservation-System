package models.contracts;

import utils.EventLog;

import java.util.List;

public interface ActivityHistory {

    List<EventLog> getActivityHistory();
}
