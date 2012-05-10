package controllers;

import models.*;
import play.*;
import play.mvc.*;

public class Security extends Secure.Security 
{
 
   static boolean authentify(String username, String password) {
	   return Utilisateur.connect(username, password) != null;
   }
    
}
