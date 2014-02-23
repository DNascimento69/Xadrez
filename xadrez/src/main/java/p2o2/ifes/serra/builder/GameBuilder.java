package p2o2.ifes.serra.builder;

import java.util.List;
import p2o2.ifes.serra.factory.JogadorFactory;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;
import p2o2.ifes.serra.model.cdp.Peca;

public class GameBuilder implements GameBuilderInterface {

	private Game game;
	private String jogador1;
	private String jogador2;
	private EGameModeMenu gameMode;

	public GameBuilder(EGameModeMenu gameMode,List<String> lstNomePlayers) {
		this.game = new Game();
		this.gameMode = gameMode;
		
		game.setGameMode(gameMode);
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			this.jogador1 = lstNomePlayers.get(0);
			this.jogador2 = lstNomePlayers.get(1);
		}
		else{
			this.jogador1 = lstNomePlayers.get(0);
		}
	}

	public void setPlayers() {
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,
					EPlayerColor.white);
			Jogador player2 = jogadorFactory.getJogador(jogador2,
					EPlayerColor.black);

				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
		}
		else{
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,EPlayerColor.white);
			Jogador player2 = null;
			
				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
		}
	}

	public void setTabuleiro() {
		TabuleiroMaker tabuleiroMaiker = new TabuleiroMaker(game.getID());
		tabuleiroMaiker.constructTabuleiro();
		game.setTabuleiro(tabuleiroMaiker.getTabuleiro());
	}
	
	public void remakeTabuleiro(List<Peca> listPeca){
		TabuleiroMaker tabuleiroMaiker = new TabuleiroMaker(game.getID());
		tabuleiroMaiker.remakeTabuleiro(listPeca);
		game.setTabuleiro(tabuleiroMaiker.getTabuleiro());
		
	}
	
	public Game getGame(){
		return game;
	}

}
