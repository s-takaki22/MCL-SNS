package servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dto.Register;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

/**
 * Servlet implementation class RegisterAccountServlet
 */
@WebServlet("/RegisterAccountServlet")
@MultipartConfig
public class RegisterAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//jspから値の受取
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String nickName = request.getParameter("nickName");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String realName = lastName + firstName;
		String birthday = request.getParameter("birthday");
		String schoolName = request.getParameter("schoolName");
		Part part = request.getPart("upfile");
		String fileName = part.getSubmittedFileName();
		
		//写真ファイルの保存
		String folderPath = "C:/Users/ShunTakaki/git/repository/MCL-SNS/picture/onetime";
		String savePath = folderPath + "/" + fileName;
		part.write(savePath);
		request.setAttribute("file_name", fileName);
		
		//画像の読み込み
		File file = new File(savePath);
		BufferedImage img = ImageIO.read(file);
		
		//解析言語設定
		ITesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:/Users/ShunTakaki/git/repository/MCL-SNS/language");
		tesseract.setLanguage("jpn");
		
		//解析
		String str;
		String str2 = "";
		try {
			str = tesseract.doOCR(img);
			List<String> list = Arrays.asList(str.split("\n"));
			System.out.println("名前：" + realName);
			System.out.println("学校名：" + schoolName);
			for(String a : list) {
				str2 = str2 + a;
			}
			String str3 = str2.replace(" ", "");
			List<String> words = new ArrayList<>();
			BreakIterator boundary = BreakIterator.getWordInstance();
			boundary.setText(str3);
			for(int start = boundary.first(), end = boundary.next();
					end != BreakIterator.DONE;
					start = end, end = boundary.next()) {
				words.add(str3.substring(start, end));
			}
			List<String> words2 = new ArrayList<>();
			BreakIterator boundary2 = BreakIterator.getWordInstance();
			boundary2.setText(realName);
			for(int start = boundary2.first(), end = boundary2.next();
					end != BreakIterator.DONE;
					start = end, end = boundary2.next()) {
				words2.add(realName.substring(start, end));
			}
			List<String> words3 = new ArrayList<>();
			BreakIterator boundary3 = BreakIterator.getWordInstance();
			boundary3.setText(schoolName);
			for(int start = boundary3.first(), end = boundary3.next();
					end != BreakIterator.DONE;
					start = end, end = boundary3.next()) {
				words3.add(schoolName.substring(start, end));
			}
			
			System.out.println("OCR");
			for(String a : words) {
				System.out.println(a);
			}
			System.out.println("名前");
			for(String b : words2) {
				System.out.println(b);
			}
			System.out.println("学校名");
			for(String c : words3) {
				System.out.println(c);
			}
			
			//名前判定
			int count =0;
			for(int i=0; i<words.size(); i++) {
				for(int j=0; j<words2.size(); j++) {
					if(words.get(i).equals(words2.get(j))) {
						count ++;
					}
				}
			}
			System.out.println(count);
			//学校名判定
			for(int i=0; i<words.size(); i++) {
				for(int j=0; j<words3.size(); j++) {
					if(words.get(i).equals(words3.get(j))) {
						count ++;
					}
				}
			}
			
			if(count >= 1) {
				System.out.println("認証しました。");
				Register register = new Register(mail, pass, nickName, lastName, firstName, birthday, schoolName, null, null);
				HttpSession session = request.getSession();
				session.setAttribute("register", register);
				String view = "WEB-INF/view/register-step4.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
					
			} else {
				System.out.println("名前を認証出来ませんでした。");
				String view = "WEB-INF/view/register-step1-error.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
