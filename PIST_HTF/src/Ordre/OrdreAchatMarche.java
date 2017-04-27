package Ordre;

import abstraction.fourni.Acteurmodif;

public class OrdreAchatMarche extends OrdrePrixMarche{
	
	public OrdreAchatMarche(Acteurmodif auteur, float qtx,int step){
		super(auteur,qtx,step);
	}
	
	public String toString(){
		String s = "Ordre d'achat au prix du marche  par "+this.getIdxacteur().getNom();
		return s ;
	}


}
