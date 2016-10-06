package pl.company.contacts.services;

import java.util.List;

import pl.company.contacts.domain.User;

public interface UsersService {

	public List<User> findCurrentUsers();
	public boolean isUserAdmin();
	public void setAuthority(String userName);
	public void logoutUser();
}
