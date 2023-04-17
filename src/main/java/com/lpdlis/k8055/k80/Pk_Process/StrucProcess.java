package com.lpdlis.k8055.k80.Pk_Process;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class StrucProcess implements Cloneable {
	
	// Etape en cours
	public  int Etape = 0;
	
	// D�finition de la fourchette de remplissage du container
	public  int Niveau_Remplissage_Min = 120;
	public  int Niveau_Remplissage_Max = 130;
	
	// D�finition de la fourchette de poids du container.
	public  int Poids_Minimum = 123;
	public  int Poids_Maximum = 128;
	
	// Red�finition de la m�thode clone de la classe
	public Object clone() {
		Object o= null;
		try {
			o = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			
		}
		return o;
	}

}
