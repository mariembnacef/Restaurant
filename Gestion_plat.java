import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;

public class Gestion_plat {
	//liste contenant les plats
	private ArrayList<Plat> list_plat;
	
	//getters and setters pour la liste
public ArrayList<Plat> getList_plat() {
		return list_plat;
	}

	public void setList_plat(ArrayList<Plat> list_plat) {
		this.list_plat = list_plat;
	}
//constructeur
public Gestion_plat (){
	list_plat = new ArrayList<Plat>();
}
//methode qui sert à recherche si un plat est existant dans la liste
public Plat rech_plat(String ref){
	for(int i=0 ; i<list_plat.size();i++){
		if(list_plat.get(i).getCode().equals(ref))
		{ 
			return list_plat.get(i); 
		}
	}
	return null;
}
//ajouter un plat dans la liste en verifiant qu'il n'existe pas
public void ajouter_plat(){
	Scanner sc = new Scanner(System.in);
	//l'utilisateur doit entrer la reference du plat à ajouter
	System.out.println("saisir la reference du plat");
	String code_plat = sc.nextLine();
	//effectuer la recherche selon la reference entrée
	if(rech_plat(code_plat)!=null){
		System.out.println("le code du plat est deja existant");
	}else
	{ //saisi du nom et prix du plat
	System.out.println("saisir le nom du plat");
	String nom_plat = sc.nextLine();
	System.out.println("saisir le prix du plat");
	double prix_plat = sc.nextDouble();
	int choix;
	do{ //choisir la categorie de ce plat
    	System.out.println("Saisir la cathegorie de plat :");
    	System.out.println("1:entree");
    	System.out.println("2:suite");
    	System.out.println("3:dessert");
    choix=sc.nextInt();
   
    } while(!((choix==1)||(choix==2)||(choix==3)));
	
	if(choix==1)
	{ entree entre = new entree(code_plat,nom_plat,prix_plat);
		this.list_plat.add(entre);}
	else if (choix==2)
	{  suite st = new suite(code_plat,nom_plat,prix_plat);
		this.list_plat.add(st);}
	
	
	else { dessert dst = new dessert(code_plat,nom_plat,prix_plat);
		   this.list_plat.add(dst);}
	}
}
//methode qui sert à modifier les informations d'un plat
public void modifier_details_plat(){
	Scanner sc = new Scanner(System.in);
	//choisir la reference du plat à modifier
	System.out.println("saisir la reference du plat a modifier :");
	String code_plat = sc.nextLine();
	//verifier si le plat existe
	if(rech_plat(code_plat)==null){
		System.out.println("le code du plat n'existe pas!");
	}else
	{ int choix;
	do{ //choisir l'element à modifier
    	System.out.println("Saisir l'element à modifier :");
    	System.out.println("1:le nom du plat");
    	System.out.println("2:la reference du plat");
    	System.out.println("3:le prix du plat");
    choix=sc.nextInt();
   
    }while(!((choix==1)||(choix==2)||(choix==3)));
	
	if(choix==1) {System.out.println("Saisir le nouveau nom du plat : "); 
	               String nom=sc.next();
	               rech_plat(code_plat).setNom(nom);
	             }
	else if(choix==2) {System.out.println("Saisir la nouvelle reference du plat : ");
	                   String ref=sc.next();
	    if(rech_plat(ref)==null) {
		rech_plat(code_plat).setCode(ref);
	    } 
	  else System.out.println("Cette reference existe");
	                   }
	
	
	else {System.out.println("Saisir le nouveau prix du plat : ");
	      double nvprix=sc.nextDouble();
	      rech_plat(code_plat).setPrix(nvprix);
	     }
	}
}
//Affichage des plats ORDONNEE PAR REFERENCE et PAR CATEGORIE
public void Afficher_plat() {
	//ORDONNEE PAR REFERENCE
	//la méthode sort() utilisée pour trier les éléments présents dans la liste par ordre croissant.
	list_plat.sort(Comparator.comparing(p->p.getCode()));
	//ORDONNEE PAR CATEGORIE
	System.out.println("Entrée :");
	for(int i=0; i<list_plat.size();i++) {
		if(list_plat.get(i) instanceof entree)
		{
		System.out.println(list_plat.get(i).toString());
		}
	}
	
	System.out.println("Suite :");
	for(int i=0; i<list_plat.size();i++) 
		{if(list_plat.get(i) instanceof suite)
		{
			System.out.println(list_plat.get(i).toString());
		}
		
		}
	System.out.println("Dessert :");
	for(int i=0; i<list_plat.size();i++) 
	     {if(list_plat.get(i) instanceof dessert)
		 System.out.println(list_plat.get(i).toString());
	      }

	
}
}
