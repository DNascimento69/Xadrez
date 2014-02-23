package p2o2.ifes.serra.builder;

import java.util.List;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;

public class GameMaker {
	
	private GameBuilder gameBuilder;
	
	
	public GameMaker(EGameModeMenu gameMode,List<String> lstNomePlayers){
	    this.gameBuilder = new GameBuilder(gameMode,lstNomePlayers);
	  }
	 
	  public Game getGame() {
	    return this.gameBuilder.getGame();
	  }
	 
	  public void constructGame() {
		 
	    this.gameBuilder.setPlayers();
	    this.gameBuilder.setTabuleiro();
	  }
	  
	  public void rebuildGame(List<Peca> listPeca){
		   this.gameBuilder.remakeTabuleiro(listPeca);
	  }

}
