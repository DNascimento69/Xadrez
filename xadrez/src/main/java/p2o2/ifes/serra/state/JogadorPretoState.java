/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.state;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p2o2.ifes.serra.controller.cci.TabuleiroControllerView;
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EXeque;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.util.VerificadorEntrada;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class JogadorPretoState implements StateInterface {

	private JogadaView jogadaView = new JogadaView();
	private Game jogo;
	EJogadaMenu jogadaMenu;
	private TabuleiroControllerView tcv = new TabuleiroControllerView();

	public JogadorPretoState(Game game) {
		this.jogo = game;
		jogadaDaVez();
	}

	public void jogadaDaVez() {

		System.out.println(" ");
		System.out.println("Jogador preto é o seu turno!");
		System.out.println(" ");
		tcv.imprimirTabuleiro(jogo);
		System.out.println(" ");

		jogadaView.show();
		int opcaoMenu;
		opcaoMenu = verificaOpcaoJogada();

		if (opcaoMenu < 5) {

			if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				EXeque e = this.jogar(this.jogo);
				this.jogo.setJogadorDaVez(EPlayerColor.white);
				if (e.equals(EXeque.XequeMate)) {
					this.finalizarJogo();
					System.out.println("Jogo Salvo!");
					System.out.println("Fim de jogo!");
				}
				this.jogo.setState(new JogadorBrancoState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)) {
				this.jogo.setJogadorDaVez(EPlayerColor.white);
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
		EXeque verificaXeque = jogo.getTabuleiro().verificaXeque(EPlayerColor.black);
		while (!jogadaValida || verificaXeque.equals(EXeque.Xeque)) {
			
			jogada = efetuarJogada();
			System.out.println("Sua Jogada foi: " + jogada);
			if (jogada.equals("O-O") || jogada.equals("O-O-O")) {
				jogadaValida = game.jogada(game, jogada);
			} else {
				jogadaValida = game.jogada(jogada, EPlayerColor.black);
			}
		}
		return verificaXeque;
	}
	
	private String efetuarJogada() {
		System.out.println("Jogador Preto, faça sua jogada!");
		String jogada = LeitorUtil.lervalorString();
		
		while (!VerificadorEntrada.verificaEntradaJogada(jogada)) {
			System.out.println("Jogador Preto, faça sua jogada!");
			jogada = LeitorUtil.lervalorString();
		}
		
		return jogada;
	}

	protected int verificaOpcaoJogada() {
		int opcaoMainMenu = LeitorUtil.lervalorInteiro();
		boolean conseguiu = false;

		while (!conseguiu) {
			switch (opcaoMainMenu) {
				case 1:
					jogadaMenu = EJogadaMenu.Jogar;
					break;
				case 2:
					jogadaMenu = EJogadaMenu.Empate;
					break;
				case 3:
					jogadaMenu = EJogadaMenu.Desistir;
					break;
				case 4:
					jogadaMenu = EJogadaMenu.Salvar;
					break;
				default:
					jogadaView.mensagemOpcaoInvalida();
					opcaoMainMenu = LeitorUtil.lervalorInteiro();
					jogadaView.mensagemFim();
					break;
			}
		}
		return opcaoMainMenu;
	}
}
