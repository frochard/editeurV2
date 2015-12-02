package commandV2;

import caretaker.*;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération SelectionnerEnregistrableV2 par le moteur d'édition(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class SelectionnerEnregistrableV2 extends Selectionner implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	/**
	 * Constructeur 
	 * @param receiver Moteur d'édition de la commande
	 * @param invocator IHM de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public SelectionnerEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator, EnregistreurV2Impl enregistreur) {
		super(receiver, invocator);
		this.enregistreur=enregistreur;
	}

	/**
	 * Exécution de la commande concrete dans les receiver (moteur d'édition et enregistreur)
	 */
	@Override
	public void execute() {
		//Exécute la commande saisir
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
	}

	/**
	* Cette méthode sauvegarde la commande enregistrable dans un memento et retourne le memento
	* @return m memento contenant la commande sauvegardée
	*/
	@Override
	public Memento sauverDansMemento() {
		MementoSelectionner m = new MementoSelectionner(this,invocator.getSelectionDebut(),invocator.getSelectionLongueur());
		return m;
	}

	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 * @param m memento à restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento m) {
		MementoSelectionner mRestored = (MementoSelectionner) m;
		int debut=mRestored.getSavedDebut();
		int longueur=mRestored.getSavedDebut();
		receiver.selectionner(debut, longueur);
		this.getReceiver().majObserver();
	}
}