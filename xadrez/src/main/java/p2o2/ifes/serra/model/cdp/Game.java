package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.controller.cci.TabuleiroControllerView;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.reuse.Model;
import p2o2.ifes.serra.state.StateInterface;

public class Game extends Model {

	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private int gameId;
	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
	private EGameStatus statusGame;
	private EGameModeMenu gameMode;
	private int jogadorVencendorId = 0;
	private EPlayerColor jogadorDaVez;
	private StateInterface myState;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="GetSeters">
	public int getID() {
		return this.gameId;
	}

	public void setID(int ID) {
		this.gameId = ID;
	}

	public void setState(StateInterface newState) {
		myState = newState;
	}

	public int getJogadorDaVez() {
		return jogadorDaVez.getValue();
	}

	public void setJogadorDaVez(EPlayerColor jogadorCor) {
		this.jogadorDaVez = jogadorCor;
	}

	public int getGameStatus() {
		return statusGame.getValue();
	}

	public void setGameStatus(EGameStatus gameStatus) {
		this.statusGame = gameStatus;
	}

	public int getJogadorVencendorId() {
		return jogadorVencendorId;
	}

	public void setJogadorVencendorId(int idVencendor) {
		this.jogadorVencendorId = idVencendor;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public EGameStatus getStatusGame() {
		return statusGame;
	}

	public void setStatusGame(EGameStatus statusGame) {
		this.statusGame = statusGame;
	}

	public EGameModeMenu getGameMode() {
		return gameMode;
	}

	public void setGameMode(EGameModeMenu gameMode) {
		this.gameMode = gameMode;
	}

	@Override
	public String toString() {
		return "Game [jogador1=" + jogador1 + ", jogador2=" + jogador2
				+ ", tabuleiro=" + tabuleiro
				+ "]";
	}
// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Processamento">
	public boolean jogada(String posicao, EPlayerColor cor) {
		return this.tabuleiro.jogada(posicao, cor);
	}

	public boolean jogada(Game game, String posicao) {
		return this.tabuleiro.jogada(game, posicao);
	}

	public void imprimeTabuleiro() {
		TabuleiroControllerView tcv = new TabuleiroControllerView();
		tcv.imprimirTabuleiro(this);
	}
	// </editor-fold>
}
