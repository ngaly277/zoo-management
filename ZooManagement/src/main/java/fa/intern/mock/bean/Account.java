package fa.intern.mock.bean;

public class Account {
	private String Username;
	private String Password;
	private int ID_Account_Type;
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public int getID_Account_Type() {
		return ID_Account_Type;
	}
	
	public void setID_Account_Type(int iD_Account_Type) {
		ID_Account_Type = iD_Account_Type;
	}

	public Account(String username, String password, int iD_Account_Type) {
		super();
		Username = username;
		Password = password;
		ID_Account_Type = iD_Account_Type;
	}

	public Account() {
		super();
	}
	
	
}
