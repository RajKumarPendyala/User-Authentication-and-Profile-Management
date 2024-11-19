package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	        throws ServletException, IOException {
	    doPost(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws ServletException, IOException{
		Cookie c[] = req.getCookies();
		if(c==null) {
			  req.setAttribute("msg", "Sorry! Session Expired...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  }
		else {
			String fn = c[0].getValue();
			req.setAttribute("fName", fn);
			req.getRequestDispatcher("/EditProfile.jsp").forward(req, res);
		}
	}
}