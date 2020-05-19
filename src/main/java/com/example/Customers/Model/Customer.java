package com.example.Customers.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customers")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="Customer_Id")
	private Long id;
	
	@NotNull(message="First_Name must not be null")
	@Column(name="First_Name")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter First Name in correct format.")
	private String firstName;
	
	@NotNull(message="Last_Name must not be null")
	@Column(name="Last_Name")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Last Name in correct format.")
	private String lastName;
	
	@NotNull(message="Mobile_No must not be null")
	@Column(name="Mobile_No")
	@Pattern(regexp="^[0-9]{10}",message="Please enter 10-Digit Mobile No.")
	private String mobileNo;
	
	@Column(name="Country")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Country in correct format.")
	private String country;

	
	public Customer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", country=" + country + "]";
	}
	
}
