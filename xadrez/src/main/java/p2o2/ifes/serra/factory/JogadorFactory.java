package p2o2.ifes.serra.factory;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Jogador;

public class JogadorFactory implements JogadorFactoryInterface {

	public Jogador getJogador(String nome, EPlayerColor cor) {
		Jogador jogador = new Jogador();

		jogador.setNome(nome);
		jogador.setPontos(0);
		
		
		return jogador;
	}

}
