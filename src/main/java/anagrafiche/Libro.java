package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Libro {
	
	private Autore autore;
	private Categoria categoria;
	private int id;
	private String title;
	private float price;
	
	public Libro(Autore aut, Categoria cat, String tit, float pr) {
		this.autore = aut;
		this.categoria = cat;
		this.title = tit;
		this.price = pr;
	}
	
	public Libro(int id, Autore aut, Categoria cat, String tit, float pr) {
		this( aut, cat, tit, pr);
		this.id = id; 
	}
	
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTitolo() {
		return title;
	}
	public void setTitolo(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public float getPrezzo() {
		return this.price;
	}
	
	public static Libro getLibroById(int id) throws Exception {
		
		//collego al db
		//invio lo statement
		PreparedStatement stmLibro = DB.getPreparedStmt("SELECT book.id as idBook, title, price, author.id as idAuthor,"
				+ " author.name, author.lastname, category.id as idCategory, category.name as 'category' FROM `book` "
				+ "INNER JOIN author ON book.author_id = author.id INNER JOIN category on book.category_id = category.id "
				+ "WHERE book.id = ? ");
		//recupero il resultSet
		stmLibro.setInt(1,id); 
		ResultSet rsLibro = stmLibro.executeQuery();
		//popolo il libro recuoperato (se esiste)
		if(rsLibro.next()) {
			Libro libro   = new Libro(
								rsLibro.getInt("idBook"),
								new Autore(rsLibro.getInt("idAuthor"),rsLibro.getString("name"), rsLibro.getString("lastname")),
								new Categoria(rsLibro.getInt("idCategory"),rsLibro.getString("category")),
								rsLibro.getString("title"), rsLibro.getFloat("price"));
			return libro;
		}
		
		//return del libro
		return null;
		
	}
	
	public static ArrayList<Libro> getAll() throws Exception { 
		//connessione al db
		//inviare uno statement 
		PreparedStatement stmtB = DB.getPreparedStmt("SELECT book.id, title, price, author.name, author.lastname, category.name as 'category' FROM `book` INNER JOIN author ON book.author_id = author.id INNER JOIN category on book.category_id = category.id"); 
		//recuperare il recordset / resultSet
		ResultSet rsB = stmtB.executeQuery(); 
		//impacchettarlo dentro una lista COME ?
		ArrayList<Libro> libri = new ArrayList<>();
		while(rsB.next()) {
			//ad ogni giro di while ho un libro
			//Book(int id, Author aut, Category cat, String tit, float pr)
			libri.add(new Libro(
					rsB.getInt("id"),
					new Autore(rsB.getString("name"), rsB.getString("lastname")),
					new Categoria(rsB.getString("category")),
					rsB.getString("title"),
					rsB.getFloat("price")));
		}
		
		//restituirlo
		return libri;
		 
	}
	
}
	
	