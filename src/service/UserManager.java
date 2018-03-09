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
	
	public boolean connection(String login, String pwd, HttpSession session) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.mail = :userMail AND u.password = :userPwd");
		q.setParameter("userMail", login);
		q.setParameter("userPwd", pwd);
		
		User userResult = (User) q.getSingleResult();
		
		if ( !userResult.equals(null) )
		{
			session.setAttribute("UserSession", userResult.getMail());
			return true;
		}
		else 
		{
			return false;
		}
	}
}
