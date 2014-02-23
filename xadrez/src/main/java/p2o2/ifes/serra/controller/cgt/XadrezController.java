package p2o2.ifes.serra.controller.cgt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.builder.GameMaker;
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.state.JogadorBrancoState;
import p2o2.ifes.serra.state.JogadorPretoState;
import p2o2.ifes.serra.state.JogadorZeusState;

public class XadrezController extends AbstractXadrezController{
	
	private EGameModeMenu opcaoModoDeJogo;
	
	public void setOpcaoModoDeJogo(EGameModeMenu opcaoModoDeJogo) {
		this.opcaoModoDeJogo = opcaoModoDeJogo;
	}
	
	public void start(List<String> jogadoreLst){
		GameMaker gameMaker = new GameMaker(opcaoModoDeJogo ,jogadoreLst);
		gameMaker.constructGame();
		this.gameDaVez = gameMaker.getGame();
                this.gameDaVez.setState(new JogadorBrancoState(gameDaVez));
	}
	
	public void load(String gameId) throws SQLException, ClassNotFoundException{
		
		GameMaker gameMaker;
		Game game = getJogoById(Integer.parseInt(gameId));
		List<String> listJogadores = new ArrayList<String>();
		
		if(game.getJogador2() == null){
			listJogadores.add(game.getJogador1().getNome());
			gameMaker = new GameMaker(EGameModeMenu.OnePlayerGame ,listJogadores);
		}
		else{
			listJogadores.add(game.getJogador1().getNome());
			listJogadores.add(game.getJogador2().getNome());
			gameMaker = new GameMaker(EGameModeMenu.TwoPlayerGame ,listJogadores);
		}

		gameMaker.rebuildGame(this.getPecasByJogo(Integer.parseInt(gameId)));
		this.gameDaVez = gameMaker.getGame();
		if(game.getJogadorDaVez() == 1){
			this.gameDaVez.setState(new JogadorBrancoState(gameDaVez));
		}
		if(game.getJogadorDaVez() == 1){
			this.gameDaVez.setState(new JogadorPretoState(gameDaVez));
		}
		else{
			this.gameDaVez.setState(new JogadorZeusState(gameDaVez));
		}
	}
	
	public List<Game> getJogosSalvo() throws SQLException, ClassNotFoundException{
		DAOGame daoGame = new DAOGame();
		List<Game> listGamesSalvos = daoGame.findAll();
	
		return listGamesSalvos;
	}
	
	public List<Peca> getPecasByJogo(int jogoId) throws SQLException, ClassNotFoundException{
		DAOPeca daoPeca = new DAOPeca();
		List<Peca> listPecaSalvos = daoPeca.findAll();
		List<Peca> listPecasDoJogo = new ArrayList<Peca>();
		
		for(Peca peca: listPecaSalvos){
			if(peca.getIdGame() == jogoId)
			{
				listPecasDoJogo.add(peca);
			}
		}
		return listPecasDoJogo;
	}
	
	
	public Game getJogoById(int Id) throws SQLException, ClassNotFoundException{
		DAOGame daoGame = new DAOGame();
		return daoGame.findbyID(Id);
	}
	
	public Game getJogoById(List<Game> jogos, int Id){
		Game game = new Game();
		
		for(Game jogo: jogos){
			if(jogo.getID() == Id){
				game = jogo;
			}
		}
		
		return game;
	}
	
}
