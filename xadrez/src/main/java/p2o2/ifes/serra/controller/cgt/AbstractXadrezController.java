package p2o2.ifes.serra.controller.cgt;

import p2o2.ifes.serra.model.cdp.Game;

public abstract class AbstractXadrezController implements XadrezControllerInterface {
	protected Game gameDaVez;

	public Game getGameDaVez() {
		return gameDaVez;
	}

	public void setGameDaVez(Game gameDaVez) {
		this.gameDaVez = gameDaVez;
	} 
	
	
	
}
