package commandV2;

import memento.Memento;

public interface CommandEnregistrableV2{

	public Memento sauverDansMemento();

	void restaurerDepuisMemento(Memento m);
}
