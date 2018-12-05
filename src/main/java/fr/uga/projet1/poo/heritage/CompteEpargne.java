package fr.uga.projet1.poo.heritage;

public class CompteEpargne extends CompteB {

	private double taux;

	public CompteEpargne() {
		System.out.println("dans le constructeur CompteEpargne");
	}

	public CompteEpargne(String numero, double solde, double taux) {
		super(numero, solde);
		this.setTaux(taux);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public void depot(double montant) {
		super.depot(montant);
		setSolde(getSolde()+5);
	}
	
	
	
}
