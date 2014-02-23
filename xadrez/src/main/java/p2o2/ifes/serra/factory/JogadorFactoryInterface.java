package p2o2.ifes.serra.factory;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Jogador;

public interface JogadorFactoryInterface {

	public Jogador getJogador(String nick, EPlayerColor cor);

}
