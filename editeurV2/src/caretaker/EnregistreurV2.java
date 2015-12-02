package caretaker;

import memento.*;
import commandV2.CommandEnregistrableV2;

/**
 *Enregistreur de la version 2
 *L’enregistreur a le rôle de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public interface EnregistreurV2 {

	/**
	 * Démarre un enregistrement
	 */
	public void demarrer();
	
	/**
	 * Arrête un enregistrement
	 */
	public void arreter();
	
	/**
	 * Rejoue un enregistrement
	 */
	public void rejouer();
	
	/**
	 * enregistre la commande dans un memento
	 * @param cmdASauver commande à sauvegarder dans le memento
	 */
	public void enregistrer(CommandEnregistrableV2 cmdASauver);
	
	/**
	 * Ajoute un memento à la liste des memento
	 * @param m memento à ajouter à l'enregistreur
	 */
	public void addMemento(Memento m);
	
	/**
	 * Retourne un memento du Caretaker
	 * @param index index das la liste de memento du caretaker
	 * @return memento de la liste de mementos du caretaker correspondant à l'index placé en paramètre
	 */
	public Memento getMemento(int index);
		
}