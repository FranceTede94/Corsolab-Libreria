package auth;

import javax.servlet.http.HttpSession;

public class User {
	
	public final static String USERKEY = "USERTOKEN";
	private int id;
	private String nome;
	private String cognome;
	private final String email;
	
	
	public User(int id, String nome, String cognome, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}	
		
	//metodo booleano o true o false
	// se torna true significa che ha fatto il login
	// se torna false significa che non hai fatto il login
	public static boolean isLogged(HttpSession session) {
		return getUser(session) != null;
	}
	
	//verifica che data una chiave USERKEY che esista un utente nella sessione corrente
	// in caso corrente lo recupra e lo restituisce
	// altrimenti null
	public static User getUser(HttpSession session) {
		
		try {
			User u = (User)session.getAttribute(USERKEY);
			return u;
		}
		catch(ClassCastException e){
			return null;
		}
				
	}

	}
