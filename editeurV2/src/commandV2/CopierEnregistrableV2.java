package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Copier;
import memento.*;
import receiver.MoteurEditionImpl;

public class CopierEnregistrableV2 extends Copier implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	public CopierEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	@Override
	public void execute() {
		//Exécute la commande copier
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
   }

	@Override
	/**
	 * Cette méthode sauvegarde la commande enregistrable dans un memento
	 */
	public Memento sauverDansMemento() {
		//TODO : décommenter et appliquer pour toutes commandes de la V2 et la V3
/*		CopierEnregistrableV2 cmdAsauver=this;
		MementoCopier m = new MementoCopier(cmdAsauver);
	*/	MementoCopier m = new MementoCopier(this);
		return m;
	}

	@Override
	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		//MementoCopier mRestored = (MementoCopier) m;*/
		super.execute();//mRestored.getSavedCommand().execute();
		//this.getReceiver().majObserver();
	}

}
