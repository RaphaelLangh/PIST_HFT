package abstraction.fourni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Ordre.OrdreAchatFixe.OrdreAchatSort;
import Ordre.OrdreVenteFixe.OrdreVenteSort;

import Ordre.*;

public class Ordres {
	
	private ArrayList<OrdreAchatFixe> ordresachatfixe ;
	private ArrayList<OrdreAchatMarche> ordresachatmarche ;
	private ArrayList<OrdreVenteFixe> ordresventefixe ;
	private ArrayList<OrdreVenteMarche> ordresventemarche ;
	private ArrayList<Float> listedesprix ;
	
	public Ordres(){
		this.ordresachatfixe = new ArrayList<OrdreAchatFixe>() ;
		this.ordresventefixe = new ArrayList<OrdreVenteFixe>() ;
		this.ordresachatmarche = new ArrayList<OrdreAchatMarche>() ;
		this.ordresventemarche = new ArrayList<OrdreVenteMarche>() ;
		this.listedesprix = new ArrayList<Float>();
	}

	public ArrayList<OrdreAchatFixe> getOrdresachatfixe() {
		return ordresachatfixe;
	}
	public void setOrdresachatfixe(ArrayList<OrdreAchatFixe> ordresachatfixe) {
		this.ordresachatfixe = ordresachatfixe;
	}
	public ArrayList<OrdreAchatMarche> getOrdresachatmarche() {
		return ordresachatmarche;
	}
	public void setOrdresachatmarche(ArrayList<OrdreAchatMarche> ordresachatmarche) {
		this.ordresachatmarche = ordresachatmarche;
	}
	public ArrayList<OrdreVenteFixe> getOrdresventefixe() {
		return ordresventefixe;
	}
	public void setOrdresventefixe(ArrayList<OrdreVenteFixe> ordresventefixe) {
		this.ordresventefixe = ordresventefixe;
	}
	public ArrayList<OrdreVenteMarche> getOrdresventemarche() {
		return ordresventemarche;
	}
	public void setOrdresventemarche(ArrayList<OrdreVenteMarche> ordresventemarche) {
		this.ordresventemarche = ordresventemarche;
	}
	public ArrayList<Float> getListedesprix() {
		return listedesprix;
	}
	public void setListedesprix(ArrayList<Float> listedesprix) {
		this.listedesprix = listedesprix;
	}

	public OrdreAchatFixe getOrdresachatfixe(int i) {
		return ordresachatfixe.get(i);
	}
	public OrdreAchatMarche getOrdresachatmarche(int i) {
		return ordresachatmarche.get(i);
	}
	public OrdreVenteFixe getOrdresventefixe(int i) {
		return ordresventefixe.get(i);
	}
	public OrdreVenteMarche getOrdresventemarche(int i) {
		return ordresventemarche.get(i);
	}
	
	public void addOrdresachatfixe(OrdreAchatFixe o){
		this.getOrdresachatfixe().add(o);
		if(!this.getListedesprix().contains(o.getPrix())){
			this.getListedesprix().add(o.getPrix());
		}
	}
	public void addOrdresachatmarche(OrdreAchatMarche o){
		this.getOrdresachatmarche().add(o);
	}
	public void addOrdresventefixe(OrdreVenteFixe o){
		this.getOrdresventefixe().add(o);
		if(!this.getListedesprix().contains(o.getPrix())){
			this.getListedesprix().add(o.getPrix());
		}
	}
	public void addOrdresventemarche(OrdreVenteMarche o){
		this.getOrdresventemarche().add(o);
	}
	
	public void removeOrdresachatfixe(OrdreAchatFixe o){
		this.getOrdresachatfixe().remove(o);
		int i = 0 ;
		while(i<this.getOrdresachatfixe().size()&&this.getOrdresachatfixe(i).getPrix()!=o.getPrix()){
			i++;
		}
		if(i==this.getOrdresachatfixe().size()){
			i=0;
			while(i<this.getOrdresventefixe().size()&&this.getOrdresventefixe(i).getPrix()!=o.getPrix()){
				i++;
			}
		}
		if(i==this.getOrdresventefixe().size()){
			this.listedesprix.remove(o.getPrix());
		}
	}
	public void removeOrdresachatmarche(OrdreAchatMarche o){
		this.getOrdresachatmarche().remove(o);
	}
	public void removeOrdresventefixe(OrdreVenteFixe o){
		this.getOrdresventefixe().remove(o);
		int i = 0 ;
		while(i<this.getOrdresachatfixe().size()&&this.getOrdresachatfixe(i).getPrix()!=o.getPrix()){
			i++;
		}
		if(i==this.getOrdresachatfixe().size()){
			i=0;
			while(i<this.getOrdresventefixe().size()&&this.getOrdresventefixe(i).getPrix()!=o.getPrix()){
				i++;
			}
		}
		if(i==this.getOrdresventefixe().size()){
			this.listedesprix.remove(o.getPrix());
		}
	}
	public void removeOrdresventemarche(OrdreVenteMarche o){
		this.getOrdresventemarche().remove(o);
	}
	
	public void removeOrdresachatfixe(int o){
		float prix = this.getOrdresachatfixe(o).getPrix();
		this.getOrdresachatfixe().remove(o);
		int i = 0 ;
		while(i<this.getOrdresachatfixe().size()&&this.getOrdresachatfixe(i).getPrix()!=prix){
			i++;
		}
		if(i==this.getOrdresachatfixe().size()){
			i=0;
			while(i<this.getOrdresventefixe().size()&&this.getOrdresventefixe(i).getPrix()!=prix){
				i++;
			}
		}
		if(i==this.getOrdresventefixe().size()){
			this.listedesprix.remove(prix);
		}
	}
	public void removeOrdresachatmarche(int o){
		this.getOrdresachatmarche().remove(o);
	}
	public void removeOrdresventefixe(int o){
		float prix = this.getOrdresachatfixe(o).getPrix();
		this.getOrdresventefixe().remove(o);
		int i = 0 ;
		while(i<this.getOrdresachatfixe().size()&&this.getOrdresachatfixe(i).getPrix()!=prix){
			i++;
		}
		if(i==this.getOrdresachatfixe().size()){
			i=0;
			while(i<this.getOrdresventefixe().size()&&this.getOrdresventefixe(i).getPrix()!=prix){
				i++;
			}
		}
		if(i==this.getOrdresventefixe().size()){
			this.listedesprix.remove(prix);
		}
	}
	public void removeOrdresventemarche(int o){
		this.getOrdresventemarche().remove(o);
	}
	
	public void addOrdre(Ordre o){
		if(o instanceof OrdreAchatFixe){
			this.addOrdresachatfixe((OrdreAchatFixe) o);
		}
		else if(o instanceof OrdreVenteFixe){
			this.addOrdresventefixe((OrdreVenteFixe) o);
		}
		else if(o instanceof OrdreAchatMarche){
			this.addOrdresachatmarche((OrdreAchatMarche) o);
		}
		else {
			this.addOrdresventemarche((OrdreVenteMarche) o);
		}
	}
	
	public void addOrdre(Ordre[] os){
		for(Ordre o : os){
			this.addOrdre(o);
		}
	}
	
	public void removeOrdre(Ordre o){
		if(o instanceof OrdreAchatFixe){
			this.removeOrdresachatfixe((OrdreAchatFixe) o);
		}
		else if(o instanceof OrdreVenteFixe){
			this.removeOrdresventefixe((OrdreVenteFixe) o);
		}
		else if(o instanceof OrdreAchatMarche){
			this.removeOrdresachatmarche((OrdreAchatMarche) o);
		}
		else {
			this.removeOrdresventemarche((OrdreVenteMarche) o);
		}
	}
	
	
	public void sortOrdresachatfixe(){
		Collections.sort(this.getOrdresachatfixe(),OrdreAchatSort.SORTBYPRICEDECROISSANT);
	}
	
	public void sortOrdresventefixe(){
		Collections.sort(this.getOrdresventefixe(),OrdreVenteSort.SORTBYPRICECROISSANT);
	}
	
	public void sortprix(){
		Collections.sort(this.getListedesprix());
	}
	
	/* renvoit la quantité FIXE disponible pour un certain prix en supposant le classement
	 * par ordre croissant de ordresachatfixe
	*/
	public float qtdispoachat(float prix){
		float qt = 0 ;
		int i = 0 ;
		int n = this.getOrdresachatfixe().size();
		while(i<n&&this.getOrdresachatfixe(i).getPrix()>=prix){
			qt = qt + this.getOrdresachatfixe(i).getQtx() ;
			i++;
		}
		return qt ;
	}
	public float qtdispovente(float prix){
		float qt = 0 ;
		int i = 0 ;
		int n = this.getOrdresventefixe().size();
		while(i<n&&this.getOrdresventefixe(i).getPrix()<=prix){
			qt = qt + this.getOrdresventefixe(i).getQtx() ;
			i++;
		}
			
		return qt ;
	}
	
	public String toString(){
		String s = "Odres achat fixe : " ;
		for(OrdreAchatFixe ord : this.getOrdresachatfixe()){
			s = s + "[ "+ord.toString()+" ]" ;
		}
		s=s+"\n";
		s= s +  "Odres vente fixe : " ;
		for(OrdreVenteFixe ord : this.getOrdresventefixe()){
			s = s + "[ "+ord.toString()+" ]" ;
		}
		s=s+"\n";
		s= s +  "Odres achat marche : " ;
		for(OrdreAchatMarche ord : this.getOrdresachatmarche()){
			s = s + "[ "+ord.toString()+" ]" ;
		}
		s=s+"\n";
		s= s +  "Odres vente marche : " ;
		for(OrdreVenteMarche ord : this.getOrdresventemarche()){
			s = s + "[ "+ord.toString()+" ]" ;
		}
		s=s+"\n";
		s = s +  "liste des prix : " ;
		for(float ord : this.getListedesprix()){
			s = s + "[ "+ord+" ]" ;
		}
		s=s+"\n";
		return s;
	}
	
	

}
