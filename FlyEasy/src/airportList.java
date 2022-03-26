import java.util.ArrayList;
public class airportList {

    private static airportList airports;
    private ArrayList<RegisteredAirport> airportsList;
	
	private airportList() {
		airportsList = airportDataLoader.getAirports();
	}
	
	public boolean addAirport(String state, String city, String airportName, String airportCode) {
        if(haveAirport(city, state))return false;
		
		airportsList.add(new RegisteredAirport(state, city, airportName, airportCode));
		return true;
    }

    public static airportList getInstance() {
		if(airports == null) {
			airports = new airportList();
		}
		
		return airports;
	}

	public boolean haveAirport(String city, String state) {
		for(RegisteredAirport airport : airportsList) {
			for(airport.getCity().equals(city); airport.getState().equals(state);) {
				return true;
			}
		}
		
		return false;
	}
	
	public RegisteredAirport getAirport(String city, String state) {
		for(RegisteredAirport airport : airportsList) {
			for(airport.getCity().equals(city); airport.getState().equals(state);) {
				return airport;
			}
		}
		
		return null;
	}
	
	public ArrayList<RegisteredAirport> getAirports() {
		return airportsList;
	}

    public void saveAirports() {
        AirportDataWriter.saveAirports();
    }


}
