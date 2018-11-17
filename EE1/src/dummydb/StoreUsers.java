package dummydb;

import java.util.ArrayList;

import java.util.List;

public class StoreUsers {
	private static StoreUsers stru=null;

	private List<User> users;
	

	private StoreUsers(){
		
			users= new  ArrayList<>();
	}

	public void addUser(String name,String email,String password) {
		users.add(new User(name,email,password));
	}
	
	public User getUser(int i) {
		return users.get(i);
	}
	public List<User>getList(){
		return users;
	}
	
	public static StoreUsers getInstance() {
		if (stru==null) {
			stru=new StoreUsers();
		}
		return stru;
	}
}