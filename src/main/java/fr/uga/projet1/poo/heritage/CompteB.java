package fr.uga.projet1.poo.heritage;

public class CompteB implements Comparable<CompteB> {

	private String numero;
	private double solde;

	public CompteB() {
		System.out.println("dans le constructeur CompteB");
	}

	public CompteB(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void depot(double montant) {
		solde += montant;
	}

	@Override
	public int compareTo(CompteB o) {
		if (this.solde == o.solde)
			return 0;
		else if (this.solde > o.solde)
			return 1;
		else
			return -1;
	}
	
	@Override
	public String toString() {
		return "CompteB [numero=" + numero + ", solde=" + solde + "]";
	}
	
	

}
