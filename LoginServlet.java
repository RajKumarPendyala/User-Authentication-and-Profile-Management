
 package test;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	        throws ServletException, IOException {
	    doPost(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{	
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		
		UserBean ub = new LoginDAO().login(uName, pWord);
		if(ub==null) {
			req.setAttribute("msg", "Invalid UserName or Passward..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			Cookie ck = new Cookie("fname", URLEncoder.encode(ub.getfName(), StandardCharsets.UTF_8.toString()));
			ServletContext sct = req.getServletContext();
			sct.setAttribute("ubean", ub);
			res.addCookie(ck);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
		}
	}
}
