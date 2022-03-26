import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class AirportDataWriter extends DataConstants {
    


    
    public static void saveAirports() {
		airportList airports = airportList.getInstance();
		ArrayList<RegisteredAirport> airportsList = airports.getAirports();
		JSONArray jsonAirports = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< airportsList.size(); i++) {
			jsonAirports.add(getAirportsJSON(airportsList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(AIRPORTS_DATA_FILE)) {
 
            file.write(jsonAirports.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getAirportsJSON(RegisteredAirport airport) {
		JSONObject airportDetails = new JSONObject();
		airportDetails.put(AIRPORT_ID, airport.getId().toString());
		airportDetails.put(STATE, airport.getState());
		airportDetails.put(CITY, airport.getCity());
		airportDetails.put(AIRPORTNAME, airport.getAirportName());
        airportDetails.put(AIRPORTCODE, airport.getAirportCode());
        
        return airportDetails;
	}


    
}
