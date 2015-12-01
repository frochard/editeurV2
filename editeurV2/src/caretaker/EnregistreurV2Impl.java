package caretaker;

import java.util.ArrayList;
import commandV2.CommandEnregistrableV2;
import memento.*;

public class EnregistreurV2Impl implements EnregistreurV2 {

	private ArrayList<Memento> listeCommandes = new ArrayList<Memento>();

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
			System.out.println("Commande no "+savedCmd.hashCode()+" sur "+listeCommandes.size()+"à rejouer : "+mementoClasse);
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
				System.out.println("couper rejoué :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoCouper.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoCouper.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoCouper.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoCouper.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				//mementoCopier.getSavedCommand().restaurerDepuisMemento(savedCmd);
				break;        
			case "memento.MementoColler":
				/*Appel de la commande Coller*/
				MementoColler mementoColler=(MementoColler) savedCmd;
				mementoColler.getSavedCommand().restaurerDepuisMemento(mementoColler);
				System.out.println("Coller rejoué :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoColler.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoColler.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoColler.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoColler.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				break;        
			case "memento.MementoSaisir":
				/*Appel de la commande Saisir*/
				MementoSaisir mementoSaisir=(MementoSaisir) savedCmd;
				mementoSaisir.getSavedCommand().restaurerDepuisMemento(mementoSaisir);
				System.out.println("Saisir rejoué :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoSaisir.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoSaisir.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoSaisir.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoSaisir.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				break;        
			case "memento.MementoSelectionner":
				/*Appel de la commande Selectionner*/
				MementoSelectionner mementoSelectionner=(MementoSelectionner) savedCmd;
				mementoSelectionner.getSavedCommand().restaurerDepuisMemento(mementoSelectionner);
				break;        
			default:
				/*Affichage d'un message indiquant une commande inconnue*/;

			}
		}
	}

	public void addMemento(Memento m) { 
		listeCommandes.add(m);
	}

	public Memento getMemento(int index){
		return listeCommandes.get(index);
	}

	@Override
	public void enregistrer(CommandEnregistrableV2 cmdASauver) {
		this.addMemento(cmdASauver.sauverDansMemento());
	}
}
