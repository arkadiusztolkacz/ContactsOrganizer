package pl.company.contactsOrganizer.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pl.company.contactsOrganizer.model.User;

@Repository
public class UsersDAO {

	private JdbcTemplate jdbcTemplate;

	private final String[] usersColumnNames = { "username", "authority" };
	private final String authoritiesColumnName = "authority";
	private final String selectAllUsers = "SELECT u.username, r.authority FROM users u "
			+ "JOIN user_roles r ON(u.user_role_id = r.user_role_id)";
	private final String selectAuthorities = "SELECT DISTINCT authority FROM user_roles ORDER BY user_role_id";

	@Autowired
	public UsersDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<User> getUsers() {

		List<User> usersList = jdbcTemplate.query(selectAllUsers, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setUserName(rs.getString(usersColumnNames[0]));
				u.setUserRole(rs.getString(usersColumnNames[1]));
				return u;
			}
		});

		return usersList;
	}

	public List<String> getAuthorities() {

		List<String> authorities = jdbcTemplate.query(selectAuthorities, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String authority = rs.getString(authoritiesColumnName);
				return authority;
			}
		});

		return authorities;
	}
}
