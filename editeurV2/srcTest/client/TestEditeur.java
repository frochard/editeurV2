package client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caretaker.*;
import command.*;
import commandV2.*;
import invoker.*;
import receiver.*;

/**
 *Classe de test JUnit de l'éditeur V2 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V2 - 30/11/2015
 */
public class TestEditeur {

	private Editeur testEditeur;
	
	@Before
	public void setUp() throws Exception {
		//Instanciation de l'objet utilisé pour les tests
		testEditeur = new Editeur();
	}

	/**
	 * Test de l'enregistreur pour la commande saisir
	 */
	@Test
	public void testEnregistrement1() {
		//Initialisation du buffer
		String str = "Le M1MIAGE est super.";
		StringBuffer strbuf = new StringBuffer(str);
		testEditeur.getMoteurEdition().getBuffer().setContenu(strbuf);
		testEditeur.getIhm().getZoneTxt().setText(str);
		Command cmdToExecute;
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(15);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(20);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEdition(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Démarrage de l'enregistrement
		cmdToExecute = new Demarrer(testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//Appel de la commande couper enregistrable
		cmdToExecute = new CouperEnregistrableV2(testEditeur.getMoteurEdition(),testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute = new SelectionnerEnregistrableV2(testEditeur.getMoteurEdition(),testEditeur.getIhm(),testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		cmdToExecute = new CollerEnregistrableV2(testEditeur.getMoteurEdition(),testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//Arrêt de l'enregistrement
		cmdToExecute = new Arreter(testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(8);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(15);
		cmdToExecute = new Selectionner(testEditeur.getMoteurEdition(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Rejouer l'enregistrement
		cmdToExecute = new Rejouer(testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//méthodes de test
		assertEquals("M1MIAGEsuperLe  est .", testEditeur.getMoteurEdition().getBuffer().getContenu().toString());
	}

	/**
	 * Test de l'enregistreur pour saisir
	 */
	@Test
	public void testEnregistrement2() {
		//Initialisation du buffer
		String str = "";
		StringBuffer strbuf = new StringBuffer(str);
		testEditeur.getMoteurEdition().getBuffer().setContenu(strbuf);
		Command cmdToExecute;
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEdition(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Démarrage de l'enregistrement
		testEditeur.getEnregistreurV2().demarrer();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setText("Ceci est un test.");
		testEditeur.getIhm().setText("Ceci est un test.");
		cmdToExecute = new SaisirEnregistrableV2(testEditeur.getMoteurEdition(),testEditeur.getIhm(),testEditeur.getEnregistreurV2());
		cmdToExecute.execute();
		//Arrêt de l'enregistrement
		testEditeur.getEnregistreurV2().arreter();
		cmdToExecute = new Selectionner(testEditeur.getMoteurEdition(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Rejouer l'enregistrement
		testEditeur.getEnregistreurV2().rejouer();
		//méthodes de test
		assertEquals(testEditeur.getMoteurEdition().getBuffer().getContenu().toString(),"Ceci est un test.Ceci est un test.");
	}
}