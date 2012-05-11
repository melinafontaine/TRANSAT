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
	    
	    @Required
		public String nomBateau;
		
		@Required
		public String couleurVoile;
		
		@Required
		public String couleurcoque;
	    
	    public boolean admin;
	    
	    public Utilisateur(String email, String password, String pseudo, String nomBateau, String voile, String coque) {
	    	this.email = email;
	        this.password = password;
	        this.pseudo=pseudo;
	        this.nomBateau = nomBateau;
	        this.couleurVoile=voile;
	        this.couleurcoque=coque;
	        admin=false;
	    }
	    
	    public String toString() {
	        return email;
	    }
	    
	    public static Utilisateur connect(String email, String password) {
	        return find("byEmailAndPassword", email, password).first();
	    }
	    
	    
	 
	}
