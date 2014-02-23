/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.state;

import java.util.ArrayList;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Pedro
 */
public class ZeusState implements StateInterface {

	private JogadaView jogadaView = new JogadaView();
	private Game game;
	
	public ZeusState(Game game) {
		this.game = game;

	}

	public void jogadaDaVez() {

		this.jogadaView.mensagemZeusJogando();
		this.jogar(game);
	}

	protected void jogar(Game game) {
		game.getTabuleiro().verificaXeque(EPlayerColor.zeus);
		ArrayList<Peca> listPecas = this.getListPecasZeus(game);
		int peca = this.geradorRandomico(listPecas.size());
		ArrayList<String> listMovimento = (ArrayList<String>) listPecas.get(peca).listaMovimentosPossiveisPeca(game.getTabuleiro());
		int movimento = this.geradorRandomico(listMovimento.size());
		String entrada = listPecas.get(peca).getPosicao() + listMovimento.get(movimento);


	}

	private int geradorRandomico(int tam) {

		return (int) (Math.random() * tam);
	}

	private ArrayList<Peca> getListPecasZeus(Game game) {

		Peca[][] matriz = game.getTabuleiro().getMatrixTabuleiro();
		ArrayList<Peca> listPecas = new ArrayList<Peca>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (matriz[i][j].getCor().equals(EPlayerColor.black)) {
					listPecas.add(matriz[i][j]);
				}

			}
		}
		return listPecas;

	}

	
}
