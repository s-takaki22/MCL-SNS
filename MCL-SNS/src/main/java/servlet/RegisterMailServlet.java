package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Onetime;
import util.RegisterMailUtil;

/**
 * Servlet implementation class RegisterMailServlet
 */
@WebServlet("/RegisterMailServlet")
public class RegisterMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ランダムな10桁の英数字を発行*/
		Random rd = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String str = "";
		for(int i=0; i<6; i++) {
			str = str + alphabet.charAt(rd.nextInt(alphabet.length()));
		}
		
		/*発行した英数字をワンタイムパスワードとしてメールで送信*/
		String to = request.getParameter("mail");
		String subject = "会員登録について";
		String mainText = "あなたの登録コードは" + str + "です。\nこのコードは30分間有効です。\n過ぎた場合にはお手数ですがもう一度やり直してください。";
		
		RegisterMailUtil.sendMail(to, subject, mainText);
		
		/*ワンタイムパスワードと現在時刻をセッションに登録*/
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter newTime = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		String formatNowTime = newTime.format(time);
		
		
		Onetime onetime = new Onetime(to, str, formatNowTime);
		
		HttpSession session = request.getSession();
		session.setAttribute("onetime_data", onetime);
		
		/*ワンタイムパスワード認証画面へ*/
		String view = "WEB-INF/view/register-step2.jsp";
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
