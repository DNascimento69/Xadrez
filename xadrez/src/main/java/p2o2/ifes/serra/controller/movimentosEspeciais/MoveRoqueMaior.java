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
public class MoveRoqueMaior {
	
	public Boolean movimentoRoqueMaior(Game game){
		
			int jogadorVez = game.getJogadorDaVez();

		if (jogadorVez == 1) {
			Peca rei = game.getTabuleiro().getPecaPosicao(7, 4);
			if (rei.getPecaMoveu().equals(EPecaMoveu.nao)) {
				Peca torre = game.getTabuleiro().getPecaPosicao(7, 0);
				if (torre.getPecaMoveu().equals(EPecaMoveu.nao)) {
					if (game.getTabuleiro().getPecaPosicao(7, 1) == null && game.getTabuleiro().getPecaPosicao(7, 2) == null && game.getTabuleiro().getPecaPosicao(7, 3) == null) {
						
						Tabuleiro tabuleiro = game.getTabuleiro();
						tabuleiro.movePeca(rei, "72");
						tabuleiro.movePeca(torre, "73");
						game.setTabuleiro(tabuleiro);
						return true;
					}
				}
			}
		} else {
			Peca rei = game.getTabuleiro().getPecaPosicao(0, 4);
			if (rei.getPecaMoveu().equals(EPecaMoveu.nao)) {
				Peca torre = game.getTabuleiro().getPecaPosicao(0, 0);
				if (torre.getPecaMoveu().equals(EPecaMoveu.nao)) {
					if (game.getTabuleiro().getPecaPosicao(0, 1) == null && game.getTabuleiro().getPecaPosicao(0, 2) == null && game.getTabuleiro().getPecaPosicao(0, 3) == null) {
						
						Tabuleiro tabuleiro = game.getTabuleiro();
						tabuleiro.movePeca(rei, "02");
						tabuleiro.movePeca(torre, "03");
						game.setTabuleiro(tabuleiro);
						return true;
					}
				}
			}
		}
		return false;
		
		
	}
	
	
}
