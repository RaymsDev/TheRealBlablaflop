package servlet;

import com.google.gson.*;

import model.Ride;
import model.User;
import service.RideManager;
import service.UserManager;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	 public static String ACCUEIL_PAGE_URL="/index.jsp";
	 // FIELDS
	 public static String GOOGLE_RIDE_FIELD = "google_ride";
	 public static String IS_SMOKER_ALLOWED_FIELD="isSmokerAllowed";
	 public static String IS_MUSIC_ALLOWED_FIELD = "isMusicAllowed";
	 public static String IS_CHILD_ALLOWED_FIELD ="isChildsAllowed";
	 public static String CONVERSATION_LEVEL_FIELD="conversationLevel";
	 public static String DATE_RIDE_FIELD = "dateRide";
	 public static String TIME_RIDE_FIELD = "timeRide";
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

		HttpSession session = request.getSession();
		//Check if user is connected
		UserManager userManager = new UserManager();
		User userConnected = userManager.connectedUser(session);


		if(userConnected == null) {
			response.setStatus(401);
			return;
		}
		
		
		String googleRide = request.getParameter(GOOGLE_RIDE_FIELD);
		String dateRide = request.getParameter(DATE_RIDE_FIELD);
		String timeRide = request.getParameter(TIME_RIDE_FIELD);
		String conversationLevel = request.getParameter(CONVERSATION_LEVEL_FIELD);
		String isSmokerAllowed = request.getParameter(IS_SMOKER_ALLOWED_FIELD);
		String isMusicAllowed = request.getParameter(IS_MUSIC_ALLOWED_FIELD);
		String isChildAllowed = request.getParameter(IS_CHILD_ALLOWED_FIELD);
		
		RideManager rideManager = new RideManager();
		
		Ride ride = new Ride();
		ride.setConversationLevel(Integer.parseInt(conversationLevel));
		ride.setGoogleRide(googleRide);
		
		ride.setDriver(userConnected);
		
		if(isChildAllowed == "on") {
			ride.setIsChildsAllowed(1);
		}
		
		if(isSmokerAllowed == "on") {
			ride.setIsSmokerAllowed(1);
		}
		
		if(isSmokerAllowed == "on") {
			ride.setIsMusicAllowed(1);
		}
		
		ride.setConversationLevel(Integer.parseInt(conversationLevel));
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = format.parse(dateRide);
			ride.setStartDate(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			ride.setStartTime(Time.valueOf(timeRide +":00"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rideManager.postRide(ride);
		
		
		
		response.sendRedirect( request.getContextPath() +  ACCUEIL_PAGE_URL);
	}
}
