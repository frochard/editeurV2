package memento;

import commandV2.CopierEnregistrableV2;

public class MementoCopier implements Memento {

	private CopierEnregistrableV2 savedCommand;

	/**
	 * 
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 */
	public MementoCopier(CopierEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	public void setSavedCommand(CopierEnregistrableV2 savedCommand){
		this.savedCommand= savedCommand;
	}
   
	public CopierEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	
}
