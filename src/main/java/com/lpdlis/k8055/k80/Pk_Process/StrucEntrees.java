package com.lpdlis.k8055.k80.Pk_Process;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class StrucEntrees implements Cloneable{
	
	// Entr�es analogiques (0 - 255)
	public  int AnaE1=0;
	public  int AnaE2=0; 
	
	// Entr�es Digitales (0 - 1)
	public  boolean DE1=false;
	public  boolean DE2=false;
	public  boolean DE3=false;
	public  boolean DE4=false;
	public  boolean DE5=false;
	
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
