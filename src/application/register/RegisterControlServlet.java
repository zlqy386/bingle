package application.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseUse.IUserData;
import baseUse.UserBaseInfo;
import businessServices.datamanager.userdata.UserDataProxy;

@WebServlet("/RegisterControlServlet")
public class RegisterControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RegisterControlServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		checkUsername(username,request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean g = new Boolean(request.getParameter("gender"));
		Short a = new Short(request.getParameter("age"));
		UserBaseInfo usi = new UserBaseInfo(request.getParameter("username"), request.getParameter("password"),  
				request.getParameter("email"),  g.booleanValue(), a);
		try {
			IUserData iud = new UserDataProxy();
			iud.createUser(usi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		//groupName = udi.getGroupname();
		//age = udi.getAge();
		//address = udi.getAddress();
		//email = udi.getEmail();
		//gender = udi.getGender()?"Ů":"��";
		//mind = udi.getMindStatus();
		//body = udi.getBodyStatus();
		//disease = udi.getUserDiseaseInfo().get(udi.getUserDiseaseInfo().size()-1).getDiseaseName();
		
		session.setAttribute("username", request.getParameter("username"));
		String type = "login";
		request.setAttribute("type", type);
		session.setAttribute("login", "1");
		//request.setAttribute("groupname", groupName);
		//request.setAttribute("age", age);
		//request.setAttribute("address", address);
		//request.setAttribute("email", email);
		//request.setAttribute("gender", gender);
		//request.setAttribute("disease", disease);
		//request.setAttribute("mind", mind);
		//request.setAttribute("body", body);
		//session.setAttribute("udi", udi);
		//session.setAttribute("pageType", 1);
		request.getRequestDispatcher("/UpdateInfoControlServlet").forward(request, response);
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	public boolean checkUsername(String username,HttpServletRequest request, HttpServletResponse response){
		IUserData iud;
		try {
			iud = new UserDataProxy();
			response.getWriter().println(iud.checkUsername(username));
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
}
