package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

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
	
	public void postRide(Ride ride) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
 		EntityManager entityManager = entityManagerFactory.createEntityManager();
 		entityManager.getTransaction().begin();

 		entityManager.persist(ride);

 		entityManager.getTransaction().commit();
 	    entityManager.close();
 	    entityManagerFactory.close();

	}
	
}
