package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserManager;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public static String VIEW_PAGES_URL="/WEB-INF/register.jsp";
    public static String ACCUEIL_PAGE_URL="/index.jsp";

    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_NOM = "nom";
    public static final String FIELD_PRENOM = "prenom";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_PWD = "pwd1";
    public static final String FIELD_CONFIRM_PWD = "pwd2";
    
    public static final String MAIL_EARLY_EXIST = "User with this mail early exist";

	public static final String ATT_USERS = "users";

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	super.init();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errorStatus", true);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form fields
        String email = request.getParameter(FIELD_EMAIL);
        String password = request.getParameter(FIELD_PWD);
        String pwdConfirmation = request.getParameter(FIELD_CONFIRM_PWD);
        String nom = request.getParameter(FIELD_NOM);
        String prenom = request.getParameter(FIELD_PRENOM);
        String address = request.getParameter(FIELD_ADDRESS);

        // Prepare results
        Map<String, String> erreurs = new HashMap<String, String>();
        Map<String, String> form = new HashMap<String, String>();
        String actionMessage=null;
        String msgVal=null;

        msgVal=validateEmail(email);
        if(msgVal==null){
        	form.put(FIELD_EMAIL, email);
        }
        else{
            erreurs.put(FIELD_EMAIL, msgVal);
        }

        msgVal=validatePwd(password, pwdConfirmation);
        if(msgVal==null){
        	form.put(FIELD_PWD, password);
        }
        else{
            erreurs.put(FIELD_CONFIRM_PWD, msgVal);
        }
        
        UserManager userManager = new UserManager();
                
        if( !userManager.exist(email) ) {
        	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Blablaflop");
    		EntityManager entityManager = entityManagerFactory.createEntityManager();
    		entityManager.getTransaction().begin();
    		
    		User newUser = new User();
    		newUser.setFirstname(prenom);
    		newUser.setLastname(nom);
    		newUser.setAddress(address);
    		newUser.setMail(email);
    		newUser.setPassword(password);

    		entityManager.persist(newUser);

    		entityManager.getTransaction().commit();
    	    entityManager.close();
    	    entityManagerFactory.close();
    		
    	    HttpSession session = request.getSession();
    	    userManager.connection(email, password, session);
        } else {
        	erreurs.put(MAIL_EARLY_EXIST, "Error");
        	msgVal = "error user exist";
        }
	    
        // Build view
        if(msgVal == null) {
        	response.sendRedirect( request.getContextPath() +  ACCUEIL_PAGE_URL);
        }else {
        	// Prepare model to view
            request.setAttribute("form", form);
            this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include( request, response);
        }
	}

	private String validateEmail( String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return "Veuillez saisir une adresse mail valide";
			}
		}
		else {
			return "L'adresse mail est obligatoire";
		}
		return null;
	}
	private String validatePwd(String pwd1, String pwd2) {
		return (pwd1.equals(pwd2))?null:"Veuillez confirmer le mot de passe";
	}
	private String validateName(String name) {return null;}

}
