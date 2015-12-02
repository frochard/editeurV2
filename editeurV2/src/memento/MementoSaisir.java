package memento;

import commandV2.*;

/**
 *Memento concret utilisé dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoSaisir implements Memento {

	private SaisirEnregistrableV2 savedCommand;
	private String savedTxt;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 * @param savedTxt Texte de la commande saisir à sauvegarder dans un memento
	 */
	public MementoSaisir(SaisirEnregistrableV2 savedCommand, String savedTxt) {
		this.savedCommand = savedCommand;
		this.savedTxt = savedTxt;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegardée dans le memento
	 */
	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SaisirEnregistrableV2) savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegardée dans le memento
	 * @return savedCommand commande sauvegardée dans le memento
	 */
	public SaisirEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	/**
	 * renvoie le texte de la commande saisir sauvegardé dans le memento
	 * @return savedTxt texte de la commande saisir sauvegardé dans le memento
	 */
	public String getSavedTxt() {
		return savedTxt;
	}

	/**
	 * sauvegarde le texte de la commande saisir dans le memento
	 * @param savedTxt texte de la commande saisir à sauvegarder dans le memento
	 */
	public void setSavedTxt(String savedTxt) {
		this.savedTxt = savedTxt;
	}
}