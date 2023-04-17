package com.lpdlis.k8055.k80.Pk_Process;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class StrucSorties implements Cloneable {
	
	// Sorties analogiques (0 - 255)
	public  int AnaS1=0;
	public  int AnaS2=0; 
	
	// Sorties Digitales (0 - 1)
	public  boolean DS1=false;
	public  boolean DS2=false;
	public  boolean DS3=false;
	public  boolean DS4=false;
	public  boolean DS5=false;
	public  boolean DS6=false;
	public  boolean DS7=false;
	public  boolean DS8=false;
	
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
