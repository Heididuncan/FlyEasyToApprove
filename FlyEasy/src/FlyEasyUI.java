import java.util.*;
import java.io.*;
public class FlyEasyUI {

    private static final String WELCOME_MESSAGE = "Welcome to FlyEasy";
	private String[] mainMenuOptions = {"Create Account", "Login", "Find Flight","Search Hotels", "Logout"};
	private String[] developerMenuOptions = {"Add New Airport","Add New Flight","Add New Hotel", "Exit"};
	private Scanner scanner;
	private FlyEasyApplication flyEasy;
	
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
					System.out.println("Leaving From");
					findAirports();
					System.out.println("Going To");
					findArrivalAirports();
					findFlight();
					break;
				case(3):
					findHotels();
					//purchase();	
			}
		}
		System.out.println("Good bye, and have a nice day");
		UserList.getInstance().saveUsers();	
    }
		public void runB(){
			while(true){
			displayDeveloperMenu();

			int userCommand = getUserCommand(developerMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			switch(userCommand) {
				case(0):
					createAirport();
					//airportList.getInstance().saveAirports();
					break;
				case(1):
					createFlight();	
					//FlightList.getInstance().saveFlights();
					break;
				case(2):
					createHotel();
					//HotelList.getInstance().saveHotels();	
				case(3):
					flyEasy.exit();
					break;
			}
		}
		//airportList.getInstance().saveAirports();
		//FlightList.getInstance().saveFlights();
		//HotelList.getInstance();
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
		String gate = getField("Gate");
		int seats = getIntField("Total Seats");
		String seatColumn = getField("Seat Column");
		String seatRow = getField("Seat Row");
		int price = getIntField("Price");
		if(flyEasy.createFlight(airline, flightDepatureDate, flightArrivalDate, departureTime, arrivalTime, gate, seats, seatColumn, seatRow, price)) {
			System.out.println("successfully created");
		} else {
			System.out.println("Sorry a listing with that already exists");
		}
	}
	private void createHotel(){
		String hotelName = getField("Hotel Name");
		String hotelCity = getField("Hotel City");
		String hotelState = getField("Hotel State");
		String roomType = getField("Room Type");
		String openRoom = getField("Room Floor/Room Letter");
		String checkInDate = getField("Check-In Date");
		String checkOutDate = getField("Check-Out Date");
		int price = getIntField("Price");
		if(flyEasy.createHotel(hotelName, hotelCity, hotelState, roomType, openRoom, checkInDate, checkOutDate, price)){
			System.out.println("successfully created");
		}else{
			System.out.println("Sorry a listing with that exact info has already been created try changing a feild");
		}
	}
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	private int getIntField(String aPrompt){
		System.out.println(aPrompt + ": ");
		return scanner.nextInt();
	}
	private void findAirports() {
		System.out.println("Enter City and State (ex:'Columbia') \n");
			String city = getField("City: ");
			String state = getField("State: ");
			if(flyEasy.findAirport(city, state)){
				//boolean pickedAirport = flyEasy.findAirport(city, state);
				RegisteredAirport airportInfo = flyEasy.getCurrentAirport();
				System.out.println("Is this Airport good for you?");
				
				System.out.println("City: "+ airportInfo.getCity()+ "State: "+ airportInfo.getState() + 
					"Airport: "+ airportInfo.getAirportName());
			}
			else{
				System.out.println("Sorry Something went wrong");
			}
	}
	private void findArrivalAirports() {
		System.out.println("Enter City and State (ex:'Columbia') \n");
			String city = getField("City: ");
			String state = getField("State: ");
			if(flyEasy.findArrivalAirport(city, state)){
				//boolean pickedAirport = flyEasy.findArrivalAirport(city, state);
				RegisteredAirport airportTwoInfo = flyEasy.getCurrentAirport();
				System.out.println("This is the Airport Picked For You");
				
				System.out.println("City: "+ airportTwoInfo.getCity()+ "State: "+ airportTwoInfo.getState() + 
					"Airport: "+ airportTwoInfo.getAirportName());
			}
			else{
				System.out.println("Sorry Something went wrong");
			}
	}
	private void findHotels() {
		System.out.println("Enter City and State (ex:'Columbia') \n");
			String hotelCity = getField("City: ");
			String hotelState = getField("State: ");
			if(flyEasy.findHotel(hotelCity, hotelState)){
				//boolean pickedHotel = flyEasy.findHotel(hotelCity, hotelState);
				RegisteredHotel hotelInfo = flyEasy.getCurrentHotel();
				System.out.println("Hotel Name: "+hotelInfo.getHotelName());
				System.out.println("----Location---");
				System.out.println(" City: "+hotelInfo.getHotelCity()+" State: "+hotelInfo.getHotelState());
				System.out.println(" Room Type: "+hotelInfo.getRoomType()+" Room Number: "+hotelInfo.getOpenRoom());
				System.out.println(" Check-In Date: "+hotelInfo.getCheckInDate()+" Check-Out Date:"+hotelInfo.getCheckOutDate());
			}
			RegisteredUser userInformation = flyEasy.getCurrentUser();
			String confirm = "Yes";
			int beginIndex = 0;
			int endIndex = 4;
			System.out.println("-----Enter 'Yes' To Purchase---");
			System.out.print("--Enter 'No' will Return You To Main Menu-----");
			String userPurchase = scanner.nextLine();
			if(userPurchase.contentEquals(confirm)){
				try{
					String receiptFile = ("src/receipt.txt");
				//Scanner fileScanner = new Scanner(new File(receiptFile));
					PrintWriter fileWriter = new PrintWriter(new FileOutputStream(receiptFile));
				RegisteredHotel hotelInfo = flyEasy.getCurrentHotel();
				System.out.println("\n-----Checking out your Plane Ticket-----");
				//if(flyEasy.purchase(flyEasy.getCurrentFlight())){
					System.out.println("Enter Card Information:");
					System.out.println("Card Information On File: "+userInformation.getCardNum().codePointCount(beginIndex, endIndex));
					System.out.println("Enter Yes to Confirm Complete Purchase: ");
					String confirmPurchase = scanner.nextLine();
					if(confirmPurchase.contentEquals(confirm)){
					fileWriter.println("\n-------------Hotel Booking--------------------");
					fileWriter.println("Guest First Name: "+userInformation.getFirstName()+" Guest Last Name: "+userInformation.getLastName());
					fileWriter.println("Hotel Name: "+hotelInfo.getHotelName());
				    fileWriter.println("----Location---");
				    fileWriter.println(" City: "+hotelInfo.getHotelCity()+" State: "+hotelInfo.getHotelState());
				    fileWriter.println(" Room Type: "+hotelInfo.getRoomType()+" Room Number: "+hotelInfo.getOpenRoom());
				    fileWriter.println(" Check-In Date: "+hotelInfo.getCheckInDate()+" Check-Out Date:"+hotelInfo.getCheckOutDate());
					}
				  //}
				  fileWriter.close();
				  fileWriter.flush();
				}
				catch(Exception e){ e.printStackTrace();}
			   }
			else{
				System.out.println("Sorry Something went wrong");
			}	
	}
	public void findFlight() {
   
		System.out.println("Enter Desired Departure Date\n");
		String flightDepartureDate = getField("From When (ex. 00/00/00): ");
			if(flyEasy.findFlight(flightDepartureDate)){
				RegisteredFlight flightInfo = flyEasy.getCurrentFlight();
				System.out.println("Airline: "+flightInfo.getAirline()+"\n"+" Departure Date: "
				 +flightInfo.getFlightDepartureDate()+" Return Date: "+flightInfo.getFlightArrivalDate()+"\n"+" Departure Time: "+flightInfo.getDepartureTime());
				System.out.println("Arrival Time: "+flightInfo.getArrivalTime()+"\n"+" Gate: "+flightInfo.getGate()+"\n"+" Seats Left: "
				 +flightInfo.getSeats()+" Seat Column: "+flightInfo.getSeatColumn()+" Seat Row: "+flightInfo.getSeatRow()+"\n"+" Price: "+flightInfo.getPrice());
			}
			RegisteredUser userInformation = flyEasy.getCurrentUser();
		    RegisteredAirport airportInfo = flyEasy.getCurrentAirport();
			RegisteredAirport airportTwoInfo = flyEasy.getCurrentAirport();
			String confirm = "Yes";
			int beginIndex = 0;
			int endIndex = 4;
			System.out.println("-----Enter 'Yes' To Purchase---");
			System.out.print("--Enter 'No' will Return You To Main Menu-----");
			String userPurchase = scanner.nextLine();
			if(userPurchase.contentEquals(confirm)){
				try{
					String receiptFile = ("src/receipt.txt");
				//Scanner fileScanner = new Scanner(new File(receiptFile));
					PrintWriter fileWriter = new PrintWriter(new FileOutputStream(receiptFile));
				RegisteredFlight flightInfo = flyEasy.getCurrentFlight();
				System.out.println("\n-----Checking out your Plane Ticket-----");
				//if(flyEasy.purchase(flyEasy.getCurrentFlight())){
					System.out.println("Enter Card Information:");
					System.out.println("Card Information On File: "+userInformation.getCardNum().codePointCount(beginIndex, endIndex));
					System.out.println("Enter Yes to Confirm Complete Purchase: ");
					String confirmPurchase = scanner.nextLine();
					if(confirmPurchase.contentEquals(confirm)){
					fileWriter.println("\n-------------Plane Ticket--------------------");
					fileWriter.println("Passenger First Name: "+userInformation.getFirstName()+" Passenger Last Name: "+userInformation.getLastName());
					fileWriter.println("Departure Airport: "+airportInfo.getAirportName()+" "+airportInfo.getAirportCode());
					fileWriter.println("Arrival Airport: "+airportTwoInfo.getAirportName()+" "+airportTwoInfo.getAirportCode());
					fileWriter.println("Airline: "+flightInfo.getAirline());
					fileWriter.println(" Departure Date: "+flightInfo.getFlightDepartureDate()+" Return Date: "+flightInfo.getFlightArrivalDate());
					fileWriter.println(" Departure Time: "+flightInfo.getDepartureTime()+" Arrival Time: "+flightInfo.getArrivalTime());
					fileWriter.println(" Gate: "+flightInfo.getGate());
					fileWriter.println(" Seats Left: "+flightInfo.getSeats());
					fileWriter.println(" Seat Column: "+flightInfo.getSeatColumn()+" Seat Row: "+flightInfo.getSeatRow()+"\n"+" Price: "+flightInfo.getPrice());	
					}
				  //}
				  fileWriter.close();
				  fileWriter.flush();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			   }
			   if(flyEasy.getCurrentFlight().getSeats() >= 1){
				   RegisteredFlight flightInfo = flyEasy.getCurrentFlight();
					flyEasy.purchase(flightInfo);
		       } 	   
	}

    public static void main(String[] args){

        FlyEasyUI flyEasyInterface = new FlyEasyUI();
		flyEasyInterface.run();
		flyEasyInterface.runB();
		
        
    }
}
