package com.deloitte.server.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "UNAME", length = 30, unique = true)
	private String username;
	@Column(name = "UPASS", length = 20)
//	@JsonIgnore
	private String password;
	@Column(name = "FNAME", length = 20)
	private String firstname;
	@Column(name = "LNAME", length = 20)
	private String lastname;
	@Column(name = "DOB")
	private LocalDate dob;
	@Column(name = "GENDER", length = 6)
	private String gender;
	@Column(name = "COUNTRY", length = 10)
	private String country;
	@Column(name = "ADM")
	private Boolean isAdmin;
	@ManyToMany
	@Column(name = "FAVS")
	private List<Product> favourites;

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Product> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Product> favourites) {
		this.favourites = favourites;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", gender=" + gender + ", country=" + country + ", favourites="
				+ favourites + "]";
	}
}
