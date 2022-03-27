import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class FlightDataLoader extends DataConstants{
    public static ArrayList<RegisteredFlight> getFlights() {
		ArrayList<RegisteredFlight> allFlights = new ArrayList<RegisteredFlight>();
		
		try {
             
			FileReader reader = new FileReader(FLIGHT_DATA_FILE);
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();	
			JSONArray flightJSON = (JSONArray)new org.json.simple.parser.JSONParser().parse(reader);
            
            /** 
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			*/
			for(int i=0; i < flightJSON.size(); i++) {
				JSONObject flightsJSON = (JSONObject)flightJSON.get(i);
				UUID flightid = UUID.fromString((String)flightsJSON.get(FLIGHT_ID));
				String airline = (String)flightsJSON.get(AIRLINE);
				String flightDepartureDate = (String)flightsJSON.get(FLIGHT_DEPARTURE_DATE);
				String flightArrivalDate = (String)flightsJSON.get(FLIGHT_ARRIVAL_DATE);
                String departureTime = (String)flightsJSON.get(DEPARTURE_TIME);
                String arrivalTime = (String)flightsJSON.get(ARRIVAL_TIME);
                String gate = (String)flightsJSON.get(GATE);
                int seats = (int)flightsJSON.get(SEATS);
                String seatColumn = (String)flightsJSON.get(SEAT_COLUMN);
                String seatRow = (String)flightsJSON.get(SEAT_ROW);
                int price = (int)flightJSON.get(PRICE);
				allFlights.add(new RegisteredFlight(airline, flightDepartureDate, flightArrivalDate, 
                departureTime, arrivalTime, gate, seats, seatColumn, seatRow, price));
			}
			
			return allFlights;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
