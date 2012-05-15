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
	    
	    public List<Post> getRecentsPosts() {
	        return Post.find("postedBy = ? order by postedAt", this).fetch(1, 10);
	    }

	    public Long getPostsCount() {
	        return Post.count("postedBy", this);
	    }

	    public Long getTopicsCount() {
	        return Post.count("select count(distinct t) from Topic t, Post p, User u where p.postedBy = ? and p.topic = t", this);
	    }
	    
	    public boolean isAdmin() {
	        return email.equals(Play.configuration.getProperty("forum.adminEmail", ""));
	    }
	 
	}
