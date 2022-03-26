import java.util.UUID;

public class RegisteredAirport {
    //private static  airports;
    private UUID airportid;
    private String state;
    private String city;
    private String airportName;
    private String airportCode;

    public RegisteredAirport(String state, String city, String airportName, String airportCode){
        this.airportid = UUID.randomUUID();
        this.state = state;
        this.city = city;
        this.airportName = airportName;
        this.airportCode = airportCode;
    }
    public RegisteredAirport(UUID airportid, String state, String city, String airportName, String airportCode){
        this.airportid = airportid;
        this.state = state;
        this.city = city;
        this.airportName = airportName;
        this.airportCode = airportCode;
    }
    public UUID getId(){
        return airportid;
    }
    public String getState(){
        return state;
    }
    public String getCity(){
        return city;
    }
    public String getAirportName(){
        return airportName;
    }
    public String getAirportCode(){
        return airportCode;
    }
    public void setState(String state){
        this.state = state;
    }  
    public void setCity(String city){
        this.city = city;
    }
    public void setAirportName(String airportName){
        this.airportName = airportName;
    }
    public void setAirportCode(String airportCode){
        this.airportCode = airportCode;
    }
}
