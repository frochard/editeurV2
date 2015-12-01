package commandV2;

import caretaker.*;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

public class SelectionnerEnregistrableV2 extends Selectionner implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	public SelectionnerEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator, EnregistreurV2Impl enregistreur) {
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
		MementoSelectionner m = new MementoSelectionner(this,invocator.getSelectionDebut(),invocator.getSelectionLongueur());
		return m;
	}

	@Override
	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoSelectionner mRestored = (MementoSelectionner) m;
		int debut=mRestored.getSavedDebut();
		int longueur=mRestored.getSavedDebut();
		receiver.selectionner(debut, longueur);
		this.getReceiver().majObserver();
	}

}
