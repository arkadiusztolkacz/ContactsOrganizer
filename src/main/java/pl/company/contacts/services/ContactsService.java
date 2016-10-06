package pl.company.contacts.services;

import java.util.List;

import pl.company.contacts.domain.Contact;

public interface ContactsService {

	public List<Contact> findCurrentContacts();
	public Contact getContact(int id);
	public void addNewContact(Contact contact);
	public void updateContact(Contact contact);
	public void removeContact(Contact contact);
}
