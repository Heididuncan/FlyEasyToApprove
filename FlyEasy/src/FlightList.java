import java.util.ArrayList;

public class FlightList {
    private static FlightList flights;
    private ArrayList<RegisteredFlight> flightList;
	
	private FlightList() {
		flightList = FlightDataLoader.getFlights();
	}
	
	public boolean addFlight(String airline, String flightDepartureDate, 
    String flightArrivalDate, String departureTime, String arrivalTime, String gate, 
    int steats, String seatColumn, String seatRow, int price) {
        // I dont know if we care about this, well especially not yet
        //if(haveFlight(airline, flightDepartureDate, flightArrivalDate,
               // departureTime, arrivalTime, steats, seatColumn, seatRow))return false;
        //if(haveFlight(flightDepartureDate))return false;
		
		flightList.add(new RegisteredFlight(airline, flightDepartureDate, flightArrivalDate,
                departureTime, arrivalTime, gate, steats, seatColumn, seatRow, price));
		return true;
    }

    public static FlightList getInstance() {
		if(flights == null) {
			flights = new FlightList();
		}
		
		return flights;
	}

	public boolean haveFlight(String departureDate) {
		for(RegisteredFlight flight : flightList) {
			if(flight.getFlightDepartureDate().equals(departureDate)) {
				return true;
			}
		}
		
		return false;
	}
	
	public RegisteredFlight getFlight(String departureDate) {
		for(RegisteredFlight flight : flightList) {
			if(flight.getFlightDepartureDate().equals(departureDate)) {
				return flight;
			}
		}
		
		return null;
	}
	
	public ArrayList<RegisteredFlight> getFlights() {
		return flightList;
	}

    public void saveFlights() {
        FlightDataWriter.saveFlights();
    }
}
