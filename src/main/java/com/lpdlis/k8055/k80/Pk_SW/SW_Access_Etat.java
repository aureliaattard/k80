package com.lpdlis.k8055.k80.Pk_SW;

import com.lpdlis.k8055.k80.Pk_Process.StrucEntrees;
import com.lpdlis.k8055.k80.Pk_Process.StrucProcess;
import com.lpdlis.k8055.k80.Pk_Process.StrucSorties;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/etat")
public class SW_Access_Etat {

	@GET
	@Produces("text/plain")
	public String helloTest() {
		return "Etats!";
	}
	
	
	public SW_Access_Etat()
	{
		
	}
	
	// lecture des entr�es (Version navigateur)
	@GET
	@Path("/entrees")
	@Produces(MediaType.TEXT_PLAIN)
	public String LireEntrees() {
		String Str="E";
		Str = "E1 : " + SW_Access_Action.Lanceur.STE.DE1 + " - " + "E2 : " + SW_Access_Action.Lanceur.STE.DE2 + " - " +
			  "E3 : " + SW_Access_Action.Lanceur.STE.DE3 + " - " + "E4 : " + SW_Access_Action.Lanceur.STE.DE4 + " - " +
			  "E5 : " + SW_Access_Action.Lanceur.STE.DE5;
		return Str;
	}
	
	// lecture de l'objet StrucEntrees
	@GET
	@Path("/entrees/object")
	@Produces(MediaType.APPLICATION_XML)
	public StrucEntrees LireEntreesObject() {
		return SW_Access_Action.Lanceur.STE;
	}
	
	// lecture des sorties (Version navigateur)
	//.
	//.
	//.
	
	// lecture de l'objet StrucSorties
	@GET
	@Path("/sorties/object")
	@Produces(MediaType.APPLICATION_XML)
	public StrucSorties LireSortiesObject() {
		return SW_Access_Action.Lanceur.STS;
	}
	
	// lecture du Process (Version navigateur)
	//.
	//.
	//.	
	
	// lecture de l'objet StrucProcess
	@GET
	@Path("/process/object")
	@Produces(MediaType.APPLICATION_XML)
	public StrucProcess LireProcessObject() {
		return SW_Access_Action.Lanceur.STP;
	}
	
}
