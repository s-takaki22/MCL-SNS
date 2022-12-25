package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Onetime;

/**
 * Servlet implementation class RegisterOnetimeServlet
 */
@WebServlet("/RegisterOnetimeServlet")
public class RegisterOnetimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterOnetimeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*セッションの取得*/
		try {
			HttpSession session = request.getSession();
			Onetime onetime = (Onetime)session.getAttribute("onetime_data");
			String code = request.getParameter("onetime");
			String setTime = onetime.getTime();


			SimpleDateFormat formatdt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			Date date;
			
			/*現在時刻を取得後3分の加算処理*/
			try {
				LocalDateTime time = LocalDateTime.now();
				DateTimeFormatter newTime = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
				String formatNowTime = newTime.format(time);
				Date time1 = formatdt.parse(formatNowTime);
				date = formatdt.parse(setTime);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.MINUTE, 3);
				Date time2 = cal.getTime();
				System.out.println(date);
				
				/*ワンタイムパスワード発行時と現在時刻を比較*/
				if(time1.before(time2)) {
					System.out.println("OK!");
					/*発行したワンタイムパスワードと入力したコードとの比較*/
					if(onetime.getCode().equals(code)) {
						System.out.println("success");
						String view = "WEB-INF/view/register-step3.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(view);
						dispatcher.forward(request, response);
					} else {
						session.invalidate();
						System.out.println("false");
						String view = "WEB-INF/view/register-step1.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(view);
						dispatcher.forward(request, response);
					}
				} else {
					session.invalidate();
					System.out.println("NO");
					String view = "WEB-INF/view/register-step1.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("nullpointer");
			String view = "WEB-INF/view/register-step1.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
