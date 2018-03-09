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
	
	public boolean connection(String login, String pwd, HttpSession session) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.mail = :userMail AND u.password = :userPwd");
		q.setParameter("userMail", login);
		q.setParameter("userPwd", pwd);
		
		User userResult = (User) q.getSingleResult();
		
		if ( !userResult.equals(null) )
		{
			session.setAttribute(USER_KEY, userResult.getMail());
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean updateUser(HttpSession session, User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Boolean result = false;
		try {
			User oldUser = null;
			oldUser = (User)session.getAttribute(USER_KEY);
			
			if(oldUser != null) {
				User userToUpdate = (User)entityManager.find(oldUser.getClass(), 1);
				result = true;
			}
			
		}catch(Exception ex) {
			result = false;
		}
		
		return result;
	}
}
