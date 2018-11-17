package dbo;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnector {
	private Connection connection = null;


	private Connection establishConnection() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db", "root", "12345678");
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public boolean addUser(String name,String email,String password) {
		User u=new User(name,email,password);
		if(connection==null)
			connection=establishConnection();
		
		try {
			Statement smt=connection.createStatement();
			String sql="insert into users (name,email,password) values('" +u.getName()+"','"
					+u.getEmail()+"','"+u.getPassword()+"')";
			int i=smt.executeUpdate(sql);
			if(i==1) return true;

		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean validateEmailandPassword(String email,String password) {
		if(connection==null)
			connection=establishConnection();
	
		
		try {
			Statement smt=connection.createStatement();
			ResultSet rs = smt.executeQuery("select * from Users");
			while (rs.next()) {
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));

				if (email.equals(rs.getString(3))&& password.equals(rs.getString(4)))
					return true;
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+rs.getString(3));
		}
			return false;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
