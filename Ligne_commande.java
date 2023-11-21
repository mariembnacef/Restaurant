
public class Ligne_commande {
	//un plat et la quantite de ce plat
	private Plat plat_comm;
	private int nbr_assiettes;
	//getters and setters
	public Plat getPlat_comm() {
		return plat_comm;
	}
	public void setPlat_comm(Plat plat_comm) {
		this.plat_comm = plat_comm;
	}
	public int getNbr_assiettes() {
		return nbr_assiettes;
	}
	public void setNbr_assiettes(int nbr_assiettes) {
		this.nbr_assiettes = nbr_assiettes;
	}
	
	@Override
	public String toString() {
		return "Ligne_commande [plat_comm=" + plat_comm.toString() + ", nbr_assiettes=" + nbr_assiettes + "]";}
	
	public Ligne_commande(Plat plat_comm, int nbr_assiettes) {
		
		this.plat_comm = plat_comm;
		this.nbr_assiettes = nbr_assiettes;
	}
	
	
}
