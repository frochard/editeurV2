package caretaker;

import java.util.ArrayList;
import commandV2.CommandEnregistrableV2;
import memento.*;

/**
 *Enregistreur de la version 2
 *L’enregistreur a le rôle de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class EnregistreurV2Impl implements EnregistreurV2 {

	private ArrayList<Memento> listeCommandes = new ArrayList<Memento>();

	/**
	 * Renvoie la liste des mementos du Caretaker
	 * @return listeCommandes liste des mementos du Caretaker
	 */
	public ArrayList<Memento> getListeCommandes() {
		return listeCommandes;
	}

	/**
	 * méthode démarrant l'enregistrement d'une suite de commandes 
	 */
	public void demarrer(){
		//Suppression de tous les mementos précédent enregistrés
		this.listeCommandes.clear();
	}

	/**
	 * méthode arrêtant l'enregistrement d'une suite de commandes
	 */
	public void arreter(){

	}

	/**
	 * méthode rejouant la suite de commandes enregistrée
	 */
	public void rejouer(){
		//Variable contnant la classe du memento stocké
		String mementoClasse;
		//Récupération de la commande dans la liste de memento
		for (Memento savedCmd : listeCommandes){
			//Récupération du type de commande
			mementoClasse=savedCmd.getClass().getName();
			switch (mementoClasse){
			case "memento.MementoCopier":
				/*Appel de la commande Copier*/
				MementoCopier mementoCopier=(MementoCopier) savedCmd;
				mementoCopier.getSavedCommand().restaurerDepuisMemento(mementoCopier);
				break;        
			case "memento.MementoCouper":
				/*Appel de la commande Couper*/
				MementoCouper mementoCouper=(MementoCouper) savedCmd;
				mementoCouper.getSavedCommand().restaurerDepuisMemento(mementoCouper);
				break;        
			case "memento.MementoColler":
				/*Appel de la commande Coller*/
				MementoColler mementoColler=(MementoColler) savedCmd;
				mementoColler.getSavedCommand().restaurerDepuisMemento(mementoColler);
				break;        
			case "memento.MementoSaisir":
				/*Appel de la commande Saisir*/
				MementoSaisir mementoSaisir=(MementoSaisir) savedCmd;
				mementoSaisir.getSavedCommand().restaurerDepuisMemento(mementoSaisir);
				break;        
			case "memento.MementoSelectionner":
				/*Appel de la commande Selectionner*/
				MementoSelectionner mementoSelectionner=(MementoSelectionner) savedCmd;
				mementoSelectionner.getSavedCommand().restaurerDepuisMemento(mementoSelectionner);
				break;        
			default:
				/*Affichage d'un message indiquant une commande inconnue*/
			}
		}
	}

	/**
	 * Ajoute un memento à la liste des mementos du caretaker
	 * @param m memento à ajouter
	 */
	public void addMemento(Memento m) { 
		listeCommandes.add(m);
	}

	/**
	 * Retourne un memento du Caretaker
	 * @param index
	 * @return memento de la liste de mementos du caretaker correspondant à l'index placé en paramètre
	 */
	public Memento getMemento(int index){
		return listeCommandes.get(index);
	}

	/**
	 * enregistre la commande dans un memento
	 * @param cmdASauver commande à sauvegarder dans le memento
	 */
	@Override
	public void enregistrer(CommandEnregistrableV2 cmdASauver) {
		this.addMemento(cmdASauver.sauverDansMemento());
	}
}
