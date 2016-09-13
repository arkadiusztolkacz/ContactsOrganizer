package pl.company.contactsOrganizer.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pl.company.contactsOrganizer.model.Contact;

@Component
public class ContactsDAO {

	private JdbcTemplate jdbcTemplate;
	private final String insertIntoContacts = "INSERT INTO contacts (idContacts, name, surname, company, email, phone)"
			+ " VALUES (null, ?, ?, ?, ?, ?)";
	private final String selectAllContacts = "SELECT * FROM contacts";
	private final String updateContacts = "UPDATE contacts SET name=?, surname=?, company=?, email=?, phone=? "
			+ " WHERE idContacts=?";
	private final String deleteContact = "DELETE FROM contacts WHERE idContacts=?";

	private final String[] columnNames = { "idContacts", "name", "surname", "company", "email", "phone" };

	@Autowired
	public ContactsDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Contact> getContacts() {

		List<Contact> contactList = jdbcTemplate.query(selectAllContacts, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact c = new Contact();
				c.setId(rs.getInt(columnNames[0]));
				c.setName(rs.getString(columnNames[1]));
				c.setSurname(rs.getString(columnNames[2]));
				c.setCompany(rs.getString(columnNames[3]));
				c.setEmail(rs.getString(columnNames[4]));
				c.setPhone(rs.getString(columnNames[5]));
				return c;
			}
		});

		return contactList;
	}

	public void addNewContact(Contact contact) {
		jdbcTemplate.update(insertIntoContacts, contact.getName(), contact.getSurname(), contact.getCompany(),
				contact.getEmail(), contact.getPhone());
	}

	public void updateContact(Contact contact) {
		jdbcTemplate.update(updateContacts, contact.getName(), contact.getSurname(), contact.getCompany(),
				contact.getEmail(), contact.getPhone(), contact.getId());
	}

	public void deleteContact(Contact contact) {
		int contactId = contact.getId();
		jdbcTemplate.update(deleteContact, contactId);
	}
}
