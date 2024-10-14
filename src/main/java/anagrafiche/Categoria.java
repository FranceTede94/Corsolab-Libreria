package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Categoria {
    private int id;
    private String nome;

    // Costruttore
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Categoria( String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static ArrayList<Categoria> getAll() throws Exception{
    	//connessione al db
    	//inviare uno statement
    	PreparedStatement stmtCategoria = DB.getPreparedStmt("SELECT * FROM category");
    	//recuperare il recordset
    	ResultSet rsCategoria = stmtCategoria.executeQuery();
    	//impacchettarlo dentro una lista
    	ArrayList<Categoria> categoria = new ArrayList<>();
    	while(rsCategoria.next()) {
    		//ad ogni giro di while ho una categoria
    		categoria.add(new Categoria(
    				  rsCategoria.getInt("id"),
    				  rsCategoria.getString("name")
    				  
    				));
    	}
    	//restuirlo
    	return categoria;
    }
    
  
    
	public static Categoria getCategoriaById(int id) throws Exception{
		PreparedStatement stmtCategorie = DB.getPreparedStmt("SELECT * FROM category WHERE id= ?");
		stmtCategorie.setInt(1, id);
		
		ResultSet rsCategorie = stmtCategorie.executeQuery(); 
		if(rsCategorie.next()) {
			return new Categoria(rsCategorie.getInt("id"),rsCategorie.getString("name"));
			
		}
		return null;
		
	}
				
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
    
}