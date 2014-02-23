/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.view.cih;

import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;

/**
 *
 * @author Nascimento
 */
public class TabuleiroView {
	public void imprimeTabuleiro(Game gameDaVez) {
		Peca[][] matriz = gameDaVez.getTabuleiro().getMatrixTabuleiro();
		Peca peca;
		System.out.println("Legenda:");
		System.out.println("E - Pião, K - Rei, Q - Rainha, C - Cavalo, I - Bispo, T - Torre");
		System.out.println("P - Preto, B - Branco");
		System.out.println(" ");

		for (int row = 0; row < matriz.length; row++) {
			for (int column = 0; column < matriz.length; column++) {
				if (matriz[row][column] != null) {
					peca = matriz[row][column];
					System.out.print(peca.toString() + " ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
}
