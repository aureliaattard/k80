package com.lpdlis.k8055.k80.Pk_Process;

public class Th_Sorties extends Thread{
	
	private
	
	// Gestion de la fin du thread
	boolean Term = true;
	// Temps de Cycle d'�criture des sorties (en ms) 
	int CycleSorties = 10;
	// R�f�rence sur l'objet Lancement
	Lancement m_L;

	public Th_Sorties(Lancement L)
	{
		m_L = L;
	}
	
	public void Finish()
	{
		Term = false;
	}
	
	public void setCycleSorties(int Val)
	{
		CycleSorties = Val;
	}
	
	public void run() {
		
        System.out.println("Demarrage du Thread Sorties");
        
        while (Term)
        {
			
			// Mise � jour synchronis� des sorties physiques de la carte USB
			// en fonction de l'�tat des donn�es membres de l'objet m_L.STS
        	synchronized(m_L.LOCK_OBJ_CARTE) {
        		 
        		//todo completer
        		StrucSorties tmp = (StrucSorties) m_L.STS.clone();

        		//pour les sorties analogiques avec les valeurs allant de 0 à 255 d'intensité
        		//traduction aucune led allumé - full allumé !
        		m_L.Carte.OutputAnalogChannel(1, tmp.AnaS1);
        		m_L.Carte.OutputAnalogChannel(2, tmp.AnaS2);
        		
        		if(tmp.DS1) {
        			m_L.Carte.SetDigitalChannel(1);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(1);
        		}
        		
        		if(tmp.DS2) {
        			m_L.Carte.SetDigitalChannel(2);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(2);
        		}
        		
        		
        		if(tmp.DS3) {
        			m_L.Carte.SetDigitalChannel(3);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(3);
        		}
        		
        		if(tmp.DS4) {
        			m_L.Carte.SetDigitalChannel(4);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(4);
        		}
        		
        		
        		if(tmp.DS5) {
        			m_L.Carte.SetDigitalChannel(5);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(5);
        		}
        		
        		
        		if(tmp.DS6) {
        			m_L.Carte.SetDigitalChannel(6);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(6);
        		}
        		
        		if(tmp.DS7) {
        			m_L.Carte.SetDigitalChannel(7);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(7);
        		}
        		
        		if(tmp.DS8) {
        			m_L.Carte.SetDigitalChannel(8);
        			
        		}else {
        			m_L.Carte.ClearDigitalChannel(8);
        		}
        		
        		
        	}
    			        	
	        try {
				Thread.sleep(CycleSorties);
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
        }
        System.out.println("Fin du thread Sorties!");
    }
	
	
	
}
