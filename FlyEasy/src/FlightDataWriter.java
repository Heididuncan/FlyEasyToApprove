import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FlightDataWriter extends DataConstants {
    public static void saveFlights() {
		FlightList flights = FlightList.getInstance();
		ArrayList<RegisteredFlight> flightsList = flights.getFlights();
		JSONArray jsonFlights = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< flightsList.size(); i++) {
			jsonFlights.add(getFlightsJSON(flightsList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(FLIGHT_DATA_FILE)) {
 
            file.write(jsonFlights.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getFlightsJSON(RegisteredFlight flight) {
		JSONObject flightDetails = new JSONObject();
		flightDetails.put(FLIGHT_ID, flight.getFlightId().toString());
		flightDetails.put(AIRLINE, flight.getAirline());
		flightDetails.put(FLIGHT_DEPARTURE_DATE, flight.getFlightDepartureDate());
		flightDetails.put(FLIGHT_ARRIVAL_DATE, flight.getFlightArrivalDate());
        flightDetails.put(DEPARTURE_TIME, flight.getDepartureTime());
        flightDetails.put(ARRIVAL_TIME, flight.getArrivalTime());
        flightDetails.put(GATE, flight.getGate());
        flightDetails.put(SEATS, flight.getSeats());
        flightDetails.put(SEAT_COLUMN, flight.getSeatColumn());
        flightDetails.put(SEAT_ROW, flight.getSeatRow());
        flightDetails.put(PRICE, flight.getPrice());
        
        return flightDetails;
	}

}
