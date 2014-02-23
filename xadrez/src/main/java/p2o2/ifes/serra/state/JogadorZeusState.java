/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Zeus;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class JogadorZeusState implements StateInterface {
	
	private JogadaView jogadaView = new JogadaView();
	private Game jogo;
	private Zeus zeus = new Zeus();

	public JogadorZeusState(Game game) {
		this.jogo = game;
        jogadaDaVez();
	}

	public void jogadaDaVez() {
		boolean jogadaValida;
		this.jogadaView.mensagemZeusJogando();
		jogadaValida = zeus.jogar(this.jogo);
		
		if(jogadaValida){
			this.jogo.setJogadorDaVez(EPlayerColor.white);
			this.jogo.setState(new JogadorBrancoState( this.jogo));
		}
		else{
			this.jogo.setState(new DesistirState(this.jogo));
		}
	}


	
}
