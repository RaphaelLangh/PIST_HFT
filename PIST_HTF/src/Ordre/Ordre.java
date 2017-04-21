package Ordre;

import java.util.Comparator;

import abstraction.fourni.Acteurmodif;

public abstract class Ordre implements Comparable<Ordre> {
	
	private float qtx ;
	
	private int step ; // le step auquel l'ordre a été passé ; 
	
	private Acteurmodif auteur ;
	
	public Ordre(Acteurmodif auteur, float qtx, int step){
		this.qtx = qtx ;
		this.auteur = auteur ;
		this.step = step ; 
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
	public int compareTo(Ordre o) {
		if(this.step<o.step){
			return -1 ;
		}
		else if(o.step<this.step){
			return 1 ;
		}
		else{
			return 0;
		}
	}
	
	
	

}
