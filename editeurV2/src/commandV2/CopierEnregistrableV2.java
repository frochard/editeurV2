package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Copier;
import memento.*;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération CopierEnregistrableV2 par le moteur d'édition(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class CopierEnregistrableV2 extends Copier implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	/**
	 * Constructeur 
	 * @param receiver Moteur d'édition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public CopierEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	/**
	 * Exécution de la commande concrete dans les receiver (moteur d'édition et enregistreur)
	 */
	@Override
	public void execute() {
		//Exécute la commande copier
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
		//TODO : décommenter et appliquer pour toutes commandes de la V2 et la V3
/*		CopierEnregistrableV2 cmdAsauver=this;
		MementoCopier m = new MementoCopier(cmdAsauver);
	*/	MementoCopier m = new MementoCopier(this);
		return m;
	}

	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 * @param m memento à restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento m) {
		MementoCopier mRestored = (MementoCopier) m;
		super.execute();
	}
}