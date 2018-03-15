package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String firstname;

	private String lastname;

	private String mail;

	private String password;

	//bi-directional many-to-one association to Ride
	@OneToMany(mappedBy="user")
	private List<Ride> driver;

	//bi-directional many-to-many association to Ride
	@ManyToMany
	@JoinTable(
		name="passenger"
		, joinColumns={
			@JoinColumn(name="id_user")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_ride")
			}
		)
	private List<Ride> rides;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ride> getDriver() {
		return this.driver;
	}

	public void setDriver(List<Ride> driver) {
		this.driver = driver;
	}

	public Ride addDriver(Ride driver) {
		getDriver().add(driver);
		driver.setUser(this);

		return driver;
	}

	public Ride removeDriver(Ride driver) {
		getDriver().remove(driver);
		driver.setUser(null);

		return driver;
	}

	public List<Ride> getRides() {
		return this.rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

}