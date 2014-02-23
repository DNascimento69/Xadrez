/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.view.cih;

import java.util.List;

/**
 *
 * @author Vic
 */
public class LoadView {
	
		// Mostrando o menu
		public void show(List<String> lstJogosId) {
			mostrarMenu(lstJogosId);
		}

		// Mostrando o menu
		private void mostrarMenu(List<String> lstJogosId) {
			System.out.println("Escolha o Jogo a carregar:");

			for(int x=0; x < lstJogosId.size(); x++){
				System.out.println(Integer.toString(x+1)+" - "+lstJogosId.get(x));
			}
		}
		
		//Mensagem de opão Invalida
		public void mensagemOpcaoInvalida (){
			System.out.println("Opcão invalida");
		}
		
		//Mensavem de fim de execução
		public void mensagemFim (){
			System.out.println("Fim do programa!");
		}
	
}
