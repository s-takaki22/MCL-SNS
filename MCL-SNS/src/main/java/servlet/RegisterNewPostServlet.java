package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostRegistrationDAO;
import dto.RegisterNewPost;

/**
 * Servlet implementation class RegisterNewPostServlet
 */
@WebServlet("/RegisterNewPostServlet")
@MultipartConfig
public class RegisterNewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterNewPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//jspから値の受取
		String nickName = request.getParameter("nickName");
		String note = request.getParameter("note");
		RegisterNewPost register = new RegisterNewPost(nickName, note);
		int result = PostRegistrationDAO.registerMember(register);
		
		List<RegisterNewPost> list = PostRegistrationDAO.selectAllPost(nickName);
		request.setAttribute("list", list);
		
		String view = "WEB-INF/view/sample-menu.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
