package Ordre;

import abstraction.fourni.Acteurmodif;

public abstract class OrdrePrixFixe extends Ordre {
	
	private float prix ;
	
	public OrdrePrixFixe(Acteurmodif auteur, float qtx,float prix){
		super(auteur,qtx);
		this.prix=prix;
	}

	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	

}
