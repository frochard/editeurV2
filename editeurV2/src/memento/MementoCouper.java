package memento;

import commandV2.CouperEnregistrableV2;

public class MementoCouper implements Memento {

	private CouperEnregistrableV2 savedCommand;

	/**
	 * 
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 */
	public MementoCouper(CouperEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	public void setSavedCommand(CouperEnregistrableV2 savedCommand){
		this.savedCommand= savedCommand;
	}
   
	public CouperEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
	
}
