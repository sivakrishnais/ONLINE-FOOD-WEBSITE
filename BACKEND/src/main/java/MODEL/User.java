package MODEL;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String addresss;
	private String role;
	
	public User() {
		
	}
	 
	
	
	
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param email
	 * @param addresss
	 * @param role
	 */
	public User(int userId, String userName, String password, String email, String addresss, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.addresss = addresss;
		this.role = role;
	}




	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return addresss;
	}
	public void setAddress(String addresss) {
		this.addresss = addresss;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", addresss=" + addresss + ", role=" + role + "]";
	}
}
