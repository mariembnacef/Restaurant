import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Commande {
	//declaration des attributs de la classe commmande 
	private int code_incr;
	private int num_table;
	private LocalDate date;
	private LocalTime heure;
	private ArrayList<Ligne_commande> list_comm;
	private String mode_paiement;
	private boolean cloture;

	//Getters and setters
	public int getCode_incr() {
		return code_incr;
	}
	public void setCode_incr(int code_incr) {
		this.code_incr = code_incr;
	}
	public int getNum_table() {
		return num_table;
	}
	public void setNum_table(int num_table) {
		this.num_table = num_table;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHeure() {
		return heure;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	public ArrayList<Ligne_commande> getList_comm() {
		return list_comm;
	}
	public void setList_comm(ArrayList<Ligne_commande> list_comm) {
		this.list_comm = list_comm;
	}
	
	public String getMode_paiement() {
		return mode_paiement;
	}
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	public boolean isCloture() {
		return cloture;
	}
	public void setCloture(boolean cloture) {
		this.cloture = cloture;
	}
	// Pour afficher la liste
		public String Affich_list(){
			String list_com="";
			for(int i=0 ;i<list_comm.size();i++){
			list_com=list_com+("produit num"+i+list_comm.get(i).toString());
			}
			return list_com;
		}
		//pour afficher la date
		public String Affich_date(){
			DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date_Formated = date.format(myFormat);
			return date_Formated;	
		}
		//pour afficher l'heure
		public String Affich_heure(){
			DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("hh-mm-ss");
			String heure_Formated = heure.format(myFormat);
			return heure_Formated;	
		}
	@Override
	public String toString() {
		return "ligne_commande_table [code_incr=" + code_incr + ", num_table=" + num_table + ", date=" + Affich_date()
				+ ", heure=" + Affich_heure() + ", list_comm=" + Affich_list() +",montant="+montantTotal() +
				 ", mode_paiement=" + mode_paiement + ", cloture=" + cloture + "]";
	}
	
	//calculer le montant total des commandes
	public double montantTotal() {
		double montant=0;
		for(int i=0; i<list_comm.size(); i++) {
			montant=montant+(list_comm.get(i).getNbr_assiettes()*list_comm.get(i).getPlat_comm().getPrix());
			
		}
		return montant;
	}
	
	
	
	
	
	//constructeur
	public Commande(int code_incr, LocalDate date, LocalTime heure, int num_table , ArrayList<Ligne_commande> list_comm) {
		
		
		this.code_incr=code_incr;
		Scanner sc= new Scanner(System.in); 
	    this.num_table = num_table;
	    this.date=date;
	    this.heure=heure;
	    this.list_comm = list_comm;
	    String choix;
	    do{
	    	System.out.println("Saisir le mode de paiment :");
	    	System.out.println("1:espece");
	    	System.out.println("2:cheque");
	    	System.out.println("3:carte bancaire");
	    choix=sc.next();
	   
	    }while(!((choix.equals("espece"))||(choix.equals("cheque"))||(choix.equals("cb"))));
	    this.mode_paiement=choix;
	    
	    //false par defaut car le client est encore dans notre restaurant !
	    this.cloture=false;
	    
	}
	
	
	
}
