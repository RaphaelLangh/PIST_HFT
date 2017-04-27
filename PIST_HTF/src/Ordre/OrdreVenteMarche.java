package Ordre;

import abstraction.fourni.Acteurmodif;

public class OrdreVenteMarche extends OrdrePrixMarche {
	
	public OrdreVenteMarche(Acteurmodif auteur, float qtx,int step){
		super(auteur,qtx,step);
	}
	
	public String toString(){
		String s = "Ordre de vente au prix du marche par "+this.getIdxacteur().getNom();
		return s ;
	}

}
