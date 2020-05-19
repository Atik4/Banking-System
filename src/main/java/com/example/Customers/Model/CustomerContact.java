package com.example.Customers.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable
public class CustomerContact {

	@NotNull(message="Address Line-1 can not be empty.")
	@Column(name="Address_Line_1")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Address Line-1 in correct format.")
	private String addressLine1;
	
	@NotNull(message="Address Line-1 can not be empty.")
	@Column(name="Address_Line_2")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Address Line-1 in correct format.")
	private String addressLine2;

	@NotNull(message="City cannot be null.")
	@Column(name="City")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter city in correct format.")
	private String city;
	
	@NotNull(message="ZIP Code can not be empty.")
	@Column(name="ZIP Code")
	@Pattern(regexp="^[0-9]{6}",message="Please enter 6-Digit ZIP Code.")
	private String zipCode;
	
	@NotNull(message="State can not be empty.")
	@Column(name="Country")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter State in correct format.")
	private String state;
	
	@NotNull(message="Country can not be empty.")
	@Column(name="Country")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Country in correct format.")
	private String country;
	
	@NotNull(message="Mobile_No must not be null")
	@Column(name="Mobile_No")
	@Pattern(regexp="^[0-9]{10}",message="Please enter 10-Digit Mobile No.")
	private String mobileNo;
	
	@NotNull(message="Email should not be missing")
	@Email(message="Email format should be like customer@db.com")
	@Column(name="Email")
	private String email;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
   

}
