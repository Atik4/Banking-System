package com.example.Customers.Model;

import java.util.Date;

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
	
	@NotNull(message="First_Name must not be empty")
	@Column(name="First_Name")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter First Name in correct format.")
	private String firstName;
	
	@NotNull(message="Last_Name must not be empty")
	@Column(name="Last_Name")
	@Pattern(regexp="^[A-Za-z]+",message="Please enter Last Name in correct format.")
	private String lastName;
	
	@NotNull(message="Date should not be null.")
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@NotNull(message="Aadhaar Number must not be empty")
	@Column(name="Aadhaar_No")
	@Pattern(regexp="^[0-9]{12}",message="Please enter Aadhaar Number in correct format.")
	private String aadharNo;
	
	@NotNull(message="PAN Number must not be empty")
	@Column(name="PAN_No")
	@Pattern(regexp="^[A-Za-z0-9]{10}",message="Please enter PAN Number in correct format.")
	private String panNo;
	
    @Embedded
    private CustomerContact customerContact;

   
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	
	public String getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getPanNo() {
		return panNo;
	}


	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", customerContact=" + customerContact + "]";
	}

	
		
}
