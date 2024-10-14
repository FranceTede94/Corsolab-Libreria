package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Autore {
    private int id;
    private String nome;
    private String cognome;

    // Costruttore
    public Autore(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public Autore(String nome, String cognome) {
    	this.nome = nome;
    	this.cognome = cognome;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    public static ArrayList<Autore> getAll() throws Exception{
    	//connessione al db
    	//inviare uno statement
    	PreparedStatement stmtAutori = DB.getPreparedStmt("SELECT * FROM author ORDER BY id");
    	//recuperare il recordset
    	ResultSet rsAutori = stmtAutori.executeQuery();
    	//impacchettarlo dentro una lista
    	ArrayList<Autore> autori = new ArrayList<>();
    	while(rsAutori.next()) {
    		//ad ogni giro di while ho un autore
    		autori.add(new Autore(
    				  rsAutori.getInt("id"),
    				  rsAutori.getString("name"),
    				  rsAutori.getString("lastname")
    				));
    	}
    	//restuirlo
    	return autori;
    	
    }
    	
    	public static Autore getAutoreById(int id) throws Exception{
    		PreparedStatement stmtAutori = DB.getPreparedStmt("SELECT * FROM author WHERE id= ?");
    		stmtAutori.setInt(1, id);
    		ResultSet rsAutori = stmtAutori.executeQuery(); 
    		if(rsAutori.next()) {
    			return new Autore(rsAutori.getInt("id"),rsAutori.getString("name"),rsAutori.getString("lastname"));
    			
    		};
    		return null;
    		
    	
    }
    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
