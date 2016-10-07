package pl.company.contacts.services.impl;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pl.company.contacts.domain.Contact;
import pl.company.contacts.domain.repository.ContactsRepository;
import pl.company.contacts.services.ContactsService;

@Service
public class ContactsServiceImpl implements ContactsService {

	private List<Contact> contactList;

	@Autowired
	private ContactsRepository contactsRepository;

	@PostConstruct
	private void getInitialContactsFromDatabase() {
		contactList = contactsRepository.getContacts();

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

		contactsRepository.addNewContact(contact);
		getInitialContactsFromDatabase();
	}

	public void updateContact(Contact contact) {
		int id = contact.getId();
		for (Contact currentContact : contactList) {
			int currentId = currentContact.getId();
			if (id == currentId) {
				currentContact.updateContactFields(contact);
				contactsRepository.updateContact(currentContact);
			}
		}
	}

	public void removeContact(Contact contact) {
		contactList.remove(contact);
		contactsRepository.deleteContact(contact);
	}

	private int getNextId() {
		int nextId = Collections.max(contactList).getId() + 1;
		return nextId;
	}

	public void attachContactPic(Contact contact, String rootDirectory) {
		MultipartFile profilePic = contact.getProfilePic();
		File destFile = new File(rootDirectory + "resources\\images\\" + contact.getId() + ".png");

		try {
			if (profilePic != null && !profilePic.isEmpty()) {
				profilePic.transferTo(destFile);
			}
		} catch (Exception e) {

		}

	}
}
