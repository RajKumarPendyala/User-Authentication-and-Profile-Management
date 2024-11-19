package test;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	        throws ServletException, IOException {
	    doPost(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	         throws ServletException, IOException    
	{
		UserBean ub = new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setCity(req.getParameter("city"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k=new RegisterDAO().insert(ub);
		if(k>0) {
			req.setAttribute("msg", "Registered Successfully.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "User name existing..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
