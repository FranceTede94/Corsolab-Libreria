package gestionecategoria;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet ("/deleteCategoria")

	public class DeleteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public DeleteServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//you are here
			//recuperiamo l id
			try {
			   int idCategoria = Integer.parseInt(request.getParameter("id"));
			   PreparedStatement stmt = DB.getPreparedStmt("DELETE FROM category WHERE ID = ?");
			   stmt.setInt(1, idCategoria);
			   int result = stmt.executeUpdate();
				if(result != 1) {
					throw new Exception();
				}
				//ritorno alla pagina degli autori
				
				response.sendRedirect(request.getContextPath() + "/gestione-categoria.jsp?s=1");
			//facciamo un check di id
			//lanciamo la query di delete
			//se tutto ok torniamo nella pagina delle categorie
			}
			catch(Exception e) {
				e.printStackTrace();//in console lui ci stampa l eccezione
				response.sendRedirect(request.getContextPath() + "/gestione-categoria.jsp?s=2");
				
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			

}
	}


