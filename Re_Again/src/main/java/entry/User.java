package entry;

public class User {
	private int id;
	private String name;
	private String pass;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}	
