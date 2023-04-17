package com.lpdlis.k8055.k80.Pk_Process;

import java.util.Date;

public class Th_Process extends Thread{

	private
	
	// Gestion de la fin du thread
	boolean Term = true;
	// Temps de Cycle du thread Process (en ms) 
	int CycleProcess = 10;
	// R�f�rence sur l'objet Lancement
	Lancement m_L;
	
	// Copie de l'objet m_L.STE
	StrucEntrees m_STE; 
	// Copie de l'objet m_L.STS
	StrucSorties m_STS;

	int timestamp = 0;
	
	public Th_Process(Lancement L)
	{
		m_L = L;
	}
	
	public void Finish()
	{
		Term = false;
	}
	
	public void run() {
	
        System.out.println("Demarrage du Thread Process");
           
        while (Term)
        {
            	
			// 	 synchonisée des objets  m_L.STE et m_L.STS dans m_STE et m_STS
        	// A revoir
        	 	
        	m_STE = (StrucEntrees) m_L.STE.clone();
    		m_STS = (StrucSorties) m_L.STS;
 
			// Test D�faut
        	if (m_L.STP.Etape>0)// pour pourvoir compiler de base ct if(...)
			{
//        		A tout moment un défaut peut survenir (Appui sur l'entrée E1 après démarrage de la ligne) 
//        				– le process est suspendu.
//        				– Les sorties clignotes (fréquence 2 secondes)
//        				– Traitement du défaut dans une étape spécifique du thread « Process »
//        				– Raz du défaut par l'appui sur l'entrée E5
//        				– Reprise du cycle.
        		
        		
			}
        
        		     	
						
			// Gestion des �tapes du process
	        switch (m_L.STP.Etape)
	        {
		        case 0 :
		        	m_STS.DS1 = false;
		        	m_STS.DS2 = false;
		        	m_STS.DS3 = false;
		        	m_STS.DS4 = false;
		        	m_STS.DS5 = false;
		        	m_STS.DS6 = false;
		        	m_STS.DS7 = false;
		        	m_STS.DS8 = false;
		        	System.out.println("Appuyez sur le bouton 1");
		        	if (m_STE.DE1)
		        	{			        	
		        		
		        		m_L.STP.Etape = 1;
		        		m_STS.DS1 = true;
			        	System.out.println("Machine en marche !");
		        		
		        	}
		        	break;
		        	
		        case 1 :  
		        	//Appui sur E1.
		        	//Démarrage de la chaîne de production.
		        	//La sortie D1 s'allume indiquant que la ligne est en production.
		        	//Le containers se déplace jusqu'au au poste de remplissage.
		        	m_L.STP.Etape = 2;
		        	System.out.println("Le Conteneur se déplace");
		        	break;
		        	
		        case 2 : //Attendre 30 secondes.
		            //Pendant ce temps, la sortie D2 clignote (fréquence 1 seconde)
		            //La sortie D2 s'allume fixe indiquant que le conteneur est en position.
		            int i = 0;
		            while(i<1) { //TODO CHANGER
		                m_STS.DS2 = true; // La LED est allumée
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                m_STS.DS2 = false; // La LED est éteinte
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                i++;
		            }
		            m_STS.DS2 = true; // La LED est allumée en continu
		            System.out.println("Le conteneur est en position");
		            m_L.STP.Etape=3;
		            break;
		        	
		        case 3: //Rotation potentiomètre Ana 1 (avec un tournevis).
		        	// On tourne le potentiomètre jusqu’à atteindre le niveau indiqué entre Min et Max
		        	// remplissage dans la classe « StrucProcess ».
		        	// La sortie D3 s'allume indiquant que le containers est correctement rempli.
		        	System.out.println("La valeur de Potentiomètre 1 " + m_STE.AnaE1);
		        	if(m_STE.AnaE1>m_L.STP.Niveau_Remplissage_Min &&m_STE.AnaE1<m_L.STP.Niveau_Remplissage_Max ) {
		        		
		        		m_STS.DS3=true;
			        	m_L.STP.Etape=4;
			        	System.out.println("le containers est correctement rempli.");
		        		
		        		
		        	}
		        	
		        	
					break;
		        	
		        case 4: // Appui sur E2.
		        	//Le containers se déplace vers le poste de contrôle.
		        	//La sortie D2 s'éteint.
					//
		        	System.out.println("Appuyez sur le bouton 2");
		        	if (m_STE.DE2)
		        	{			        	
		        		
		        		m_STS.DS2 = false;
			        	System.out.println("Le containers se déplace vers le poste de contrôle.");
			        	m_L.STP.Etape=5;
		        		
		        	}
					break;
		     
		        case 5: //Attendre 30 secondes.
		        	//.Pendant se temps la sortie D4 clignote (Fréquence 1 seconde)
		        	//La sortie D4 s'allume fixe indiquant que le containers est en position
					//.
					//.
		        	int i1 = 0;
		            while(i1<5) {
		                m_STS.DS4 = true; // La LED est allumée
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                m_STS.DS4 = false; // La LED est éteinte
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                i1++;
		            }
		            System.out.println("Le conteneur est en position");
		            m_L.STP.Etape=6;
		            break;
		        	
		        	
		        case 6: //Rotation potentiomètre Ana 2 (avec un tournevis)
		        	//. On tourne le potentiomètre pour indiquer un poids.
					//.
					//.
		        	
		        	m_L.STP.Etape=7;
		        	
		        	break;
				
				case 7: //Attendre 45 secondes
		        	// .On compare la valeur indiquée par le potentiomètre à celle comprise entre Min et
					// Max poids dans la classe « StrucProcess ».
					// Si OK : La sortie D5 s'allume indiquant que le poids du containers est correct.
					// Si Non : La sortie D5 clignote(fréquence 0,5 seconde) indiquant que le poids
					// du containers n'est pas correct.
					//.
					//.
					
					System.out.println("Valeur du potentiomètre 2 " + m_STE.AnaE2);
					if(m_STE.AnaE2>m_L.STP.Poids_Minimum && m_STE.AnaE2<m_L.STP.Poids_Maximum) {
						int i2=0;
						while(i2<5) {//boucle de 45 s
		            		
		            		m_STS.DS5 = true; // La LED est allumée
			                try {
			                    Thread.sleep(500); // On attend 0,5 seconde
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                }
			                try {
			                    Thread.sleep(500); // On attend 0,5 seconde
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                }
		            		
		        
			                i2++;
		            	}
		              
		                
						m_STS.DS5=true;
	            		System.out.println("le poid du containers est correct");
	            		m_L.STP.Etape=8;
						
					}else {
						int i2=0;
						System.out.println("le poid du containers n'est pas correct");
						while(i2<5) {//boucle de 45 s
		            		
		            		m_STS.DS5 = true; // La LED est allumée
			                try {
			                    Thread.sleep(500); // On attend 0,5 seconde
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                }
			                m_STS.DS5 = false; // La LED est éteinte
			                try {
			                    Thread.sleep(500); // On attend 0,5 seconde
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                }
		            		
			                i2++;
		            		
		            	}



					}
		            break;
					
					
				case 8: //Appui sur E3. (Si poids correct)
		        	// Le containers se déplace vers le poste d'expédition.
					// La sortie D4 s'éteint.
					//.
					//.
					System.out.println("Appuyez sur le bouton 3");
					if(m_STE.DE3) {
						System.out.println("Le containers se déplace vers le poste d'expédition.");
						m_STS.DS4=false;
						m_L.STP.Etape=9;
					}

		        	break;
					
				case 9:
		        	//. Si poids correct : Attendre 30sec
				    // Pendant se temps la sortie D6 clignote (Fréquence 1 seconde)
					// La sortie D6 s'allume fixe indiquant que le containers est en position.
					//.
					//.
					
					
					int i3 = 0;
		            while(i3<5) {
		                m_STS.DS6 = true; // La LED est allumée
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                m_STS.DS6 = false; // La LED est éteinte
		                try {
		                    Thread.sleep(500); // On attend 0,5 seconde
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                i3++;
		            }
		            m_STS.DS6 = true; // La LED est allumée en continu
		            System.out.println("Le conteneur est en position");
		            m_L.STP.Etape=10;
		        	break;
					
				case 10:
		        	//. Si poids correct : Appui sur E4.
					//. La sortie D8 s'allume.
					
					// Si poids incorrect : 
					//. La sortie D7 s'allume indiquant la mise au rebut du container
					
					System.out.println("Valeur du potentiomètre 2 " + m_STE.AnaE2);
					if(m_STE.AnaE2>m_L.STP.Poids_Minimum && m_STE.AnaE2<m_L.STP.Poids_Maximum) {
						System.out.println("Poids correct");
						System.out.println("Appuyez sur le bouton 4");
						if(m_STE.DE4) {
							
							m_STS.DS8=true;
							m_L.STP.Etape=11;
							
						}
					}else {
						System.out.println("mise au rebut du container");
						
					}
					
		        	break;
		        	
		        case 11:
		        	//. Si poids correct : Attendre 15 secondes
		        	// Expédition effectuée.
		        	// La sortie D3 s'éteint.
		        	// La sortie D5 s'éteint.
		        	// La sortie D6 s'éteint.
		        	// La sortie D8 s'éteint.
					//.
					//. Si poids incorrect : Appui sur E4
		        	//La sortie D3 s'éteint.
		        	// La sortie D5 s'éteint.
		        	// La sortie D7 s'éteint.
		        	// Fin de process. Retour à l'étape 1.
		        	System.out.println("Valeur du potentiomètre 2 " + m_STE.AnaE2);
		        	if(m_STE.AnaE2>m_L.STP.Poids_Minimum && m_STE.AnaE2<m_L.STP.Poids_Maximum) {
		        		
		        		int i4 = 0;
			            while(i4<15) {
			                try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                i4++;
			                
			                
			            }
			            m_STS.DS3=false;
	        			m_STS.DS5=false;
	        			m_STS.DS6=false;
	        			m_STS.DS8=false;
		        		
		        	}else {
		        		System.out.println("Appuyez sur le bouton 4 car poids incorrecte");
		        		if(m_STE.DE4) {
		        			m_STS.DS3=false;
		        			m_STS.DS5=false;
		        			m_STS.DS7=false;
		        			
		        		}
		        	}
		        	break;
					
				case 100 :
					// Traitement des d�fauts
					//.
					//.
					//.
					
				default :

					break;
		        	
	        }
	        
        	
	        try {
				Thread.sleep(CycleProcess);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        System.out.println("Fin du thread Process!");
    }
/*
	private getDifTimestamp() {
		Date date = new Date();
		//int now = new Timestamp(date.getTime());
	}
*/
}
