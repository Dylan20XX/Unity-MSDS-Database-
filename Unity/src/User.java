import javax.swing.JTextArea;

public class User {
	
	private String user;
	private String pass;
	
	public User(String user, String pass) {
		
		this.user = user;
		this.pass = pass;
		
	}

	public User() {
	}
	
	@Override
	public String toString() {
		return "User [user=" + user + ", pass=" + pass + "]";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
