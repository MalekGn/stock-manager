package com.esprit.stockmanager.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esprit.stockmanager.enums.Role;
import com.esprit.stockmanager.utils.SpecificAttributeConverter;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -1554479042813302940L;

	@Id
	@Column(name = "card_id", length = 8, updatable = false)
	private String cardId;

	@Column(name = "first_name", nullable = false, length = 50)
	String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "phone_numbers")
	@Convert(converter = SpecificAttributeConverter.class)
	private Set<String> phoneNumbers;

	@Column(name = "role", nullable = false, length = 15)
	private Role role;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "employee")
	private List<Operation> operations;

	public Employee() {
		// constructor from super class
	}

	public Employee(String cardId, String firstName, String lastName, Date dateOfBirth, Set<String> phoneNumbers,
			Role role, String password) {
		this.cardId = cardId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumbers = phoneNumbers;
		this.role = role;
		this.password = password;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Operation> getOperations() {
		if (operations == null) {
			operations = new ArrayList<>();
		}
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
