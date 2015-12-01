package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Command;
import receiver.MoteurEditionImpl;

public class Demarrer implements Command   {

	private EnregistreurV2Impl receiver;

	public Demarrer(EnregistreurV2Impl receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.demarrer();
   }
	
}
