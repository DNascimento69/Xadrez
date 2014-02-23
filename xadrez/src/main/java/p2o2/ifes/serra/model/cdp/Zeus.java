/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.model.cdp;

import java.util.ArrayList;
import p2o2.ifes.serra.model.Enum.EPlayerColor;

/**
 *
 * @author Vic
 */
public class Zeus {
	
		public boolean jogar(Game game) 
		{
			int countTentativas = 0;
			boolean jogadaValida = false;
			ArrayList<String> listMovimento  = new ArrayList<String>();
			int peca = 0;
			ArrayList<Peca> listPecas = this.getListPecasZeus(game);
			
			
			while(!jogadaValida && countTentativas < 50){
				peca = this.geradorRandomico(listPecas.size());
				listMovimento = (ArrayList<String>) listPecas.get(peca).listaMovimentosPossiveisPeca(game.getTabuleiro());
				
				if(listMovimento.size() > 0){
					jogadaValida = true;
				}
				countTentativas++;
			}
					
			if(jogadaValida){
				 int movimento  = this.geradorRandomico(listMovimento.size());
				 String entrada = listPecas.get(peca).getPosicao() + listMovimento.get(movimento);
				 game.jogada(entrada, EPlayerColor.black);
			}
			return jogadaValida;
		}
	
		private int geradorRandomico(int tam){
			return (int)	(Math.random() * tam); 	
		}
	
		private ArrayList<Peca> getListPecasZeus(Game game) {

			Peca[][] matriz = game.getTabuleiro().getMatrixTabuleiro();
			ArrayList<Peca> listPecas = new ArrayList<Peca>();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if(matriz[i][j] != null){
						if (matriz[i][j].getCor().equals(EPlayerColor.black)) {
							listPecas.add(matriz[i][j]);
						}
					}
				}
			}
			return listPecas;
		}
}
