package pl.company.contacts.domain;

import org.hibernate.validator.constraints.Length;

public class Contact implements Comparable<Contact> {

	private int id;

	@Length(min = 2, max = 30, message = "Please input first name with {min} to {max} characters.")
	private String firstName;
	@Length(min = 2, max = 30, message = "Please input last name with {min} to {max} characters.")
	private String lastName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void updateContactFields(Contact c) {
		setFirstName(c.getFirstName());
		setLastName(c.getLastName());
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
