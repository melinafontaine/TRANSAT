package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;


public class Application extends Controller {
	
	static Integer pageSize = Integer.parseInt(Play.configuration.getProperty("forum.pageSize", "10"));
    
	@Before
    static void globals() {
        renderArgs.put("connected", connectedUser());
        renderArgs.put("pageSize", pageSize);
    }
	
	public static void index() {
        render();
    }
    
    public static void identification(){
    	render();
    }
    
    public static void inscription(){
    	render();
    }
    
    public static void courses(){
    	render();
    }
    
    static void connect(Utilisateur user) {
        session.put("logged", user.id);
    }
    
    static Utilisateur connectedUser() {
        String userId = session.get("logged");
        return userId == null ? null : (Utilisateur) Utilisateur.findById(Long.parseLong(userId));
    }
   
}