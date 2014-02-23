/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.controller.movimentosEspeciais;

import p2o2.ifes.serra.model.Enum.EPecaMoveu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

/**
 *
 * @author Pedro
 */
public class MoveRoqueMenor {

	public Boolean movimentoRoqueMenor(Game game) {
		int jogadorVez = game.getJogadorDaVez();

		if (jogadorVez == 1) {
			Peca rei = game.getTabuleiro().getPecaPosicao(7, 4);
			if (rei.getPecaMoveu().equals(EPecaMoveu.nao)) {
				Peca torre = game.getTabuleiro().getPecaPosicao(7, 7);
				if (torre.getPecaMoveu().equals(EPecaMoveu.nao)) {
					if (game.getTabuleiro().getPecaPosicao(7, 5) == null && game.getTabuleiro().getPecaPosicao(7, 6) == null) {
						
						Tabuleiro tabuleiro = game.getTabuleiro();
						tabuleiro.movePeca(rei, "76");
						tabuleiro.movePeca(torre, "75");
						game.setTabuleiro(tabuleiro);
						return true;
					}
				}
			}
		} else {
			Peca rei = game.getTabuleiro().getPecaPosicao(0, 4);
			if (rei.getPecaMoveu().equals(EPecaMoveu.nao)) {
				Peca torre = game.getTabuleiro().getPecaPosicao(0, 7);
				if (torre.getPecaMoveu().equals(EPecaMoveu.nao)) {
					if (game.getTabuleiro().getPecaPosicao(0, 5) == null && game.getTabuleiro().getPecaPosicao(0, 6) == null) {
						
						Tabuleiro tabuleiro = game.getTabuleiro();
						tabuleiro.movePeca(rei, "06");
						tabuleiro.movePeca(torre, "05");
						game.setTabuleiro(tabuleiro);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
}