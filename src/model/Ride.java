package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
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
	private String googleRide;

	private byte isChildsAllowed;

	private byte isMusicAllowed;

	private byte isSmokerAllowed;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private Time startTime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_driver")
	private User driver;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="ridesAsPassenger")
	private List<User> passengers;

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

	public String getGoogleRide() {
		return this.googleRide;
	}

	public void setGoogleRide(String googleRide) {
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public User getDriver() {
		return this.driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public List<User> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}

}