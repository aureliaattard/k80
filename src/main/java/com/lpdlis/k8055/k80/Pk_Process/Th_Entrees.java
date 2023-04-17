package com.lpdlis.k8055.k80.Pk_Process;

public class Th_Entrees extends Thread{
	
	private
	
	// Gestion de la fin du thread
	boolean Term = true;
	// Temps de Cycle de lecture des entr�es (en ms) 
	int CycleEntrees = 10;
	// R�f�rence sur l'objet Lancement
	Lancement m_L;

	public Th_Entrees(Lancement L)
	{
		m_L = L;
	}
	
	public void Finish()
	{
		Term = false;
	}
	
	public void setCycleEntrees(int Val)
	{
		CycleEntrees = Val;
	}
	
	public void run() {
		
        System.out.println("Demarrage du Thread Entrees");
        
        while (Term)
        {    
        	
        	// Mise � jour synchronis� des entrées physiques de la carte USB
			// en fonction de l'�tat des donn�es membres de l'objet m_L.STS
			//.
			//.
			//.
        	
        	
        	synchronized(m_L.LOCK_OBJ_CARTE) {
        		m_L.STE.DE1=m_L.Carte.ReadDigitalChannel(1);
            	m_L.STE.DE2=m_L.Carte.ReadDigitalChannel(2);
            	m_L.STE.DE3=m_L.Carte.ReadDigitalChannel(3);
            	m_L.STE.DE4=m_L.Carte.ReadDigitalChannel(4);
            	m_L.STE.DE5=m_L.Carte.ReadDigitalChannel(5);
            	
            	
            	m_L.STE.AnaE1=m_L.Carte.ReadAnalogChannel(1);
            	m_L.STE.AnaE2 =m_L.Carte.ReadAnalogChannel(2);
        		
        	}   	       	
    		
	    	        	
	        try {
				Thread.sleep(CycleEntrees);
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
        }
        System.out.println("Fin du thread Entrees!");
    }
}
