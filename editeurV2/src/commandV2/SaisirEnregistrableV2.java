package commandV2;

import caretaker.EnregistreurV2Impl;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération SaisirEnregistrableV2 par le moteur d'édition(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class SaisirEnregistrableV2 extends Saisir implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	/**
	 * Constructeur 
	 * @param receiver Moteur d'édition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public SaisirEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator,EnregistreurV2Impl enregistreur) {
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
		MementoSaisir m = new MementoSaisir(this,invocator.getText());
		return m;
	}

	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 * @param mRestored memento à restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento m) {
		MementoSaisir mRestored = (MementoSaisir) m;
		receiver.saisir(mRestored.getSavedTxt());
	}
}