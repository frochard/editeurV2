package memento;

import commandV2.*;

public class MementoSelectionner implements Memento {

	private SelectionnerEnregistrableV2 savedCommand;
	private int savedDebut;
	private int savedLongueur;

	/**
	 * 
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 * @param savedDebut Position du début de la sélection à sauvegarder dans un memento
	 * @param savedLongueur Longueur de la sélection à sauvegarder dans un memento
	 */
	public MementoSelectionner(SelectionnerEnregistrableV2 savedCommand, int savedDebut, int savedLongueur) {
		this.savedCommand = savedCommand;
		this.savedDebut = savedDebut;
		this.savedLongueur = savedLongueur;
	}

	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SelectionnerEnregistrableV2) savedCommand;
	}
   
	public SelectionnerEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	public int getSavedDebut() {
		return savedDebut;
	}

	public void setSavedDebut(int savedDebut) {
		this.savedDebut = savedDebut;
	}

	public int getSavedLongueur() {
		return savedLongueur;
	}

	public void setSavedLongueur(int savedLongueur) {
		this.savedLongueur = savedLongueur;
	}

}