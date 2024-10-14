package auth;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DB;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	password = Autenticazione.MD5(password);
	
	
	try {
		PreparedStatement stmtUser = DB.getPreparedStmt("SELECT * FROM user WHERE email = ? AND password = ?");
		
		stmtUser.setString(1, email);
		stmtUser.setString(2, password);
		
		ResultSet rs = stmtUser.executeQuery();
		
		if(rs.next()) {
			
			User u = new User(rs.getInt("id"),
					rs.getString("name"),
					rs.getNString("lastname"),
					rs.getString("email"));
			
		// creare la sessione
		HttpSession session = request.getSession();
		//lo metto in sessione
		session.setAttribute(User.USERKEY, u); // chiave, valore
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
		}
		else {
			response.sendRedirect(request.getContextPath() + "/login.jsp?e=2");
		}
		
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
		response.sendRedirect(request.getContextPath() + "/login.jsp?e=2");
		return;
	}
		
	}
}
	