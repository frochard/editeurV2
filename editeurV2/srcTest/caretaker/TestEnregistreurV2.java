package caretaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import memento.*;

public class TestEnregistreurV2 {

	//Instanciation de l'objet � tester
	EnregistreurV2Impl enregistreur;
	@Before
	public void setUp() throws Exception {
		//Instanciation de l'objet utilis� pour les tests
		enregistreur = new EnregistreurV2Impl();
	}


	/**
	 * Test de la r�initialisation des enregistrements
	 * */
	@Test
	public void testDemarrer2() {
		//Ajout de mementos � l'enregistreur
		MementoColler m1=null;
		MementoCopier m2=null;
		MementoCouper m3=null;
		MementoSaisir m4=null;
		enregistreur.addMemento(m1);
		enregistreur.addMemento(m2);
		enregistreur.addMemento(m3);
		enregistreur.addMemento(m4);
		//Test de la m�thode
		enregistreur.demarrer();
		//m�thodes de test
		assertEquals(enregistreur.getListeCommandes().size(),0);
	}

	
	/**
	 * Test de l'ajout de memento dans l'enregistreur
	 */
	@Test
	public void testAddMemento() {
		//Ajout de mementos � l'enregistreur
		MementoColler m1=null;
		MementoCopier m2=null;
		MementoCouper m3=null;
		MementoSaisir m4=null;
		enregistreur.addMemento(m1);
		enregistreur.addMemento(m2);
		enregistreur.addMemento(m3);
		enregistreur.addMemento(m4);
		//m�thodes de test
		assertEquals(enregistreur.getListeCommandes().size(),4);
	}

}
