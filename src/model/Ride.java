package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ride database table.
 * 
 */
@Entity
@Table(name="ride")
@NamedQuery(name="Ride.findAll", query="SELECT r FROM Ride r")
public class Ride implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int conversationLevel;

	@Column(name="google_ride")
	private Object googleRide;

	private byte isChildsAllowed;

	private byte isMusicAllowed;

	private byte isSmokerAllowed;

	//bi-directional many-to-one association to Passenger
	@OneToMany(mappedBy="ride")
	private List<Passenger> passengers;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_driver")
	private User user;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="rides")
	private List<User> users;

	public Ride() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConversationLevel() {
		return this.conversationLevel;
	}

	public void setConversationLevel(int conversationLevel) {
		this.conversationLevel = conversationLevel;
	}

	public Object getGoogleRide() {
		return this.googleRide;
	}

	public void setGoogleRide(Object googleRide) {
		this.googleRide = googleRide;
	}

	public byte getIsChildsAllowed() {
		return this.isChildsAllowed;
	}

	public void setIsChildsAllowed(byte isChildsAllowed) {
		this.isChildsAllowed = isChildsAllowed;
	}

	public byte getIsMusicAllowed() {
		return this.isMusicAllowed;
	}

	public void setIsMusicAllowed(byte isMusicAllowed) {
		this.isMusicAllowed = isMusicAllowed;
	}

	public byte getIsSmokerAllowed() {
		return this.isSmokerAllowed;
	}

	public void setIsSmokerAllowed(byte isSmokerAllowed) {
		this.isSmokerAllowed = isSmokerAllowed;
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Passenger addPassenger(Passenger passenger) {
		getPassengers().add(passenger);
		passenger.setRide(this);

		return passenger;
	}

	public Passenger removePassenger(Passenger passenger) {
		getPassengers().remove(passenger);
		passenger.setRide(null);

		return passenger;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}