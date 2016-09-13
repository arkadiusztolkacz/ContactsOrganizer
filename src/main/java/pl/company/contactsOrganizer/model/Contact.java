package pl.company.contactsOrganizer.model;

import org.hibernate.validator.constraints.Length;

public class Contact implements Comparable<Contact> {

	private int id;

	@Length(min = 2, max = 30, message = "Please input name with {min} to {max} characters.")
	private String name;
	@Length(min = 2, max = 30, message = "Please input surname with {min} to {max} characters.")
	private String surname;
	@Length(min = 2, max = 30, message = "Please input company with {min} to {max} characters.")
	private String company;
	@Length(min = 2, max = 30, message = "Please input email with {min} to {max} characters.")
	private String email;
	@Length(max = 9, message = "Please input valid phone number.")
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surName) {
		this.surname = surName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "Contact [name=" + name + ", surName=" + surname + ", company=" + company + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	public void updateContactFields(Contact c) {
		setName(c.getName());
		setSurname(c.getSurname());
		setCompany(c.getCompany());
		setEmail(c.getEmail());
		setPhone(c.getPhone());
	}

	@Override
	public int compareTo(Contact other) {
		Integer compareId = new Integer(id);
		Integer otherCompareId = new Integer(other.getId());

		return compareId.compareTo(otherCompareId);
	}
}
