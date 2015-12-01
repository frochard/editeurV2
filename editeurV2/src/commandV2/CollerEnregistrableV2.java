package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Coller;
import memento.*;
import receiver.MoteurEditionImpl;

public class CollerEnregistrableV2 extends Coller implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	public CollerEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	@Override
	public void execute() {
		//Exécute la commande coller
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		enregistreur.enregistrer(this);
   }

	@Override
	/**
	 * Cette méthode sauvegarde la commande enregistrable dans un memento
	 */
	public Memento sauverDansMemento() {
		MementoColler m = new MementoColler(this);
		return m;
	}

	@Override
	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoColler mRestored = (MementoColler) m;
		super.execute();
		//this.getReceiver().majObserver();
	}

}