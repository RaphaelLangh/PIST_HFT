package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import abstraction.fourni.Historique;
import abstraction.fourni.Indicateur;

/**
 * Classe modelisant une fenetre presentant graphiquement un Historique.
 * Cette classe est utilisee pour l'affichage des historiques.
 * 
 * Vous n'aurez pas, a priori, a utiliser directement cette classe
 * 
 * @author Romuald Debruyne
 */
public class FenetreHistorique extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Historique historique;
	private JLabel label;
    
	public FenetreHistorique(Indicateur i) {
		super("Historique "+i.getNom());
		this.historique = i.getHistorique();

		this.setLayout(new BorderLayout());
		this.label = new JLabel();
		this.label.setText(this.historique.toHtml());
		JScrollPane sp = new JScrollPane(label);
		this.add(sp, BorderLayout.CENTER);
		this.setSize(new Dimension(800,600));
	}
	public void setLabel(String s) {
		this.label.setText(s);
		if (this.isVisible()) {
			this.repaint();
		}
	}
}
