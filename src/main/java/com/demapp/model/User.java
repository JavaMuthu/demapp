package com.demapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "tbl_user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	
	@javax.persistence.Transient
	private String newPassword;
	
	@javax.persistence.Transient
	private String confirmPassword;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private String zipCode;
	
	@Column(name = "country")
	private String country;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getNewPassword() 
	{
		return newPassword;
	}

	public void setNewPassword(String newPassword) 
	{
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() 
	{
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) 
	{
		this.confirmPassword = confirmPassword;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public int getActive() 
	{
		return active;
	}

	public void setActive(int active) 
	{
		this.active = active;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getZipCode() 
	{
		return zipCode;
	}

	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public Set<Role> getRoles() 
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
}
