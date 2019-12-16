package Objects;

import javax.swing.JTextArea;
/**
 * 
 * @author Momin
 *
 */
public class User {
	/**
	 * This class creates new user objects
	 * @param user, pass
	 */
	private String user;
	private String pass;
	
	/**
	 * 
	 * This is the constructor method
	 * @param user
	 * @param pass
	 */
	public User(String user, String pass) {
		
		this.user = user;
		this.pass = pass;
		
	}
	/**
	 * This is the constructor method
	 * @param null
	 */
	public User() {
	}
	
	@Override
	/**
	 * This method creates a toString
	 * @param null
	 */
	public String toString() {
		return "User [user=" + user + ", pass=" + pass + "]";
	}

	public String getUser() {
		return user;
	}
	/**
	 * This method creates a username
	 * @param null
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}
	/**
	 * This method creates a password
	 * @param null
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

}
