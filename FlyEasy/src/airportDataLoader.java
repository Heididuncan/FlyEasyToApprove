import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class airportDataLoader extends DataConstants {
    
    public static ArrayList<RegisteredAirport> getAirports() {
		ArrayList<RegisteredAirport> allAirports = new ArrayList<RegisteredAirport>();
		
		try {
             
			FileReader reader = new FileReader(AIRPORTS_DATA_FILE);
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();	
			JSONArray airportsJSON = (JSONArray)new org.json.simple.parser.JSONParser().parse(reader);
            
            /** 
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			*/
			for(int i=0; i < airportsJSON.size(); i++) {
				JSONObject airportJSON = (JSONObject)airportsJSON.get(i);
				UUID airportid = UUID.fromString((String)airportJSON.get(AIRPORT_ID));
				String state = (String)airportJSON.get(STATE);
				String city = (String)airportJSON.get(CITY);
				String airportName = (String)airportJSON.get(AIRPORTNAME);
                String airportCode = (String)airportJSON.get(AIRPORTCODE);
				allAirports.add(new RegisteredAirport(state, city, airportName, airportCode));
			}
			
			return allAirports;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
