package abstraction.fourni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


import java.util.Observable;

import Historique.Statistique;
import Ordre.Ordre;
import Ordre.Ordre.*;
import Ordre.OrdreAchatMarche;
import Ordre.OrdreVenteMarche;


/**
 * Classe modelisant "le monde" vu comme un regroupement d'acteurs, 
 * d'indicateurs et de journaux. 
 * 
 * Les acteurs/indicateurs/journaux que vous creerez devront etre
 * ajoutes a l'unique instance de cette classe designee par la 
 * variable LE_MONDE. Le bon endroit pour creer les instances 
 * d'acteurs et les ajouter au monde est dans la methode peupler(),
 * laquelle est appelee juste apres la creation de l'unique instance
 * du Monde.
 *
 * @author Romuald Debruyne
 */
public class Monde extends Observable {

	// Il n'y aura qu'une seule instance de la classe Monde.
	// Pour acceder facilement a cette unique
	// instance de Monde vous pouvez utiliser la reference 
	// statique LE_MONDE.
	public static Monde LE_MONDE;
	
	private int step;                         // Le numero d'etape en cours
	private ArrayList<Acteurmodif> acteurs;        // La liste des acteurs
	private ArrayList<Indicateur> indicateurs;// La liste des indicateurs
	private ArrayList<Journal> journaux;      // La liste des journaux
	private Ordres ordres;			//Ordres passés par les acteurs
	private float prix ; 						// Prix du marché
	//private Statistique Stat ;		// les stats 
	
	/**
	 * Initialise le monde de sorte que le numero d'etape soit 0, 
	 * et qu'il n'y ait pour l'heure aucun acteur/indicateur/journal.
	 */
	public Monde(float prixdepart,Ordres ordre) {
		this.step=0;
		this.acteurs=new ArrayList<Acteurmodif>();
		this.indicateurs=new ArrayList<Indicateur>();
		this.journaux=new ArrayList<Journal>();
		this.prix = prixdepart;
		this.ordres = ordre;
	}
	/**
	 * Methode appelee juste apres la creation de l'unique 
	 * instance du Monde. C'est le bon endroit pour creer 
	 * vos instances d'acteurs et les ajouter au monde.
	 * 
	 * Dans la version fourniee deux acteurs sont crees et ajouter
	 * a titre d'exemple. Vous aurez bien evidemment a modifier 
	 * le corps de cette methode
	 */
	public void peupler(float valinit) {
		
		
		
		
		
		
	}
	/**
	 * @return Retourne le numero de l'etape en cours.
	 */
	public int getStep() {
		return this.step;
	}
	public Ordres getOrdres() {
		return this.ordres;
	}
	public void add(Ordre o){
		this.getOrdres().addOrdre(o);
	}
	public void removeOrdre(Ordre o){
		this.getOrdres().removeOrdre(o);
	}
	public void set (Ordres o) {
		this.ordres = o;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	/**
	 *met à jours le prix en fonction de la liste d'ordre
	 */
	public void updatePrix(){
		// initialisation des quantités disponible au prix du marche 
		float qtachatmarche = 0 ;
		float qtventemarche = 0 ;
					
		for(OrdreAchatMarche o : this.getOrdres().getOrdresachatmarche()){
			qtachatmarche = + o.getQtx() ;
			}
		for(OrdreVenteMarche o : this.getOrdres().getOrdresventemarche()){
			qtventemarche = + o.getQtx() ;
			}
		// si on a des ordres d'achat fixe et de vente fixe
		if(!this.getOrdres().getOrdresachatfixe().isEmpty()&&!this.getOrdres().getOrdresventefixe().isEmpty()){
			// on trie les ordres 
			this.getOrdres().sortOrdresachatfixe();
			this.getOrdres().sortOrdresventefixe();
			this.getOrdres().sortprix();
			
			float prix1 = this.getOrdres().getListedesprix().get(0);
			System.out.println(prix1);
			float qt1 = Math.min(this.getOrdres().qtdispoachat(prix1)+qtachatmarche,this.getOrdres().qtdispovente(prix1)+qtventemarche);
			System.out.println(qt1);
			int i = 0 ;
			System.out.println(this.getOrdres().getListedesprix().get(i+1));
			System.out.println(Math.min(this.getOrdres().qtdispoachat(this.getOrdres().getListedesprix().get(i+1))+qtachatmarche,this.getOrdres().qtdispovente(i+1)+qtventemarche));
			
			while(i<this.ordres.getListedesprix().size()-1&&qt1<=Math.min(this.getOrdres().qtdispoachat(this.getOrdres().getListedesprix().get(i+1))+qtachatmarche,this.getOrdres().qtdispovente(i+1)+qtventemarche)){
				System.out.println(qt1);
				prix1 = this.getOrdres().getListedesprix().get(i+1);
				qt1 = Math.min(this.getOrdres().qtdispoachat(this.getOrdres().getListedesprix().get(i+1))+qtachatmarche,this.getOrdres().qtdispovente(i+1)+qtventemarche) ;
				i++;
			}
			// ouf...
			this.setPrix(prix1);
		}
		// si on n'a pas d'ordre d'achat fixe mais des ordres de vente fixes 
		else if(this.getOrdres().getOrdresachatfixe().isEmpty()&&!this.getOrdres().getOrdresventefixe().isEmpty()&&qtachatmarche!=0){
			this.getOrdres().sortOrdresventefixe();
			int nbventefixe= this.getOrdres().getOrdresventefixe().size();
			int i = 0 ;
			float qtvente=this.getOrdres().getOrdresventefixe(0).getQtx()+qtventemarche;
			while(i<nbventefixe&&qtvente<qtachatmarche){
				i++;
				qtvente = + this.getOrdres().getOrdresventefixe(i).getQtx() ;
			}
			// si i=0 aucun ordre ne peut s'éxécuter 
			if(i!=0){
				this.prix = this.getOrdres().getOrdresventefixe(i-1).getPrix();
			}
		}
		// si on n'a pas d'ordre de vente fixe mais que des ordres d'achat fixes 
		else if(!this.getOrdres().getOrdresachatfixe().isEmpty()&&this.getOrdres().getOrdresventefixe().isEmpty()&&qtventemarche!=0){
			this.getOrdres().sortOrdresachatfixe();
			int nbachatfixe= this.getOrdres().getOrdresachatfixe().size();
			int i = 0 ;
			float qtachat=this.getOrdres().getOrdresachatfixe(0).getQtx()+qtachatmarche;
			while(i<nbachatfixe&&qtachat<qtventemarche){
				i++;
				qtachat = + this.getOrdres().getOrdresachatfixe(i).getQtx() ;
			}
			// si i=0 aucun ordre ne peut s'éxécuter 
			if(i!=0){
				this.prix = this.getOrdres().getOrdresachatfixe(i-1).getPrix();
			}
		}
		}
	
		
		
		
		
		
		
		
		
	
	/**
	 * Ajoute l'acteur a au monde
	 * @param a l'acteur a ajouter
	 */
	public void ajouterActeur(Acteurmodif a) {
		if (this.getActeur(a.getNom())==null) {
			this.acteurs.add(a);
		}
		else {
			System.out.println("addActeur : il existe deja un acteur de ce nom dans le monde...");
		}
	}
	/**
	 * Supprime l'acteur a au monde
	 * @param a l'acteur a supprimer
	 */
	public void supprimerActeur(Acteurmodif a){
		if(this.getActeur(a.getNom())==null){
			System.out.println("L'acteur a n'existe pas dans le monde");
		}
		else{
			this.acteurs.remove(a);
			System.out.println("L'acteur a a été supprimé");
		}
	}
	/**
	 * Ajoute l'indicateur i au monde
	 * @param i l'idicateur a ajouter
	 */
	public void ajouterIndicateur(Indicateur i) {
		this.indicateurs.add(i);
	}
	/**
	 * Ajoute le journal j au monde
	 * @param j le journal a ajouter
	 */
	public void ajouterJournal(Journal j) {
		this.journaux.add(j);
	}
	/**
	 * @return Retourne la liste des acteurs du monde
	 */
	public ArrayList<Acteurmodif> getActeurs() {
		return this.acteurs;
	}
	/**
	 * @param nom Le nom de l'acteur a retourner
	 * @return Si il existe dans le monde un acteur de nom nom, retourne cet acteur.
	 * Sinon, returne null. 
	 */
	public Acteurmodif getActeur(String nom) {
		int i=0; 
		while (i<this.acteurs.size() && !this.acteurs.get(i).getNom().equals(nom)) {
			i++;
		}
		if (i<this.acteurs.size()) {
			return this.acteurs.get(i);
		}
		else {
			//System.out.println("getActeur(\""+nom+"\") retourne null car il n'y a pas d'acteur portant ce nom");
			return null;
		}
	}
	/** 
	 * @return Retourne la liste des indicateurs du monde
	 */
	public ArrayList<Indicateur> getIndicateurs() {
		return this.indicateurs;
	}
	/**
	 * @param nom le nom de l'indicateur a retourner
	 * @return Si il existe dans le Monde un indicateur de nom nom
	 * retourne cet indicateur. Sinon, affiche un message d'alerte 
	 * et retourne null.
	 */
	public Indicateur getIndicateur(String nom) {
		int i=0; 
		while (i<this.indicateurs.size() && !this.indicateurs.get(i).getNom().equals(nom)) {
			i++;
		}
		if (i<this.indicateurs.size()) {
			return this.indicateurs.get(i);
		}
		else {
			System.out.println("getIndicateur(\""+nom+"\") retourne null car il n'y a pas d'indicateur portant ce nom");
			return null;
		}
	}
	/**
	 * @return Retourne la liste des journaux du monde
	 */
	public ArrayList<Journal> getJournaux() {
		return this.journaux;
	}
	/**
	 * Methode appelee lorsque l'utilisateur clique sur le bouton NEXT de l'interface graphique.
	 * Cette methode incremente le numero d'etape puis appelle la methode next() de chaque acteur du monde.
	 */
	public void next() {
		
		this.step++;
		
		this.setChanged();
		
		this.notifyObservers("step");
		
		
		// chaque acteur est sollicité pour passer un ordre 
		for (Acteurmodif a : this.acteurs) {
			a.next();
		}
		
		
	}
}
