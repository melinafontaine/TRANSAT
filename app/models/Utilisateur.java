package models;
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.*;
import play.mvc.*;
import play.data.validation.*;

@Entity
public class Utilisateur extends Model{   
	    
	    @Email
	    @Required
	    public String email;
	    
	    @Required
	    public String password;
	    
	    @Required
	    public String pseudo;
	    
	    public boolean admin;
	    
	    public Utilisateur(String email, String password, String pseudo) {
	    	this.email = email;
	        this.password = password;
	        this.pseudo=pseudo;
	        admin=false;
	    }
	    
	    public String toString() {
	        return email;
	    }
	    
	    public static Utilisateur connect(String email, String password) {
	        return find("byEmailAndPassword", email, password).first();
	    }
	 
	}
