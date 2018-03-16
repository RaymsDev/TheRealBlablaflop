package servlet;

import com.google.gson.*;

import model.Ride;
import model.User;
import service.RideManager;
import service.UserManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ride
 */
@WebServlet("/Ride")
public class RideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE_JSON = "application/json";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//We set the content type of the response object to application/json.
		response.setContentType(CONTENT_TYPE_JSON);
		//We get the ServletOutputStream which is used to send data to the client.
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session = request.getSession();
		//Check if user is connected
		UserManager userManager = new UserManager();
		User userConnected = userManager.connectedUser(session);
		
		
		if(userConnected == null) {
			response.setStatus(401);
			out.print("{"
					+ "\"message\":\"User not connected!\""
					+ "}");
			return;
		}
		
		RideManager rideManager = new RideManager();
		List<Ride> rides = rideManager.getRides(userConnected);
		
		
		if(rides == null) {
			response.setStatus(204);
			return;
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(rides);
		
		out.print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
