package abstraction.fourni.v0;

import Ordre.OrdreVente;

public abstract class IVraiVendeur {
	
	private OrdreVente[] ordreventes;
	
	public abstract double quantiteMiseEnVente();
	public abstract void notificationVente(double quantite);
	
	
}
