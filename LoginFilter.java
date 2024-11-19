package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/log")
public class LoginFilter implements Filter{
	public String filterName = null;
	@Override
	public void init(FilterConfig fcf) throws ServletException{
		filterName = fcf.getFilterName();
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
	            throws ServletException, IOException{
		String uname = req.getParameter("uname");
		ArrayList<String> al = LoginFilterDAO.getUnames();
		Iterator<String> i = al.iterator();
		if(i.hasNext()) {
			if(uname.equals(i.next())) {
				req.setAttribute("filterName", filterName);
				fc.doFilter(req, res);
			}
			else {
				req.setAttribute("msg", "Invalid UserName...<br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
		}
	}
	public void distroy() {}
}
