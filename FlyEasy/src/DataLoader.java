import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<RegisteredUser> getUsers() {
		ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
		
		try {
             
			FileReader reader = new FileReader(USER_FILE_NAME);
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();	
			JSONArray peopleJSON = (JSONArray)new org.json.simple.parser.JSONParser().parse(reader);
            
            /** 
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			*/
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
                String email = (String)personJSON.get(EMAIL);
                String cardNum = (String)personJSON.get(USER_CARDNUM);
				
				users.add(new RegisteredUser(id, userName, firstName, lastName, email, cardNum));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
    
}
