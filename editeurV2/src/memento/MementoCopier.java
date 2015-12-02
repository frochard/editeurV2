package memento;

import commandV2.CopierEnregistrableV2;

/**
 *Memento concret utilisé dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoCopier implements Memento {

	private CopierEnregistrableV2 savedCommand;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 */
	public MementoCopier(CopierEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegardée dans le memento
	 */
	public void setSavedCommand(CopierEnregistrableV2 savedCommand){
		this.savedCommand= savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegardée dans le memento
	 * @return savedCommand commande sauvegardée dans le memento
	 */
	public CopierEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
}