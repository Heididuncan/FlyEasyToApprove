
public abstract class DataConstants {

    protected static final String USER_FILE_NAME = "src/userList.json";
    protected static final String AIRPORTS_DATA_FILE = "src/airports.json";
    protected static final String FLIGHT_DATA_FILE = "src/flights.json";
    protected static final String USER_ID = "id";
    protected static final String USER_USER_NAME = "userName";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String EMAIL = "email";   
    protected static final String USER_CARDNUM = "0000000000000000";
    protected static final String AIRPORT_ID = "airportid";
    protected static final String STATE = "state";
    protected static final String CITY = "city";
    protected static final String AIRPORTNAME = "airportName";
    protected static final String AIRPORTCODE = "airportCode";
    protected static final String FLIGHT_ID = "flightid";
    protected static final String AIRLINE = "airline";
    protected static final String FLIGHT_DEPARTURE_DATE = "00/00/00";
    protected static final String FLIGHT_ARRIVAL_DATE = "00/00/00";
    protected static final String DEPARTURE_TIME = "00:00";
    protected static final String ARRIVAL_TIME = "00:00";
    /**
     * I realized here that the map doesnt matter because if there are only 28 seats in every flight
     * then after assigning the column and row to the users it will be filled for the flight id.
     * Also airports can/do overbook flights manually and this way that exact flight listing and seat
     * assignment can be deleted and go back into the search to be putchased
     */
    protected static final String SEATS = "seats";
    protected static final String SEAT_COLUMN = "seatColumns";
    protected static final String SEAT_ROW = "seatRows";

}
