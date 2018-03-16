package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the passenger database table.
 * 
 */
@Embeddable
public class PassengerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_ride", insertable=false, updatable=false)
	private int idRide;

	@Column(name="id_user", insertable=false, updatable=false)
	private int idUser;

	public PassengerPK() {
	}
	public int getIdRide() {
		return this.idRide;
	}
	public void setIdRide(int idRide) {
		this.idRide = idRide;
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PassengerPK)) {
			return false;
		}
		PassengerPK castOther = (PassengerPK)other;
		return 
			(this.idRide == castOther.idRide)
			&& (this.idUser == castOther.idUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRide;
		hash = hash * prime + this.idUser;
		
		return hash;
	}
}