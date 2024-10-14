package gestionecategoria;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/updateCategoria")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		response.getWriter().append("Served at: ").append(request.getContextPath());
  	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("id"));
        String nomeCategoria = request.getParameter("nome");
      
        if (idCategoria <= 0 || nomeCategoria.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/gestione-categoria.jsp?&e=1");
            return;
        }

        try {
            PreparedStatement stmt = DB.getPreparedStmt("UPDATE category SET name=? WHERE id=?");
            stmt.setString(1, nomeCategoria);
            stmt.setInt(2, idCategoria);

            int result = stmt.executeUpdate();
            if (result != 1) {
                throw new Exception();
            }
            response.sendRedirect(request.getContextPath() + "/gestione-categoria.jsp?s=1");
        } 
        
        catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/gestione-categoria.jsp?&e=2");
        }
    }
}