package exo2;

public class Cours {
	private final int nbPlacesMax;
	private final int numeroCours;
	private final String intitule;

	public int getNbInscrits() {
		return nbInscrits;
	}
	public String getIntitule() {
		return intitule;
	}
	public int getNumeroCours() {
		return numeroCours;
	}
	public int getNbPlacesMax() {
		return nbPlacesMax;
	}

	private int nbInscrits;
	public Cours(int numeroCours, String intitule, int nbPlacesMax) {
		this.numeroCours = numeroCours;
		this.intitule = intitule;
		this.nbPlacesMax = nbPlacesMax;
		this.nbInscrits = 0;
	}
	public void inscription(int nbPlaces) throws PasAsseezDePlacesException {
		synchronized (this) {
			if (this.nombrePlacesRestant() < nbPlaces)
				throw new PasAsseezDePlacesException(this, nbPlaces);
			this.nbInscrits += nbPlaces;
		}
		System.out.println(nbPlaces+ " inscriptions réussies au cours "+this);
	}
	private int nombrePlacesRestant() {
		return (this.nbPlacesMax - this.nbInscrits);
	}
	@Override
	public String toString() {
		return String.valueOf(this.numeroCours) + " : " + intitule + " " + this.nombrePlacesRestant() + " places restants";
	}
}
