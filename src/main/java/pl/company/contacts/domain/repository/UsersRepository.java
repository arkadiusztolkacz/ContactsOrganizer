package pl.company.contacts.domain.repository;

import java.util.List;

import pl.company.contacts.domain.User;

public interface UsersRepository {

	public List<User> getUsers();
	public List<String> getAuthorities();
}
