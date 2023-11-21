
public class Plat {
	//declaration des attributs
	protected String code;
	protected String nom;
	protected double prix;
	//getters and setters
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Plat [code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
	}
	//Constructeur parametre
	public Plat(String code, String nom, double prix) {
		
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	

}
