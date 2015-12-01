/***********************************************************************
 * Module:  Editeur.java
 * Author:  21000155
 * Purpose: Defines the Class Editeur
 ***********************************************************************/
package client;

import caretaker.*;
import command.*;
import commandV2.*;
import invoker.*;
import receiver.*;

public class Editeur{
	
	private Ihm ihm;
	private MoteurEditionImpl moteurEdition;
	//Enregistreurs
	private EnregistreurV2Impl enregistreurV2;
	//Déclaration des commandes
	private Coller cmdColler;
	private Copier cmdCopier;
	private Couper cmdCouper;
	private Saisir cmdSaisir;
	private Selectionner cmdSelectionner;
	private SuppressionArriere cmdSuppressionArriere;
	private SuppressionAvant cmdSuppressionAvant;
	private CollerEnregistrableV2 cmdCollerEnregistrable;
	private CopierEnregistrableV2 cmdCopierEnregistrable;
	private CouperEnregistrableV2 cmdCouperEnregistrable;
	private SaisirEnregistrableV2 cmdSaisirEnregistrable;
	private SelectionnerEnregistrableV2 cmdSelectionnerEnregistrable;
	private Demarrer cmdDemarrer;
	private Arreter cmdArreter;
	private Rejouer cmdRejouer;

	public Ihm getIhm() {
		return ihm;
	}

	public MoteurEditionImpl getMoteurEdition() {
		return moteurEdition;
	}

	public EnregistreurV2Impl getEnregistreurV2() {
		return enregistreurV2;
	}

	/**
	 * Constructeur d'Editeur
	 */
	public Editeur() {
		//Création de l'enregistreur de commandes de la V2
		this.enregistreurV2=new EnregistreurV2Impl();
		//Création de l'IHM
		this.ihm = new Ihm();
		this.moteurEdition=new MoteurEditionImpl(new Buffer(new StringBuffer("")),new PressePapier(""),new Selection(0,0));
		//Ajout des commandes
		cmdColler=new Coller(moteurEdition);
		cmdCopier=new Copier(moteurEdition);
		cmdCouper=new Couper(moteurEdition);
		cmdSaisir=new Saisir(moteurEdition,ihm);
		cmdSelectionner=new Selectionner(moteurEdition,ihm);
		cmdSuppressionArriere=new SuppressionArriere(moteurEdition);
		cmdSuppressionAvant=new SuppressionAvant(moteurEdition);
		cmdCollerEnregistrable=new CollerEnregistrableV2(moteurEdition,enregistreurV2);
		cmdCopierEnregistrable=new CopierEnregistrableV2(moteurEdition,enregistreurV2);
		cmdCouperEnregistrable=new CouperEnregistrableV2(moteurEdition,enregistreurV2);
		cmdSaisirEnregistrable=new SaisirEnregistrableV2(moteurEdition,ihm,enregistreurV2);
		cmdSelectionnerEnregistrable=new SelectionnerEnregistrableV2(moteurEdition,ihm,enregistreurV2);
		cmdDemarrer = new Demarrer(enregistreurV2);
		cmdArreter = new Arreter(enregistreurV2);
		cmdRejouer = new Rejouer(enregistreurV2);
		//Ajout des commandes à l'ihm
		this.ihm.setCmdColler(cmdColler);
		this.ihm.setCmdCopier(cmdCopier);
		this.ihm.setCmdCouper(cmdCouper);
		this.ihm.setCmdSaisir(cmdSaisir);
		this.ihm.setCmdSelectionner(cmdSelectionner);
		this.ihm.setCmdSuppressionArriere(cmdSuppressionArriere);
		this.ihm.setCmdSuppressionAvant(cmdSuppressionAvant);
		this.ihm.setCmdCollerEnregistrable(cmdCollerEnregistrable);
		this.ihm.setCmdCopierEnregistrable(cmdCopierEnregistrable);
		this.ihm.setCmdCouperEnregistrable(cmdCouperEnregistrable);
		this.ihm.setCmdSaisirEnregistrable(cmdSaisirEnregistrable);
		this.ihm.setCmdSelectionnerEnregistrable(cmdSelectionnerEnregistrable);
		this.ihm.setCmdDemarrer(cmdDemarrer);
		this.ihm.setCmdArreter(cmdArreter);
		this.ihm.setCmdRejouer(cmdRejouer);
		//Ajout d'un observer
		this.moteurEdition.addObserver(this.ihm);
	}
	
	public static void main(String [] arg){
		new Editeur();
	}
}