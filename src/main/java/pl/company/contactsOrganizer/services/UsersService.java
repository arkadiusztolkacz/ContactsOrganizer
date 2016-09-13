package pl.company.contactsOrganizer.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.company.contactsOrganizer.model.User;

@Component
public class UsersService {

	private User loggedUser;
	private List<User> usersList;
	private List<String> authorities;

	@Autowired
	private UsersDAO usersDAO;

	@PostConstruct
	private void getUsersAndAuthoritiesFromDatabase() {
		loggedUser = new User();
		usersList = usersDAO.getUsers();
		authorities = usersDAO.getAuthorities();
	}

	public List<User> findCurrentUsers() {

		return usersList;
	}

	public boolean isUserAdmin() {
		return loggedUser.isAdmin(getAdminAuthority());
	}

	public void setAuthority(String userName) {
		loggedUser.setUserName(userName);
		for (User u : usersList) {
			if (u.getUserName().equals(userName)) {
				loggedUser.setUserRole(u.getUserRole());
			}
		}
	}

	public void logoutUser() {
		loggedUser.setUserName("");
		loggedUser.setUserRole("");
	}

	private String getAdminAuthority() {
		return authorities.get(0);
	}
}
