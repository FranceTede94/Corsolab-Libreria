package gestionelibri;

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
@WebServlet("/registerLibro")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String titoloLibro = request.getParameter("titolo");
		int idAutore = Integer.parseInt(request.getParameter("autore"));
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		float prezzoLibro = Float.parseFloat(request.getParameter("prezzo"));
		
		//validiamo
		if(titoloLibro.isBlank()|| idAutore <=0 || idCategoria <=0 || prezzoLibro <= 0) {
			response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?e=1");
			return;
		}
		
		//inserimento dei dati nel db
		try {
			titoloLibro = titoloLibro.trim();
			PreparedStatement stmt = DB.getPreparedStmt("INSERT INTO book(title, author_id, category_id, price) Values(?,?,?,?)");
			stmt.setString(1, titoloLibro);
			stmt.setInt(2, idAutore);
			stmt.setInt(3, idCategoria);
			stmt.setFloat(4, prezzoLibro);
			
			//la mando in esecuzione
			int result = stmt.executeUpdate();
			if(result != 1) {
				throw new Exception();
			}
			// ritorno alla pagina dei libri
			response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?s=1");
		}
			
				
	catch(Exception e) {
		response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?e=2");
		return;
	}
		
		}
	}

	