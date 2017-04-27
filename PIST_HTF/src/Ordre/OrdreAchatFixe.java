package Ordre;

import java.util.Comparator;

import abstraction.fourni.Acteurmodif;

public class OrdreAchatFixe extends OrdrePrixFixe {
	
	public OrdreAchatFixe(Acteurmodif auteur, float qtx,float prix,int step){
		super(auteur,qtx,prix,step);
	}
	
	public static class OrdreAchatSort {
	    public static final Comparator<OrdreAchatFixe> SORTBYPRICECROISSANT = 
	                                        new Comparator<OrdreAchatFixe>() {
	            public int compare(OrdreAchatFixe e1, OrdreAchatFixe e2) {
	                if(e1.getPrix()<e2.getPrix()){
	                	return -1 ;
	                }
	                else if(e2.getPrix()<e1.getPrix()){
	                	return 1 ;
	                }
	                else{
	                	return 0 ;
	                }
	            		
	            }
	            };
	            }
	
	public String toString(){
		String s = "Ordre d'achat au prix de "+this.getPrix()+"$"+" par "+this.getIdxacteur().getNom();
		return s ;
	}
	
	
}
