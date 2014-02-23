package p2o2.ifes.serra.comando;

import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;
import p2o2.ifes.serra.strategy.StrategyMoveL;

public class ComandoCavalo implements ComandoMovimento {

	private StrategyMoveInterface estrategiaMovimento = null;
	
	public ComandoCavalo() {
		this.estrategiaMovimento = new StrategyMoveL();
	}
	
	public List<String> listaMovimentosPossiveis(Tabuleiro t, Peca p) {
		this.estrategiaMovimento.movePool(t, p);
		return null;
	}

	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {}
}
