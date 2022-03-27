import java.util.ArrayList;

public class HotelList {
    private static HotelList hotels;
    private ArrayList<RegisteredHotel> hotelList;
	
	private HotelList() {
		hotelList = HotelDataLoader.getHotels();
	}

	public static HotelList getInstance() {
		if(hotels == null) {
			hotels = new HotelList();
		}
		
		return hotels;
	}
	public boolean addHotel(String hotelName, String hotelCity, String hotelState, String roomType, String openRoom, String checkInDate, String checkOutDate, int price) {
        if(haveHotel(hotelCity, hotelState))return false;
		
		hotelList.add(new RegisteredHotel(hotelName, hotelCity, hotelState, roomType, openRoom, checkInDate, checkOutDate, price));
		return true;
    }

    

	public boolean haveHotel(String hotelCity, String hotelState) {
		for(RegisteredHotel hotel : hotelList) {
			for(hotel.getHotelCity().equals(hotelCity); hotel.getHotelState().equals(hotelState);) {
				return true;
			}
		}
		
		return false;
	}
	
	public RegisteredHotel getHotel(String hotelCity, String hotelState) {
		for(RegisteredHotel hotel : hotelList) {
			for(hotel.getHotelCity().equals(hotelCity); hotel.getHotelState().equals(hotelState);) {
				return hotel;
			}
		}
		
		return null;
	}
	
	public ArrayList<RegisteredHotel> getHotels() {
		return hotelList;
	}

    public void saveHotels() {
        HotelDataWriter.saveHotels();
    }
}
