package org.soen387.bean;

// Bean object for accounts

public class User {
	
	 public String userId;
	 public String firstName;
	 public String lastName;
	 public String email;
	 public String password;
	 public String confirm;
	 public String address1;
	 public String address2;
	 public String city;
	 public String state;
	 public String zip;
	 public String country;
	 public String credit_card_type;
	 public String credit_card_number;
	 public String credit_card_cvv;
	 public String credit_Card_expiry;
	 
	public User(){}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCredit_card_number() {
		return credit_card_number;
	}

	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}

	public String getCredit_card_cvv() {
		return credit_card_cvv;
	}

	public void setCredit_card_cvv(String credit_card_cvv) {
		this.credit_card_cvv = credit_card_cvv;
	}

	public String getCredit_Card_expiry() {
		return credit_Card_expiry;
	}

	public void setCredit_Card_expiry(String credit_Card_expiry) {
		this.credit_Card_expiry = credit_Card_expiry;
	}

	public String getCredit_card_type() {
		return credit_card_type;
	}
	public void setCredit_card_type(String credit_card_type) {
		this.credit_card_type = credit_card_type;
	}
	 
}

