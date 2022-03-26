import java.util.UUID;

public class RegisteredUser {
    private UUID id;
	private String userName;
	private String firstName;
	private String lastName;
    private String email;
    private String cardNum;

    public RegisteredUser(String userName, String firstName, String lastName, String email, String cardNum){
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNum = cardNum;
    }

    public RegisteredUser(UUID id, String userName, String firstName, String lastName, String email, String cardNum){
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNum = cardNum;
    }

    public UUID getId(){
        return id;
    }
    public String getUserName() {
		return userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setCardNum(String cardNum){
        this.cardNum = cardNum;
    }
    public String getCardNum(){
        return cardNum;
    }

}
