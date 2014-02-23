package p2o2.ifes.serra.controller.cci;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.controller.cgt.XadrezController;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EMainMenu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.GameView;
import p2o2.ifes.serra.view.cih.LoadView;

public class OperationController {

	private EMainMenu opcaoMenuInicial;
	private GameView gameView = new GameView();
	private EGameModeMenu opcaoModoDeJogo;
	private XadrezController xadrezController = new XadrezController();

	public void setOpcaoJogo(EMainMenu opcaoDoMenuInicial) {
		this.opcaoMenuInicial = opcaoDoMenuInicial;
	}

	public void start() {
		try {
			if (opcaoMenuInicial.equals(EMainMenu.NovoJogo)) {
				iniciarNovoJogo();
			}
			if (opcaoMenuInicial.equals(EMainMenu.CarregarJogo)) {
				carregarJogoSalvo();
			}
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public void iniciarNovoJogo() {
		gameView.show();

		int opcaoMenuModoDeJogo = LeitorUtil.lervalorInteiro();

		verificandoOpcaoEscolhidaNoMenuDeModoDeJogo(opcaoMenuModoDeJogo);

		if (opcaoModoDeJogo != null) {

			xadrezController.setOpcaoModoDeJogo(opcaoModoDeJogo);

			if (opcaoModoDeJogo.equals(EGameModeMenu.OnePlayerGame)) {
				xadrezController.start(getNomeJogadores(1));
			} else {
				xadrezController.start(getNomeJogadores(2));
			}
		}
	}

	public void carregarJogoSalvo() throws SQLException, ClassNotFoundException {
		List<Game> listGamesSalvos = xadrezController.getJogosSalvo();

		jogosSalvosMenu(listGamesSalvos);
	}

	public void jogosSalvosMenu(List<Game> listGamesSalvos) throws SQLException, ClassNotFoundException {
		List<String> listJogosIdSalvos = new ArrayList<String>();
		LoadView loadView = new LoadView();

		for (Game game : listGamesSalvos) {
			listJogosIdSalvos.add(Integer.toString(game.getID()));
		}
		loadView.show(listJogosIdSalvos);

		int opcaoMenuModoDeJogo = LeitorUtil.lervalorInteiro();

		if (opcaoMenuModoDeJogo - 1 > listJogosIdSalvos.size()) {
			loadView.mensagemOpcaoInvalida();
			loadView.mensagemFim();
		}

		xadrezController.load(listJogosIdSalvos.get(opcaoMenuModoDeJogo - 1));
	}

	public List<String> getNomeJogadores(int players) {
		List<String> nomeDosJogadoresList = new ArrayList<String>();
		String nome1;

		for (int x = 0; x < players; x++) {
			System.out.println("Insira o Nome do " + Integer.toHexString(x + 1) + "° jogador");
			nome1 = LeitorUtil.lervalorString();
			nomeDosJogadoresList.add(nome1);
		}
		return nomeDosJogadoresList;
	}

	/**
	 * Valida a escolha do Menu de modo de jogo
	 */
	private void verificandoOpcaoEscolhidaNoMenuDeModoDeJogo(int opcao) {
		switch (opcao) {
			case 1:
				opcaoModoDeJogo = EGameModeMenu.OnePlayerGame;
				break;
			case 2:
				opcaoModoDeJogo = EGameModeMenu.TwoPlayerGame;
				break;
			default:
				gameView.mensagemOpcaoInvalida();
				gameView.mensagemFim();
				break;
		}

	}
}
