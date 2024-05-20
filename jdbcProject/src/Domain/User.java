package Domain;

public class User {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String phoneNum;
	private String email;
	
	public User(Long id, String username, String password, String name, String phoneNum, String email){
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.name = phoneNum;
		this.email = email;
	}
	
	
	public User(String username, String password, String name, String phoneNum, String email){
		this(null, username, password, name, phoneNum, email);
	}
	
	
	
}
