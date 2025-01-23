package com.icsd.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "address")
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private int customerId;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String emailId;
    private String contactNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressfkk", referencedColumnName = "addressid")
    @Transient
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String password;
    private String confirmPassword;
    private LocalDate registerationDate;

    @OneToMany(targetEntity = Account.class, mappedBy = "customer")
    private List<Account> accounts = new ArrayList<>();
}
/*
@Entity
public class Customer 
{
	
	@Id
    @GeneratedValue
	int customerId;
	String firstName;
	String lastName;
	
	@Column(unique=true)
	String emailId;
	String contactNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressfkk",referencedColumnName = "addressid")
	@Transient
	Address address;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	String password;
	String confirmPassword;
	private LocalDate registerationDate;
	
	
	@OneToMany(targetEntity = Account.class, mappedBy = "customer")
	private List<Account> accoutns=new ArrayList();
	
	
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String firstName, String lastName, String emailId, String contactNo,
			Address address, Gender gender, String password, String confirmPassword, LocalDate registerationDate,
			List<Account> accoutns) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.registerationDate = registerationDate;
		this.accoutns = accoutns;
	}
	public Customer(int customerId, String firstName, String lastName, String emailId, String contactNo,
			Address address, Gender gender, String password, String confirmPassword, LocalDate registerationDate
			) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.registerationDate = registerationDate;
	
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", address=" + address + ", gender=" + gender
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", registerationDate="
				+ registerationDate + ", accoutns=" + accoutns + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getRegisterationDate() {
		return registerationDate;
	}
	public void setRegisterationDate(LocalDate registerationDate) {
		this.registerationDate = registerationDate;
	}
	public List<Account> getAccoutns() {
		return accoutns;
	}
	public void setAccoutns(List<Account> accoutns) {
		this.accoutns = accoutns;
	}
	
	}
	
	*/
	
	



