package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Command;

public class Arreter implements Command {

	private EnregistreurV2Impl receiver;

	public Arreter(EnregistreurV2Impl receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.arreter();
   }
}
