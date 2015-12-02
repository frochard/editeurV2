package memento;

import commandV2.*;

/**
 *Memento concret utilisé dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoColler implements Memento{

	private CollerEnregistrableV2 savedCommand;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 */
	public MementoColler(CollerEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegardée dans le memento
	 */
	public void setSavedCommand(CollerEnregistrableV2 savedCommand){
		this.savedCommand=savedCommand;
	}

	/**
	 * renvoie la commande sauvegardée dans le memento
	 * @return savedCommand commande sauvegardée dans le memento
	 */
	public CollerEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
}