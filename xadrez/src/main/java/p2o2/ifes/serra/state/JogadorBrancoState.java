/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.state;

import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.controller.cci.TabuleiroControllerView;
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EXeque;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class JogadorBrancoState implements StateInterface {

	private JogadaView jogadaView = new JogadaView();
	private TabuleiroControllerView tcv = new TabuleiroControllerView();
	private Game jogo;
	EJogadaMenu jogadaMenu;

	public JogadorBrancoState(Game game) {
		this.jogo = game;
		jogadaDaVez();
	}

	public void jogadaDaVez() {
		System.out.println(" ");
		System.out.println("Jogador branco é o seu turno!");
		System.out.println(" ");
		tcv.imprimirTabuleiro(jogo);
		System.out.println(" ");
		jogadaView.show();
		int opcaoMenu;

		opcaoMenu = verificaOpcaoJogada();

		if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				EXeque e = this.jogar(this.jogo);
				if (e.equals(EXeque.XequeMate)) {
					this.finalizarJogo();
					System.out.println("Jogo Salvo!");
					System.out.println("Fim de jogo!");
				}
				if (this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)) {
					this.jogo.setJogadorDaVez(EPlayerColor.black);
					this.jogo.setState(new JogadorPretoState(this.jogo));
				} else {
					this.jogo.setJogadorDaVez(EPlayerColor.zeus);
					this.jogo.setState(new JogadorZeusState(this.jogo));
				}
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)) {
				this.jogo.setJogadorDaVez(EPlayerColor.black);
				this.jogo.setState(new EmpateState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Desistir)) {
				this.jogo.setState(new DesistirState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Salvar)) {
				this.salvar();
				System.out.println("Jogo Salvo!");
				System.out.println("Fim de jogo!");
			}


	}

	protected void finalizarJogo() {


		try {
			jogo.setGameStatus(EGameStatus.Terminado);
			jogo.setJogadorVencendorId(1);
			DAOGame daoGame = new DAOGame();
			daoGame.insert(this.jogo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void salvar() {
		try {
			List<Peca> lstPecas = new ArrayList<Peca>();
			DAOGame daoGame = new DAOGame();
			DAOJogador daoJogador = new DAOJogador();
			DAOPeca daoPeca = new DAOPeca();
			Jogador j1 = this.jogo.getJogador1();
			Jogador j2 = this.jogo.getJogador2();

			j1.setPontos(this.jogo.getTabuleiro().ChecaPontosBrancos());
			j2.setPontos(this.jogo.getTabuleiro().ChecaPontosPretos());

			this.jogo.setJogador1(j1);
			this.jogo.setJogador2(j2);

			lstPecas.addAll(this.jogo.getTabuleiro().listarPecasJogo());
			daoJogador.insert(this.jogo.getJogador1());
			daoJogador.insert(this.jogo.getJogador2());
			daoGame.insert(this.jogo);

			for (Peca peca : lstPecas) {
				daoPeca.insert(peca);
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected EXeque jogar(Game game) {
		boolean jogadaValida = false;
		String jogada;
		EXeque verificaXeque = jogo.getTabuleiro().verificaXeque(EPlayerColor.white);
		while (!jogadaValida || verificaXeque.equals(EXeque.Xeque)) {
			System.out.println("Jogador branco, faça sua jogada!");
			jogada = LeitorUtil.lervalorString();
			System.out.println("Sua jogada foi: " + jogada);
			if (jogada.equals("O-O") || jogada.equals("O-O-O")) {
				jogadaValida = game.jogada(game, jogada);
			} else {
				jogadaValida = game.jogada(jogada, EPlayerColor.white);
			}
		}

		return verificaXeque;
	}

	protected int verificaOpcaoJogada() {
		int opcaoMainMenu = LeitorUtil.lervalorInteiro();
		boolean conseguiu = false;

		while (!conseguiu) {
			switch (opcaoMainMenu) {
				case 1:
					jogadaMenu = EJogadaMenu.Jogar;
					conseguiu = true;
					return 1;
				case 2:
					jogadaMenu = EJogadaMenu.Empate;
					conseguiu = true;
					return 2;
				case 3:
					jogadaMenu = EJogadaMenu.Desistir;
					conseguiu = true;
					return 3;
				case 4:
					jogadaMenu = EJogadaMenu.Salvar;
					conseguiu = true;
					return 4;
				default:
					jogadaView.mensagemOpcaoInvalida();
					opcaoMainMenu = LeitorUtil.lervalorInteiro();
					//jogadaView.mensagemFim();
					break;
			}
		}
		return 0;
	}
}
