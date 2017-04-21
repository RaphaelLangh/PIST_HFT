package abstraction.fourni;

import decision.*;

/**
 * Tout acteur doit implementer cette interface
 * 
 * Vous aurez donc a creer une/des implementation(s) de cette classe
 * 
 * @author Romuald Debruyne
 *
 */

// Un acteur correspond à un acheteur/ vendeur 


public abstract class Acteurmodif {
	
	private float solde ; // l'argent en possession de l'acteur 
	
	private float qtaction ; // laquantité d'action que possède l'acteur 
	
	private String nom ; // Son nom 
	
	private int idx ; // Un indentifiant unique
	
	private Decisionel decision ; // la stratégie suivit par l'acteur 

	
/// Getter et Setter 
	
	/**
	 * @return Le nom de l'acteur
	 */
	public String getNom(){
		return this.nom ;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public float getQtaction() {
		return qtaction;
	}
	public void setQtaction(float qtaction) {
		this.qtaction = qtaction;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

/// Methodes diverses 
	
	
	/**
	 * @return met à jour la quantité d'action et le solde de l'acteur pour l'achat de qtx de l'action
	 * pour un certain prix unitaire
	 */
	
	public void acheter(float qtx,float prix){
		this.setQtaction(this.getQtaction()+qtx);
		this.setSolde(this.getSolde()-qtx*prix);
	}
	
	/**
	 * @return met à jour la quantité d'action et le solde de l'acteur pour la vente de qtx de l'action
	 * pour un certain prix unitaire
	 */
	
	
	public void vendre(float qtx,float prix){
		this.setQtaction(this.getQtaction()-qtx);
		this.setSolde(this.getSolde()+qtx*prix);
	}


	/**
	 * Methode de l'acteur invoquee suite a l'appui sur le bouton NEXT de la fenetre principale
	 */
	public abstract void next();
}
