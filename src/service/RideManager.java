package service;

import java.util.List;

import model.Ride;
import model.User;

public class RideManager {
	public List<Ride> getRides(User driver){
		try {
			List<Ride> rides = driver.getRidesAsDriver();
			return rides;
		}catch(Exception ex) {
			return null;
		}
	}
}
