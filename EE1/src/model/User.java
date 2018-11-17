package model;

public class User {
//	public static int id=1;
	private String name;
	private String email;
	private String password;
	
	 public User(String name, String email, String password) {
//		id++;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	

}
