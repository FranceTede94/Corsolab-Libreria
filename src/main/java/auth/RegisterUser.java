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
@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(nome.isBlank()|| cognome.isBlank() || email.isBlank() || password.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/registrazione.jsp?e=1");
			return;
			
		}
			
		try {
			
		nome = nome.trim();//tolgo i spazi vuoti
		nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
		cognome = cognome.trim();//tolgo i spazi vuoti
		cognome = cognome.substring(0,1).toUpperCase() + cognome.substring(1).toLowerCase();
			
		email = email.trim();
		email = email.toLowerCase();
			
		password = Autenticazione.MD5(password);
			
			
		PreparedStatement stmt = DB.getPreparedStmt("INSERT INTO user "
				+ "(name, lastname, email, password) "
				+ "VALUES (?, ?, ?, ?)");
		stmt.setString(1, nome);
		stmt.setString(2, cognome);
		stmt.setString(3, email);
		stmt.setString(4, password);
		//la mando in esecuzione
		
		int result = stmt.executeUpdate();
		if(result != 1) {
			throw new Exception();
		}

		
		response.sendRedirect(request.getContextPath() + "/registrazione.jsp?s=1");
	}
	catch(Exception e) {
		response.sendRedirect(request.getContextPath() + "/registrazione.jsp?e=2");
		return;
	}
	
		
		
		
		}
					
		
}
	


	
	
	