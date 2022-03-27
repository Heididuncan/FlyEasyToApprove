
public abstract class DataConstants {

    protected static final String USER_FILE_NAME = "src/userList.json";
    protected static final String AIRPORTS_DATA_FILE = "src/airports.json";
    protected static final String FLIGHT_DATA_FILE = "src/flights.json";
    protected static final String HOTEL_DATA_FILE = "src/hotels.json";
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
    protected static final String GATE = "gate";
    /**
     * I realized here that the map doesnt matter because if there are only 28 seats in every flight
     * then after assigning the column and row to the users it will be filled for the flight id.
     */
    protected static final int SEATS = 0;
    protected static final String SEAT_COLUMN = "seatColumns";
    protected static final String SEAT_ROW = "seatRows";
    protected static final int PRICE = 0;
    protected static final String HOTEL_ID = "hotelid";
    protected static final String HOTEL_NAME = "hotelName";
    protected static final String HOTEL_CITY = "hotelCity";
    protected static final String HOTEL_STATE = "hotelState";
    protected static final String ROOM_TYPE = "roomType";
    // for OPEN_ROOM put a floor number and letter for room so example: 2B is floor 2 room B
    protected static final String OPEN_ROOM = "openRoom";
    protected static final String CHECK_IN_DATE = "checkInDate";
    protected static final String CHECK_OUT_DATE = "checkOutDate";


}
