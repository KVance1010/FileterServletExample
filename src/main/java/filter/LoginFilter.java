package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/AccountServlet")
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// pass the request along the filter chain
		String pword = request.getParameter("txtPword");

		if (pword == null) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		} 
		else {
			if (pword.equals("abc@123")) {
				chain.doFilter(request, response);
			} 
			else {
				PrintWriter out = response.getWriter();
				out.println("you are not allowed");
			}
		}
	}

}
