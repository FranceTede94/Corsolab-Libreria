package auth;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/modificaPassword")
public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaServlet() {
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
		
		//recuperiamo i dati
		
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		
		if(Email.isBlank() || Password.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/login.jsp?e=1");
			return;
			
		}
			
		try {
			
		Email = Email.trim();//tolgo i spazi vuoti
		Password = Password.trim();//tolgo i spazi vuoti
		
		Password = Autenticazione.MD5(Password);
		
		PreparedStatement stmt = DB.getPreparedStmt("UPDATE user SET password = ? WHERE email= ?");
		stmt.setString(1, Password);
		stmt.setString(2, Email);
		
		//la mando in esecuzione
		
		int result = stmt.executeUpdate();
		if(result != 1) {
			throw new Exception();
		}

		
		response.sendRedirect(request.getContextPath() + "/login.jsp?s=1");
	}
	catch(Exception e) {
		response.sendRedirect(request.getContextPath() + "/login.jsp?e=2");
		return;
	}
	
		
		
		
		}
					
		
}
	

