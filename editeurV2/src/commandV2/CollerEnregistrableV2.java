package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Coller;
import memento.*;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération CollerEnregistrableV2 par le moteur d'édition(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class CollerEnregistrableV2 extends Coller implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	/**
	 * Constructeur 
	 * @param receiver Moteur d'édition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public CollerEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	/**
	 * Exécution de la commande concrete dans les receiver (moteur d'édition et enregistreur)
	 */
	@Override
	public void execute() {
		//Exécute la commande coller
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		enregistreur.enregistrer(this);
   }

	/**
	* Cette méthode sauvegarde la commande enregistrable dans un memento et retourne le memento
	* @return m memento contenant la commande sauvegardée
	*/
	@Override
	public Memento sauverDansMemento() {
		MementoColler m = new MementoColler(this);
		return m;
	}

	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 * @param mRestored memento à restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento m) {
		MementoColler mRestored = (MementoColler) m;
		super.execute();
	}

}