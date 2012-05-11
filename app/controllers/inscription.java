package controllers;

import java.util.*;
import javax.persistence.*;
import models.Utilisateur;
import play.db.jpa.*;
import play.*;
import play.mvc.*;
import play.data.validation.*;

public class inscription extends Controller{
	
	public static void sinscrire(@Required String pseudo, @Required String mail, @Required String mdp,@Required String nomBateau, @Required String voile, @Required String coque){
		
		Utilisateur user = new Utilisateur(mail, mdp, pseudo,nomBateau, voile, coque);
		
		if (validation.hasErrors()) {
			// add http parameters to the flash scope
			params.flash();
		} else {
			//je recherche s'il y a déjà une adresse email répondant à cette adresse email dans la base de données
			//si c'est le cas alors je ne sauvegarde pas mon utilisateur
			if (user.find("byEmail", user.email).first() != null) {
				flash.error("E-mail existant");
				render("Application/inscription.html");
			}
			//si le pseudo existe déjà
			if (user.find("byPseudo", user.pseudo).first() != null) {
				flash.error("Pseudo existant");
				render("Application/inscription.html");
			}
			//si le nom du bateau existe déjà
			if (user.find("byNomBateau", user.nomBateau).first() != null) {
				flash.error("Ce nom de bateau existe déjà !");
				render("Application/inscription.html");
			}
			else
			{
				//si c'est pas le cas
				user.save();
				render("Application/identification.html");
			}		
		}
	}
	
	public static void sauvegardermoncompte(@Required @Valid Utilisateur usr) {
		 
		if(Security.isConnected()) {
	            Utilisateur user = Utilisateur.find("byEmail", Security.connected()).first();
	            renderArgs.put("user", user);
	    }
		 if (validation.hasErrors()) {
				// add http parameters to the flash scope
				params.flash();
			} else {
				usr.save(); // explicit save here
				flash.success("Sauvegarde réussie");
			}
		 
		render("Admin/index.html");
	}
}
