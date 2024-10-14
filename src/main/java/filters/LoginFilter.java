package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.User;

/**
 * Servlet Filter implementation class LoginFilter
 * @param <HttpServletResponse>
 */
@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//request
		HttpServletRequest req = (HttpServletRequest) request;
		// response
		HttpServletResponse res = (HttpServletResponse) response;
		
		String path = req.getRequestURI();
		path = path.substring(path.lastIndexOf("/") + 1);
		
		if(path.equals("login.jsp") || path.equals("loginUser") || path.equals("registerUser") || path.equals( "registrazione.jsp")) {
			chain.doFilter(request, response);
		}
		else {
			if(!User.isLogged(req.getSession())) {
				res.sendRedirect(req.getContextPath() + "/login.jsp?e=1");
			return;
			}
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
