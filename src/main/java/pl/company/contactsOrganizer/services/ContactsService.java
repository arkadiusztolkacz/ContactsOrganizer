package pl.company.contactsOrganizer.services;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.company.contactsOrganizer.model.Contact;

@Component
public class ContactsService {

	private List<Contact> contactList;

	@Autowired
	private ContactsDAO contactDAO;

	@PostConstruct
	public void getInitialContactsFromDatabase() {
		contactList = contactDAO.getContacts();

	}

	public List<Contact> findCurrentContacts() {
		return contactList;
	}

	public Contact getContact(int id) {
		for (Contact contact : contactList) {
			if (id == contact.getId())
				return contact;
		}
		return null;
	}

	public void addNewContact(Contact contact) {
		int id = getNextId();
		contact.setId(id);
		contactList.add(contact);

		contactDAO.addNewContact(contact);

	}

	public void updateContact(Contact contact) {
		int id = contact.getId();
		for (Contact currentContact : contactList) {
			int currentId = currentContact.getId();
			if (id == currentId) {

				currentContact.updateContactFields(contact);
				contactDAO.updateContact(currentContact);
			}
		}
	}

	public void removeContact(Contact contact) {
		contactList.remove(contact);
		contactDAO.deleteContact(contact);
	}

	private int getNextId() {
		int nextId = Collections.max(contactList).getId() + 1;
		return nextId;
	}
}
