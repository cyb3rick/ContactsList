package net.skillfullearning.contactslist;

public class Contact implements Comparable<Contact> {
	private String firstname = "";
	private String lastname = "";
	private String cellphone = "";
	private String workphone = "";
	private String email = "";
	
	public Contact(String firstname) {
		this.firstname = firstname;
	}
		
	public Contact(String firstname, String lastname, String cellphone,
			String workphone, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.cellphone = cellphone;
		this.workphone = workphone;
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Contact another) {		
		// Compare firstnames
		int result = this.firstname.compareTo(another.firstname);
		if (result == 0) { // firstnames are same, compare lastnames
			result = this.lastname.compareTo(another.lastname);
		}
		return result;
	}
	
	public boolean equals(Contact another) {		
		// If they have equal fullnames, they are the same contact
		return this.firstname.compareTo(another.firstname) == 0 && 
				this.lastname.compareTo(another.lastname) == 0;		
	}
	
	@Override
 	public String toString() {
 		return this.firstname + " " + this.lastname;
 	}
	
	
}
