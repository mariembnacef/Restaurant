import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class Gestion_caisse {
	Gestion_commandes gc = new Gestion_commandes();
	
	//CALCUL DE LA RECETTE JOURNALIERE
	public double recette_journalière(LocalDate d)
	{

	
	double montant=0.0;
	for(int i=0;i<this.gc.lstcmd.size();i++)
	{
	if(this.gc.lstcmd.get(i).getDate().isEqual(d))
	{

	montant=montant+this.gc.lstcmd.get(i).montantTotal();
	}
	}
	return montant;

	}
	//methode qui affiche la recette entre 2 date
    public void Afficherecette() {
	  	Scanner sc = new Scanner(System.in);
	   	//FORMATAGE DES DEUX DATES DE LA PERIODE
	    //l'utilisateur saisi la periode durant laquelle il veut afficher la recette journaliere
	    System.out.println("Entrez la periode :");
	   	String date1=sc.next();
	   	String date2=sc.next();
	   	// Instantiation de l'objet de formattage pour l'affichage
	   	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	//Formatage de la dateet stockage dans une variable LocalDate
	    LocalDate dt1=LocalDate.parse(date1,formatter);
		LocalDate dt2=LocalDate.parse(date2,formatter);
		//appelle de la methode qui calcul la recette durant cette date
		System.out.println("la recette journaliere à la 1ère date est:");
		 recette_journalière(dt1);
		 System.out.println("la recette journaliere à la 2ème date est:");
		 recette_journalière(dt2);
	
	    }
	    //methode qui sert a calculer le chiffre d'affaires
	    public void chiffreaff(LocalDate d1, LocalDate d2) {
	    double resultat=0;
	    //calculer le total de la recette journaliere pendant cette periode tq d1<d2
	    //parcourir toutes les journées entre d1 et d2
	    for(LocalDate i=d1;i.isBefore(d2);i.plusDays(1))
	    {resultat=resultat+recette_journalière(i);}
	    System.out.println("Le chiffre d'affaire de notre est restaurant est:"+resultat);
	    }
}
