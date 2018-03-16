package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/login.jsp";
    public static String MY_SPACE_PAGE_URL="/WEB-INF/mySpace.jsp";

    // Form fields
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PWD = "password";
       
    // Request attributs
    Map<String, String> error;// = new HashMap<String, String>();
    Map<String, String> form;// = new HashMap<String, String>();
    String statusMessage="";
    boolean statusOk=false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("statusOK", false);
        request.setAttribute("statusMessage", "");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form fields
        String email = request.getParameter(FIELD_EMAIL);
        String password = request.getParameter(FIELD_PWD);

        // Prepare data for view (attributs)
        error = new HashMap<String, String>();
        form = new HashMap<String, String>();
        statusMessage=null;
        
        String messageValidation = null;
        messageValidation = validateEmail(email);
        // Validate page
        if(messageValidation == null) {
        form.put(FIELD_EMAIL, email);
        }else {
        	
            error.put(FIELD_EMAIL, messageValidation);
        }
        messageValidation=validatePwd(password);
        
        if(messageValidation==null){
        	form.put(FIELD_PWD, password);
        }
        else{
            error.put(FIELD_PWD, messageValidation);
        }
        
        UserManager userManager = new UserManager();
        HttpSession session = request.getSession();
        
        boolean isConnected = userManager.connection(email, password, session);
        
        if(error.isEmpty() && isConnected){
        	statusOk=true;
        	statusMessage="Connect&eacute;";
        }
        else{
        	statusOk=false;
        	statusMessage="Connexion refus&eacute;e";
        }

        
		
        // Build view
        String pageRedirection = VIEW_PAGES_URL;
        if(statusOk) {
        	response.sendRedirect( request.getContextPath() +  "/");
        }else {
        	// Prepare model to view
            request.setAttribute("form", form);
            request.setAttribute("error", error);
            request.setAttribute("statusOK", statusOk);
            request.setAttribute("statusMessage", statusMessage);
            this.getServletContext().getRequestDispatcher(pageRedirection).include( request, response);
        }
	}
	
	private String validateEmail( String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return "Veuillez saisir une adresse mail valide";
			}
			else{
				if(!isUserExist(email)){
					return "Login inconu";
				}
			}
		}
		else {
			return "L'adresse mail est obligatoire";
		}
		return null;
	}

	private String validatePwd(String pwd) {
		return (pwd==null || pwd.equals(""))?"Le mot de passe doit &ecirc;tre renseign&eacute;":null;
	}
	
	private boolean isUserExist(String login){
		return true;
	}

	private boolean authenticate(String login, String pwd){
		return true;
	}

}
