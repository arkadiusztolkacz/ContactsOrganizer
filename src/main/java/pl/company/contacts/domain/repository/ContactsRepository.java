package pl.company.contacts.domain.repository;

import java.util.List;

import pl.company.contacts.domain.Contact;

public interface ContactsRepository {

	public List<Contact> getContacts();
	public void addNewContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
}
