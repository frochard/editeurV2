package memento;

import commandV2.*;

/**
 *Memento concret utilisé dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoSelectionner implements Memento {

	private SelectionnerEnregistrableV2 savedCommand;
	private int savedDebut;
	private int savedLongueur;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 * @param savedDebut Position du début de la sélection à sauvegarder dans un memento
	 * @param savedLongueur Longueur de la sélection à sauvegarder dans un memento
	 */
	public MementoSelectionner(SelectionnerEnregistrableV2 savedCommand, int savedDebut, int savedLongueur) {
		this.savedCommand = savedCommand;
		this.savedDebut = savedDebut;
		this.savedLongueur = savedLongueur;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegardée dans le memento
	 */
	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SelectionnerEnregistrableV2) savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegardée dans le memento
	 * @return savedCommand commande sauvegardée dans le memento
	 */
	public SelectionnerEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	/**
	 * renvoie le début de la sélection de la commande sauvegardée dans le memento
	 * @return savedDebut début de la sélection de la commande sauvegardée 
	 */
	public int getSavedDebut() {
		return savedDebut;
	}

	/**
	 * sauvegarde le début de la sélection de la commande 
	 * @param savedDebut début de la sélection de la commande 
	 */
	public void setSavedDebut(int savedDebut) {
		this.savedDebut = savedDebut;
	}

	/**
	 * renvoie la longueur de la sélection de la commande sauvegardée dans le memento
	 * @return savedLongueur longueur de la sélection de la commande sauvegardée 
	 */
	public int getSavedLongueur() {
		return savedLongueur;
	}

	/**
	 * sauvegarde la longueur de la sélection de la commande 
	 * @param savedLongueur longueur de la sélection de la commande 
	 */
	public void setSavedLongueur(int savedLongueur) {
		this.savedLongueur = savedLongueur;
	}
}