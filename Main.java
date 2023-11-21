	import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
public class Main {

	public static void main(String[] args) {
		      
		        Gestion_plat gp =new Gestion_plat();
		        Gestion_commandes gc =new Gestion_commandes(); 
		        Gestion_caisse gca =new Gestion_caisse();
		        LocalDate d=LocalDate.now();
		              Scanner sc = new Scanner(System.in);
		            
		            int choix ;
		            do {
		                System.out.println("Veuillez entrer le numéro de l'opération ");
		                System.out.println(" 1:Ajouter un plat");
		                System.out.println("2:Modifier les détails d'un plat ");
		                System.out.println("3:Afficher les plats ");
		                System.out.println("4:Creer une commande");
		                System.out.println("5:Afficher une commande ");
		                System.out.println("6:Cloturer une commande ");
		                System.out.println("7:Afficher la recette journaliere d'aujourd'hui ");
		                System.out.println("8:Afficher la recette journaliere pendant une periode");
		                System.out.println("9:Afficher le chiffre d'affaires ");
		                
		                choix=sc.nextInt();

		                switch(choix) {
		                    case 1:gp.ajouter_plat();break;
		                    case 2:gp.modifier_details_plat();;break;
		                    case 3:gp.Afficher_plat(); break;
		                    //pour utiliser le gestionnaire_plat deja existant(on ne va pas creer un nv plat)
		                    case 4: gc.Creer_commande(gp);break;
		                    case 5:gc.AfficheCommande();break;
		                    case 6: gc.cloturercmd();break;
		                    case 7: System.out.println(gca.recette_journalière(d));
		                    case 8: gca.Afficherecette();
		                    case 9:{ System.out.println("entrez la periode:");
		                             String date1=sc.next();
		        	    	         String date2=sc.next();
		        	    	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        	    	         LocalDate d1=LocalDate.parse(date1,formatter);
		        			         LocalDate d2=LocalDate.parse(date2,formatter);
		                    	    gca.chiffreaff(d1, d2);
		                }
		                }
		            }while ( choix != 10 );
		    }}
