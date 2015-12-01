package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Command;

public class Rejouer implements Command  {

	private EnregistreurV2Impl receiver;

	public Rejouer(EnregistreurV2Impl receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.rejouer();
   }
}
