
public class FlyEasyApplication {

    private UserList users;
	private airportList cAirportList;
	private FlightList aFlightList;
	private HotelList aHotelList;
	private RegisteredAirport currentAirport;
	private RegisteredFlight currentFlight;
    private RegisteredUser currentUser;
	private RegisteredHotel currentHotel;

    public FlyEasyApplication(){

        users = UserList.getInstance();
		cAirportList = airportList.getInstance();
		aFlightList = FlightList.getInstance();
		aHotelList = HotelList.getInstance();
    }
    //creates a new user account
	public boolean createAccount(String userName, String firstName, String lastName, String email, String cardNum)
	{
		return users.addUser(userName,  firstName,  lastName, email, cardNum);
	}
	public boolean login(String userName) {
		if(!users.haveUser(userName))return false;
		
		currentUser = users.getUser(userName);
		return true;
	}
	
	public RegisteredUser getCurrentUser() {
		return currentUser;
	}
	public boolean findAirport(String city, String state){
		if(!cAirportList.haveAirport(city, state)) return false;
		currentAirport = cAirportList.getAirport(city, state);
		return true;
	}
	public boolean findArrivalAirport(String city, String state){
		if(!cAirportList.haveAirport(city, state)) return false;
		currentAirport = cAirportList.getAirport(city, state);
		return true;
	}
	public boolean findHotel(String hotelCity, String hotelState){
		if(!aHotelList.haveHotel(hotelCity, hotelState)) return false;
		currentHotel = aHotelList.getHotel(hotelCity, hotelState);
		return true;
	}
	public boolean findFlight(String departureDate){
		if(!aFlightList.haveFlight(departureDate)) return false;
		currentFlight = aFlightList.getFlight(departureDate);
		return true;
	}
	public boolean purchase(RegisteredFlight registeredFlight) {
		aFlightList.getFlights().remove(currentFlight);
		return true;
	}
	public void logout() {
		users.saveUsers();
	}
	public boolean createAirport(String city, String state, String airportName, String airportCode){
		
		return cAirportList.addAirport(city, state,  airportName, airportCode);
	}
	public boolean createFlight(String airline, String flightDepartureDate, String flightArrivalDate,
        String departureTime, String arrivalTime, String gate, int seats, String seatColumn, String seatRow, int price){

			return aFlightList.addFlight(airline, flightDepartureDate, flightArrivalDate, departureTime, arrivalTime, gate, seats, seatColumn, seatRow, price);
	}
	public boolean createHotel(String hotelName, String hotelCity, String hotelState, String roomType, String openRoom, String checkInDate, String checkOutDate, int price){
		return aHotelList.addHotel(hotelName, hotelCity, hotelState, roomType, openRoom, checkInDate, checkOutDate, price);
	}
	public void exit(){
		cAirportList.saveAirports();
		aFlightList.saveFlights();
		aHotelList.saveHotels();
	}
	public RegisteredAirport getCurrentAirport() {
		return currentAirport;
	}
	public RegisteredFlight getCurrentFlight(){
		return currentFlight;
	}
	public RegisteredHotel getCurrentHotel(){
		return currentHotel;
	}
    
}
