//import java.util.ArrayList;
//import javafx.util.converter.DateStringConverter;

public class FlyEasyApplication {

    private UserList users;
	private airportList cAirportList;
	private FlightList aFlightList;
	private RegisteredAirport currentAirport;
	private RegisteredFlight currentFlight;
    private RegisteredUser currentUser;

    public FlyEasyApplication(){

        users = UserList.getInstance();
		cAirportList = airportList.getInstance();
		aFlightList = FlightList.getInstance();
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
	public boolean findFlight(String departureDate){
		if(!aFlightList.haveFlight(departureDate)) return false;
		currentFlight = aFlightList.getFlight(departureDate);
		return true;
	}

	// this should just return true if they want to purchase, I think it would be prople hard
	// to match in here but you can maybe getCurrentFlight here but most likely you can call
	// getCurrentFlight - or currentFlight I think it is - a lot easier in the UI
	public boolean purchase(String flightName) {
		//if(!findItem(flightName))return false;
		
		//checkout the item
		//need a user then have them checkout an item
		return true;
	}

	public void logout() {
		users.saveUsers();
	}
	public boolean createAirport(String city, String state, String airportName, String airportCode){
		
		return cAirportList.addAirport(city, state,  airportName, airportCode);
	}
	public boolean createFlight(String airline, String flightDepartureDate, String flightArrivalDate,
        String departureTime, String arrivalTime, String seats, String seatColumn, String seatRow){

			return aFlightList.addFlight(airline, flightDepartureDate, flightArrivalDate, departureTime, arrivalTime, seats, seatColumn, seatRow);
	}
	public void exit(){
		cAirportList.saveAirports();
		aFlightList.saveFlights();
	}
	public RegisteredAirport getCurrentAirport() {
		return currentAirport;
	}
	public RegisteredFlight getCurrentFlight(){
		return currentFlight;
	}
    
}
