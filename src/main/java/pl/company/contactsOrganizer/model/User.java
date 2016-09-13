package pl.company.contactsOrganizer.model;

public class User {

	private String userName;
	private String userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isAdmin(String authority) {
		return userRole.equals(authority);
	}
}
