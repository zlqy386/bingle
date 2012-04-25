package application.search;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseUse.*;
import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.userdata.UserDataProxy;

/**
 * Servlet implementation class SearchControlServlet
 */
@WebServlet("/SearchControlServlet")
public class SearchControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControlServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("searchType") != null) {
				if (request.getParameter("searchType").equals("disease")) {
					searchDisease(request, response);
				} else if (request.getParameter("searchType").equals("user")) {
					searchUser(request, response);
				}
			} else if (request.getParameter("diseasename") != null) {
				selectDisease(request, response);
			} else if (request.getParameter("username") != null) {
				selectUser(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void searchDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		IDiseaseData diseaseI = new DiseaseDataProxy();
		String keyword = request.getParameter("keyword");
		DiseaseShortInfoList result = diseaseI.searchDisease(
				keyword);
		request.setAttribute("result", result);

		String address = "jsp/search/searchDisease.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		IUserData userI = new UserDataProxy();
		String username = request.getParameter("username");
		UserDetailInfo result = userI.getDetailUserInfo(username);
		request.setAttribute("result", result);

		String address = "jsp/search/userDetail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void selectDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		IDiseaseData diseaseI = new DiseaseDataProxy();
		String diseasename = request.getParameter("diseasename");
		DiseaseDetailInfo result = diseaseI.getDiseaseDetail(
				diseasename);
		request.setAttribute("result", result);

		String address = "jsp/search/diseaseDetail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void searchUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		IUserData userI = new UserDataProxy();
		String keyword = request.getParameter("keyword");
		UserShortInfoList result = userI.searchUser(keyword);
		request.setAttribute("result", result);

		String address = "jsp/search/searchUser.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
