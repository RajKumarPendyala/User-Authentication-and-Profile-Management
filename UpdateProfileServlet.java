package test;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet{
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
			  req.setAttribute("msg", "Sorry ! Session Expired...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  }
		  else {
			  String fN = c[0].getValue();
			  req.setAttribute("fname", fN);
			  ServletContext sct = req.getServletContext();
			  UserBean ub = (UserBean)sct.getAttribute("ubean");
			  ub.setCity(req.getParameter("city"));
			  ub.setmId(req.getParameter("mid"));
		      ub.setPhno(Long.parseLong(req.getParameter("phno")));
		      int k = new UpdateProfileDAO().update(ub);
		      if(k>0) {
		    	  req.setAttribute("msg", "Profile Updated successfully..<br>");
				  req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			  }
			  else {
				  req.setAttribute("msg", "Profile Update failed..<br>");
				  req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			  }
		  }
	}
}
