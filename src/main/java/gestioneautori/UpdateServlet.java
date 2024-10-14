package gestioneautori;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/updateAutore")
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
        int idAutore = Integer.parseInt(request.getParameter("id"));
        String nomeAutore = request.getParameter("nome");
        String cognomeAutore = request.getParameter("cognome");

        if (idAutore <= 0 || nomeAutore.isBlank() || cognomeAutore.isBlank() ) {
            response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?&e=1");
            return;
        }

        try {
            PreparedStatement stmt = DB.getPreparedStmt("UPDATE author SET name=?, lastname=? WHERE id=?");
            stmt.setString(1, nomeAutore);
            stmt.setString(2, cognomeAutore);
            stmt.setInt(3, idAutore);

            int result = stmt.executeUpdate();
            if (result != 1) {
                throw new Exception();
            }
            response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?s=1");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?&e=2");
        }
    }
}

