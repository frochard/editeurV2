package commandV2;

import caretaker.EnregistreurV2Impl;
import command.SuppressionArriere;
import memento.Memento;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération SuppressionArriereEnregistrableV2 par le moteur d'édition(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class SuppressionArriereEnregistrableV2 extends SuppressionArriere implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	/**
	 * Constructeur 
	 * @param receiver Moteur d'édition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public SuppressionArriereEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	/**
	 * Exécution de la commande concrete dans les receiver (moteur d'édition et enregistreur)
	 */
	@Override
	public void execute() {
		//Exécute la commande couper
		super.execute();
		//Ajoute la commande dans la liste ordonnée de memento du caretaker Enregistreur
		
   }

	/**
	* Cette méthode sauvegarde la commande enregistrable dans un memento et retourne le memento
	* @return m memento contenant la commande sauvegardée
	*/
	@Override
	public Memento sauverDansMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cette méthode restaure la commande enregistrable depuis un memento
	 * @param memento memento à restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento memento) {
		// TODO Auto-generated method stub
		
	}

}
