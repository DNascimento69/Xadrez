package p2o2.ifes.serra.comando;

import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public interface ComandoMovimento {

	public List<String> listaMovimentosPossiveis(Tabuleiro tabuleiro, Peca peca);
	public void modificaLimitaçãoEstrategia(ELimiteCasas l);
}
