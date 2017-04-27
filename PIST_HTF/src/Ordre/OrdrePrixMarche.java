package Ordre;

import abstraction.fourni.Acteurmodif;

public abstract class OrdrePrixMarche extends Ordre {
	
	public OrdrePrixMarche(Acteurmodif auteur, float qtx,int step){
		super(auteur,qtx,step);
	}
	
	public abstract String toString();

}
