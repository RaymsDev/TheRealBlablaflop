package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import model.User;

public class UserManager {
	
	public UserManager() {
		super();
	}
	
	private final static String USER_KEY = "UserSession";

	public boolean exist(String mail) {
		EntityManager entityManager = baseAccess();
		
		String jpqa = "SELECT COUNT(u.mail) FROM User u WHERE u.mail = :usermail";
		Query q = entityManager.createQuery(jpqa);
		q.setParameter("usermail", mail);
		
		long nbUserWithMail = Long.parseLong(q.getSingleResult().toString());
		
		if (nbUserWithMail == 0.0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean connection(String login, String pwd, HttpSession session) {
		EntityManager entityManager = baseAccess();
		
		Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.mail = :userMail AND u.password = :userPwd");
		q.setParameter("userMail", login);
		q.setParameter("userPwd", pwd);
		
		try {
			User userResult = (User) q.getSingleResult();
			session.setAttribute(USER_KEY, userResult);

			return true;
		} catch ( Exception e) {
			return false;
		}
	}
	
	public boolean updateUser(HttpSession session, User updatedUser) {
		EntityManager entityManager = baseAccess();
		boolean result = false;
		try {
			User oldUser = null;
			oldUser = (User)session.getAttribute(USER_KEY);
			
			if(oldUser != null) {
				User userToUpdate = (User)entityManager.find(oldUser.getClass(), oldUser);

				entityManager.getTransaction().begin();
				userToUpdate.setFirstname(updatedUser.getFirstname());
				userToUpdate.setLastname(updatedUser.getLastname());
				userToUpdate.setAddress(updatedUser.getAddress());
				entityManager.getTransaction().commit();

				result = true;
			}
			
		}catch(Exception ex) {
			result = false;
		}
		
		return result;
	}
	
	public User connectedUser( HttpSession session) {
		try {
			User connectedUser = (User) session.getAttribute(USER_KEY);
			return connectedUser;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void delete(HttpSession session ) {
		EntityManager entityManager = baseAccess();
		User userToDelete = connectedUser(session);
		
		entityManager.getTransaction().begin();
		entityManager.remove(userToDelete);
		entityManager.getTransaction().commit();
	}
	
	public void logOut(HttpSession session ) {
		session.invalidate();
	}
	
	private EntityManager baseAccess() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
