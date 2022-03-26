import java.util.ArrayList;
public class UserList {
    private static UserList users;
	private ArrayList<RegisteredUser> userList;
	
	private UserList() {
		userList = DataLoader.getUsers();
	}
	
	public static UserList getInstance() {
		if(users == null) {
			users = new UserList();
		}
		
		return users;
	}

	public boolean haveUser(String userName) {
		for(RegisteredUser user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public RegisteredUser getUser(String userName) {
		for(RegisteredUser user : userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}
	
	public ArrayList<RegisteredUser> getUsers() {
		return userList;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, String email, String cardNum) {
		if(haveUser(userName))return false;
		
		userList.add(new RegisteredUser(userName, firstName, lastName, email, cardNum));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}
