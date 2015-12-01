package commandV2;

import caretaker.EnregistreurV2Impl;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

public class SaisirEnregistrableV2 extends Saisir implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	public SaisirEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator,EnregistreurV2Impl enregistreur) {
		super(receiver, invocator);
		this.enregistreur=enregistreur;
	}

	@Override
	public void execute() {
		//Exécute la commande saisir
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
	}

	@Override
	/**
	 * Cette méthode sauvegarde la commande enregistrable dans un memento
	 */
	public Memento sauverDansMemento() {
		MementoSaisir m = new MementoSaisir(this,invocator.getText());
		return m;
	}

	@Override
	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoSaisir mRestored = (MementoSaisir) m;
		receiver.saisir(mRestored.getSavedTxt());
	}

}
