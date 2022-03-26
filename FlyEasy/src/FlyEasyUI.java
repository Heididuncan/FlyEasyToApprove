import java.util.*;

public class FlyEasyUI {

    private static final String WELCOME_MESSAGE = "Welcome to FlyEasy";
	private String[] mainMenuOptions = {"Create Account", "Login", "Find Flight","Purchase Flight","Logout"};
	private String[] developerMenuOptions = {"Add New Airport","Add New Flight", "Exit"};
	private Scanner scanner;
    //private static FlightSearch searchingFlights = new FlightSearch();
	//private static airportList anotherList = new airportList();
	private FlyEasyApplication flyEasy;
   // private FlightSearch date;
	
	FlyEasyUI(){
		scanner = new Scanner(System.in);
		flyEasy = new FlyEasyApplication();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out
			if(userCommand == mainMenuOptions.length -1) {
				flyEasy.logout();
				break;
			}
		
			switch(userCommand) {
				case(0):
					createAccount();
					break;
				case(1):
					login();
					break;
				case(2):
					System.out.println("FROM");
					findAirports();
					findFlight();
					System.out.println("TO");
					findAirports();
					//findFlight();
					break;
				case(3):
					purchase();
					break;
				
			}
		}
		System.out.println("Good bye, and have a nice day");
		UserList.getInstance().saveUsers();
		airportList.getInstance();
}
		public void runB(){
			while(true){
			displayDeveloperMenu();

			int userCommand = getUserCommand(developerMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			//if(userCommand == developerMenuOptions.length -1) {
			//	System.exit(0);
			//	break;
		//	}
			switch(userCommand) {
				case(0):
					createAirport();
					break;
				case(1):
					createFlight();	
				case(2):
					flyEasy.exit();
					break;
			}
		}
		
	}	

	private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
	private void displayDeveloperMenu() {
		System.out.println("\n************ For Developers *************");
		for(int i=0; i< developerMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + developerMenuOptions[i]);
		}
		System.out.println("\n");
	}
	
	//get the users command number, if it's not valid, return -1
	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}
	
	private void createAccount() {
		String userName = getField("Username");
		String firstName = getField("First Name");
		String lastName = getField("Last Name");
        String email = getField("Email");
		String cardNum = getField("Card Number");
		
		
		if(flyEasy.createAccount(userName, firstName, lastName, email, cardNum)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}
	
	private void login() {
		String userName = getField("Username");
		
		if(flyEasy.login(userName)) {
			RegisteredUser currentUser = flyEasy.getCurrentUser();
			System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
		} else {
			System.out.println("Sorry, invalid username ");
		}
	}
	private void createAirport() {
		String city = getField("City");
		String state = getField("State");
        String airportName = getField("Airport Name");
		String airportCode = getField("Airport Code");
		
		
		if(flyEasy.createAirport(city, state, airportName, airportCode)) {
			System.out.println("successfully created");
		} else {
			System.out.println("Sorry a listing with that already exists");
		}
	}
	private void createFlight(){
		String airline = getField("Airline");
		String flightDepatureDate = getField("Flight Departure Date");
		String flightArrivalDate = getField("Flight Arrival Date");
		String departureTime = getField("Departure Time");
		String arrivalTime = getField("Arrival Time");
		String seats = getField("Total Seats");
		String seatColumn = getField("Seat Column");
		String seatRow = getField("Seat Row");
		if(flyEasy.createFlight(airline, flightDepatureDate, flightArrivalDate, departureTime, arrivalTime, seats, seatColumn, seatRow)) {
			System.out.println("successfully created");
		} else {
			System.out.println("Sorry a listing with that already exists");
		}
	}
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	private void findAirports() {
		System.out.println("Enter City and State (ex:'Columbia') \n");
			String city = getField("City: ");
			String state = getField("State: ");
			if(flyEasy.findAirport(city, state)){
				boolean pickedAirport = flyEasy.findAirport(city, state);
				RegisteredAirport airportInfo = flyEasy.getCurrentAirport();
				System.out.println("Is this Airport good for you?");
				
				System.out.println("City: "+ airportInfo.getCity()+ "State: "+ airportInfo.getState() + 
					"Airport: "+ airportInfo.getAirportName());
			}
			else{
				System.out.println("Sorry Something went wrong");
			}
	}
	public void findFlight() {
        
        //String date = scanner.nextLine();
        //FlightSearch(date)
		System.out.println("Enter Desired Departure Date\n");
		String flightDepartureDate = getField("From When (ex. 00/00/00): ");
			if(flyEasy.findFlight(flightDepartureDate)){
				RegisteredFlight flightInfo = flyEasy.getCurrentFlight();
				System.out.println("Airline: "+flightInfo.getAirline()+" Departure Date: "
				 +flightInfo.getFlightArrivalDate()+" Departure Time: "+flightInfo.getDepartureTime());
				System.out.println("Arrival Time: "+flightInfo.getArrivalTime()+" Seats Left: "
				 +flightInfo.getSeats()+" Seat Column: "+flightInfo.getSeatColumn()+" Seat Row: "+flightInfo.getSeatRow());

			}
			// boolean for purchase (so it is attached to the flight id and such) - if true then
			// easyFly.purchase()
			
	}
	//I would and will put everything for purchase is FlyEasy Application
	// ohhh or or right above
	private void purchase() {
		System.out.println("\n-----Checking out your Plane Ticket-----");
		// Append the currentAirport, current flight to user id 
		// IMPORTANT: you have to call the info into this method like i did in the method
		//            above where you see ***RegisteredFlight flightInfo***
		// I think then there is also no need for getUserFlight 

		String flight = getUserFlight();
		
		if(flight == null)return;
		
		if(!flyEasy.purchase(flight)) {
			System.out.println("Sorry there was a problem, restart program\n");
			return;
		}
		System.out.println("Your Plane Ticket was successfully Comfirmed\n");
	}
	 
    private String getUserFlight() {
		
		while(true) {
			String date = scanner.next().trim().toLowerCase();
            //System.out.println("Enter Desired Flight Destination: ");
            String destination = scanner.next().trim().toLowerCase();
            
			if(!date.contentEquals("")) return date;
           
           if(!destination.contentEquals("")) return destination;
			
			System.out.println("You need to actually enter content");
		}
	}

    public static void main(String[] args){

        FlyEasyUI flyEasyInterface = new FlyEasyUI();
		//runB is the deleveoper menu I made and run is the main menu, WHICHEVER ID FIRST WITH PRINT OUT SO FIX BEFORE SHOWING/RUNNING
	        flyEasyInterface.runB();
		flyEasyInterface.run();
        
    }
}
