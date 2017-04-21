package Ordre;

import abstraction.fourni.Acteurmodif;

public abstract class Ordre {
	
	private float qtx ;
	
	private Acteurmodif auteur ;
	
	public Ordre(Acteurmodif auteur, float qtx){
		this.qtx = qtx ;
		this.auteur = auteur ;
	}
	public float getQtx() {
		return qtx;
	}
	public void setQtx(float qtx) {
		this.qtx = qtx;
	}
	public Acteurmodif getIdxacteur() {
		return auteur;
	}
	public void setIdxacteur(Acteurmodif idxacteur) {
		this.auteur = idxacteur;
	}
	
	
	

}
