import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class HotelDataLoader extends DataConstants {
    public static ArrayList<RegisteredHotel> getHotels() {
		ArrayList<RegisteredHotel> allHotels = new ArrayList<RegisteredHotel>();
		
		try {
             
			FileReader reader = new FileReader(HOTEL_DATA_FILE);
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();	
			JSONArray hotelJSON = (JSONArray)new org.json.simple.parser.JSONParser().parse(reader);
            
            /** 
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			*/
			for(int i=0; i < hotelJSON.size(); i++) {
				JSONObject hotelsJSON = (JSONObject)hotelJSON.get(i);
				UUID hotelid = UUID.fromString((String)hotelsJSON.get(HOTEL_ID));
				String hotelName = (String)hotelsJSON.get(HOTEL_NAME);
				String hotelCity = (String)hotelsJSON.get(HOTEL_STATE);
				String hotelState = (String)hotelsJSON.get(HOTEL_CITY);
                String roomType = (String)hotelsJSON.get(ROOM_TYPE);
                String openRoom = (String)hotelsJSON.get(OPEN_ROOM);
                String checkInDate = (String)hotelsJSON.get(CHECK_IN_DATE);
                String checkOutDate = (String)hotelsJSON.get(CHECK_OUT_DATE);
                int price = (int)hotelsJSON.get(PRICE);
				allHotels.add(new RegisteredHotel(hotelName, hotelCity, hotelState, roomType, openRoom, checkInDate, checkOutDate, price));
			}
			
			return allHotels;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
