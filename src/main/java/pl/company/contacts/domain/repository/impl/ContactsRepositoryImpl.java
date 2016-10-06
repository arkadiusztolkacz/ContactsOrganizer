package pl.company.contacts.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pl.company.contacts.domain.Contact;
import pl.company.contacts.domain.repository.ContactsRepository;

@Repository
public class ContactsRepositoryImpl implements ContactsRepository{

	private JdbcTemplate jdbcTemplate;
	private final String insertIntoContacts = "INSERT INTO contacts (idContacts, name, surname, company, email, phone)"
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	private final String selectAllContacts = "SELECT * FROM contacts";
	private final String updateContacts = "UPDATE contacts SET name=?, surname=?, company=?, email=?, phone=? "
			+ " WHERE idContacts=?";
	private final String deleteContact = "DELETE FROM contacts WHERE idContacts=?";

	private final String[] columnNames = { "idContacts", "name", "surname", "company", "email", "phone" };

	@Autowired
	public ContactsRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Contact> getContacts() {

		List<Contact> contactList = jdbcTemplate.query(selectAllContacts, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact c = new Contact();
				c.setId(rs.getInt(columnNames[0]));
				c.setFirstName(rs.getString(columnNames[1]));
				c.setLastName(rs.getString(columnNames[2]));
				c.setCompany(rs.getString(columnNames[3]));
				c.setEmail(rs.getString(columnNames[4]));
				c.setPhone(rs.getString(columnNames[5]));
				return c;
			}
		});

		return contactList;
	}

	public void addNewContact(Contact contact) {
		jdbcTemplate.update(insertIntoContacts, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getCompany(),
				contact.getEmail(), contact.getPhone());
	}

	public void updateContact(Contact contact) {
		jdbcTemplate.update(updateContacts, contact.getFirstName(), contact.getLastName(), contact.getCompany(),
				contact.getEmail(), contact.getPhone(), contact.getId());
	}

	public void deleteContact(Contact contact) {
		int contactId = contact.getId();
		jdbcTemplate.update(deleteContact, contactId);
	}
}
