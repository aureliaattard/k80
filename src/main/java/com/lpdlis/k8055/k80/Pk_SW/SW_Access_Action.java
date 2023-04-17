package com.lpdlis.k8055.k80.Pk_SW;


import com.lpdlis.k8055.k80.Pk_Process.Lancement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/k8055_Action")
public class SW_Access_Action {

	static Lancement Lanceur;
	
	public SW_Access_Action()
	{
		Lanceur = Lancement.getInstance();
	}

	// Lancement du process (Version navigateur)
	@GET
	@Path("/Lance")
	@Produces(MediaType.TEXT_PLAIN)
	public String LanceProcess() {
		if (Lanceur.Lance() == 0)
			return "Process Lance";
		else
			return "Process en cours";	
	}
	
	// Arr�t du process (Version navigateur)
	@GET
	@Path("/Arret")
	@Produces(MediaType.TEXT_PLAIN)
	public String ArretProcess() {
		Lanceur.Arret();
		return "Process Arrete";
	}
	
	// RAZ du process (Version navigateur)
	@GET
	@Path("/Raz")
	@Produces(MediaType.TEXT_PLAIN)
	public String RazProcess() {
		Lanceur.Raz();
		return "Raz Process OK";
	}

}
