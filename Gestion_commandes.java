import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
public class Gestion_commandes {
	int code=1;
	//liste des commandes 
	ArrayList <Commande> lstcmd = new ArrayList<Commande>();
	
     //methode qui recherche la commande d'une table 
    public Commande RechNumTable(int num) {
    	//parcourir la liste des commandes
    	for(int i=0; i<lstcmd.size();i++) {
        	if(lstcmd.get(i).getNum_table()==num) {
        		//retourner la commande de la table num
        		return lstcmd.get(i);
        	} 
    } return null;}
    	
    	//CREATION D'UNE COMMANDE
    public void Creer_commande(Gestion_plat g ) {
    	//liste contenant les lignes de commande
    	ArrayList <Ligne_commande> ligne = new ArrayList<Ligne_commande>();
    	
    	Scanner sc = new Scanner(System.in);
    	//la date et l'heure de cette commande
    	LocalDate date_commande = LocalDate.now();
        LocalTime heure_commande = LocalTime.now();
        //declaration du numero de la table
       int numTable;
       //Tant que le num de table existe et la table est occupée => réécrire le num
       //la table est libre apres sa cloture
       do { System.out.println("Entrez le numero de la table : ");
       numTable=sc.nextInt();
        }while((RechNumTable(numTable)!=null)&&(RechNumTable(numTable).isCloture()==false));
  
       
       int choix;
       
       
       
     //la reference et la quanitité demandée
     String ref;
     int qte;
       do { 
    	 System.out.println("Entrez la reference du plat du client");
      ref=sc.next();
      //si le plat existe, demander la saisi de la quantite
      if(g.rech_plat(ref)!=null) 
      {
    	  System.out.println( "donnez la quantité demandée ");
    	  qte=sc.nextInt();
    	  Ligne_commande lignecmd = new Ligne_commande(g.rech_plat(ref),qte);
    	  ligne.add(lignecmd);
      } 
     
      System.out.println("Pour ajouter une autre ligne tapez 2");
      choix=sc.nextInt();
     }while(choix==2); 
     
     //CREATION DE LA COMMANDE
     Commande cmd = new Commande(code,date_commande,heure_commande,numTable ,ligne);
     //ajouter la commande dans la liste des commandes
     lstcmd.add(cmd);
     //l'incrementation du code
     this.code++;
        	}
    
    //AFFICHAGE COMMANDES
    public void AfficheCommande() {
    	for(int i=0;i<lstcmd.size();i++) {
    		System.out.println(lstcmd.get(i).toString());
    	}
    }
    
    //RECHERCHER UNE COMMNADE 
    public Commande RechCmd(int cd) {
    	for(int i=0 ; i<lstcmd.size();i++){
    		if( lstcmd.get(i).getCode_incr()==cd )
    		{ 
    			return lstcmd.get(i); 
    		}
    	}
    	return null;
    
    }
    //CLOTURER UNE COMMANDE
    public void cloturercmd() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Entrez le code de cette commande à cloturer:");
    	int codecmd=sc.nextInt();
    	if(RechCmd(codecmd)!=null) {
    		Commande cmd= RechCmd(codecmd);
    		//changer cloture de false vers true
    		cmd.setCloture(true);
    	}
    	else System.out.println("la commande n'existe pas");
    }
    
    
    }

