package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the passenger database table.
 * 
 */
@Entity
@Table(name="passenger")
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PassengerPK id;

	//bi-directional many-to-one association to Ride
	@ManyToOne
	@JoinColumn(name="id_ride")
	private Ride ride;

	public Passenger() {
	}

	public PassengerPK getId() {
		return this.id;
	}

	public void setId(PassengerPK id) {
		this.id = id;
	}

	public Ride getRide() {
		return this.ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

}