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
		
		Query q = entityManager.createQuery("SELECT count(u.mail) FROM User u WHERE u.mail = :userMail");
		q.setParameter("userMail", mail);
		
		int nbUserWithMail = q.getFirstResult();
		
		if (nbUserWithMail != 0) {
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
	
	public boolean updateUser(HttpSession session, User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			User oldUser = null;
			oldUser = (User)session.getAttribute(USER_KEY);
			
			if(oldUser != null) {
				User userToUpdate = (User)entityManager.find(oldUser.getClass(), 1);

				entityManager.getTransaction().begin();
				userToUpdate.setFirstname(user.getFirstname());
				userToUpdate.setLastname(user.getLastname());
				userToUpdate.setAddress(user.getAddress());
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
	
	public void logOut(HttpSession session ) {
		session.invalidate();
	}
	
	private EntityManager baseAccess() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
