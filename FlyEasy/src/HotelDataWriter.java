import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class HotelDataWriter extends DataConstants {
    public static void saveHotels() {
		HotelList hotels = HotelList.getInstance();
		ArrayList<RegisteredHotel> hotelsList = hotels.getHotels();
		JSONArray jsonHotels = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< hotelsList.size(); i++) {
			jsonHotels.add(getHotelsJSON(hotelsList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(HOTEL_DATA_FILE)) {
 
            file.write(jsonHotels.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getHotelsJSON(RegisteredHotel hotel) {
		JSONObject hotelDetails = new JSONObject();
		hotelDetails.put(HOTEL_ID, hotel.getHotelId().toString());
        hotelDetails.put(HOTEL_NAME, hotel.getHotelName());
        hotelDetails.put(HOTEL_CITY, hotel.getHotelCity());
        hotelDetails.put(HOTEL_NAME, hotel.getHotelState());
        hotelDetails.put(ROOM_TYPE, hotel.getRoomType());
        hotelDetails.put(OPEN_ROOM, hotel.getOpenRoom());
        hotelDetails.put(PRICE, hotel.getHotelPrice());
        
        return hotelDetails;
	}
}
