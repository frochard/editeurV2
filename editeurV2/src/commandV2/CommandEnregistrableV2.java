package commandV2;

import memento.Memento;

/**
 *Interface Commande dans le Design Pattern Command. Cette interface est commune aux commandes concrètes de la V2. 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public interface CommandEnregistrableV2{

	/**
	 * Sauve la commande dans un memento
	 * @return m memento contenant la commande
	 */
	public Memento sauverDansMemento();

	/**
	 * restaure une commande stockée dans un memento
	 * @param m memento contenant la commande à restaurer
	 */
	void restaurerDepuisMemento(Memento m);
}
