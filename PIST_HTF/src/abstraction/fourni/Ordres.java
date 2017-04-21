package abstraction.fourni;

import java.util.ArrayList;
import java.util.Collections;

import Ordre.*;

public class Ordres {
	
	private ArrayList<OrdreAchatFixe> ordresachatfixe ;
	private ArrayList<OrdreAchatMarche> ordresachatmarche ;
	private ArrayList<OrdreVenteFixe> ordresventefixe ;
	private ArrayList<OrdreVenteMarche> ordresventemarche ;
	
	public Ordres(){
		this.ordresachatfixe = new ArrayList<OrdreAchatFixe>() ;
		this.ordresventefixe = new ArrayList<OrdreVenteFixe>() ;
		this.ordresachatmarche = new ArrayList<OrdreAchatMarche>() ;
		this.ordresventemarche = new ArrayList<OrdreVenteMarche>() ;
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
	}
	public void addOrdresachatmarche(OrdreAchatMarche o){
		this.getOrdresachatmarche().add(o);
	}
	public void addOrdresventefixe(OrdreVenteFixe o){
		this.getOrdresventefixe().add(o);
	}
	public void addOrdresventemarche(OrdreVenteMarche o){
		this.getOrdresventemarche().add(o);
	}
	
	public void removeOrdresachatfixe(OrdreAchatFixe o){
		this.getOrdresachatfixe().remove(o);
	}
	public void removeOrdresachatmarche(OrdreAchatMarche o){
		this.getOrdresachatmarche().remove(o);
	}
	public void removeOrdresventefixe(OrdreVenteFixe o){
		this.getOrdresventefixe().remove(o);
	}
	public void removeOrdresventemarche(OrdreVenteMarche o){
		this.getOrdresventemarche().remove(o);
	}
	
	public void removeOrdresachatfixe(int o){
		this.getOrdresachatfixe().remove(o);
	}
	public void removeOrdresachatmarche(int o){
		this.getOrdresachatmarche().remove(o);
	}
	public void removeOrdresventefixe(int o){
		this.getOrdresventefixe().remove(o);
	}
	public void removeOrdresventemarche(int o){
		this.getOrdresventemarche().remove(o);
	}
	
	public void sortOrdresachatfixe(){
		Collections.sort(this.getOrdresachatfixe(),OrdreAchatSort);
	}
	
	
	

}
