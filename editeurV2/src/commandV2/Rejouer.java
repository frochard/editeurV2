package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Command;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération Rejouer par l'enregistreurV2 (receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class Rejouer implements Command  {

	private EnregistreurV2Impl receiver;

	/**
	 * Constructeur 
	 * @param receiver Enregistreur de la commande
	 */
	public Rejouer(EnregistreurV2Impl receiver) {
		this.receiver = receiver;
	}

	/**
	 * Exécution de la commande concrete dans le receiver enregistreur
	 */
	@Override
	public void execute() {
		receiver.rejouer();
   }
}
