/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;


/**
 *
 * @author Vic
 */
public class DesistirState implements StateInterface{
	 private Game jogo;
    
     public DesistirState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
          Jogador jogadorDesistente;
          Jogador ganhador;
		  this.jogo.setGameStatus(EGameStatus.Terminado);
		  
		  if(this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)){
				if(this.jogo.getJogadorDaVez() == 1){
					jogadorDesistente = this.jogo.getJogador1();
					ganhador = this.jogo.getJogador2();
				}
				else{
					jogadorDesistente = this.jogo.getJogador2();
					ganhador = this.jogo.getJogador1();
				}
						 
				this.jogo.setJogadorVencendorId( ganhador.getId());
				//SALVAR GAME
				System.out.println(" ");
				System.out.println("O Jogador: " + jogadorDesistente.toString()+ " Desistiu, logo, o Jogador : " + ganhador.toString() + " é o vencedor!");
				System.out.println("Parabéns!");
				System.out.println("Jogo Finalizado!");
				
		  }
		  else{
			  if(this.jogo.getJogadorDaVez() == 1){
					this.jogo.setJogadorVencendorId( -1);
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Jogador: " + jogo.getJogador1().toString()+ " Desistiu, logo, Zeus é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
				else{
					this.jogo.setJogadorVencendorId( jogo.getJogador1().getId());
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Zeus: Desistiu, logo, "+jogo.getJogador1().toString()+" é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
		  }
     }
    
}
