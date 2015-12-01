package caretaker;

import memento.*;
import commandV2.CommandEnregistrableV2;

public interface EnregistreurV2 {

	public void demarrer();
	public void arreter();
	public void rejouer();
	public void enregistrer(CommandEnregistrableV2 cmdASauver);
	public void addMemento(Memento m);
	public Memento getMemento(int index);
		
}