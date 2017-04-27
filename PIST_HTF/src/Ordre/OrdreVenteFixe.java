package Ordre;

import java.util.Comparator;

import abstraction.fourni.Acteurmodif;

public class OrdreVenteFixe extends OrdrePrixFixe {
	
	public OrdreVenteFixe(Acteurmodif auteur, float qtx,float prix,int step){
		super(auteur,qtx,prix,step);
	}
	
	public static class OrdreVenteSort {
	   public static final Comparator<OrdreVenteFixe> SORTBYPRICEDECROISSANT = 
	                                        new Comparator<OrdreVenteFixe>() {
	            public int compare(OrdreVenteFixe e1, OrdreVenteFixe e2) {
	                if(e2.getPrix()<e1.getPrix()){
	                	return -1 ;
	                }
	                else if(e1.getPrix()<e2.getPrix()){
	                	return 1 ;
	                }
	                else{
	                	return 0 ;
	                }
	            		
	            }
	            };


}

}
