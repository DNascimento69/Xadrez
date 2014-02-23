package p2o2.ifes.serra.application;

import p2o2.ifes.serra.controller.cci.MainController;

public class Application {
	
	/**
	 * Inicia o jogo
	 */
	public static void start() {
		MainController mainController = new MainController();
		mainController.start();		
	}
}
