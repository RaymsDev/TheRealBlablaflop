package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserManager;

/**
 * Servlet implementation class MySpace
 */
@WebServlet("/mySpace")
public class MySpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/mySpace.jsp";
    public static String ACCUEIL_PAGE_URL="/index.jsp";
	public static final String FIELD_EMAIL = "email";
    public static final String FIELD_NOM = "nom";
    public static final String FIELD_PRENOM = "prenom";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_PWD = "pwd1";
    public static final String FIELD_CONFIRM_PWD = "pwd2";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySpace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO check if connected
		request.setAttribute("errorStatus", false);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get form fields
        String nom = request.getParameter(FIELD_NOM);
        String prenom = request.getParameter(FIELD_PRENOM);
        String address = request.getParameter(FIELD_ADDRESS);

        // Prepare results
        Map<String, String> erreurs = new HashMap<String, String>();
        Map<String, String> form = new HashMap<String, String>();
        String actionMessage=null;
        String msgVal=null;
        
		UserManager userManager = new UserManager();
		HttpSession session = request.getSession();
		User updatedUser = new User();
		updatedUser.setFirstname(prenom);
		updatedUser.setLastname(nom);
		updatedUser.setAddress(address);
		
		Boolean result = userManager.updateUser(session, updatedUser);
		
        // Build view
        if(result) {
        	response.sendRedirect( request.getContextPath() +  "/");
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
