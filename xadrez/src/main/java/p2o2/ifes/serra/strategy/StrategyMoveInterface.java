package p2o2.ifes.serra.strategy;

import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public interface StrategyMoveInterface {
	
	public List<String> movePool(Tabuleiro t, Peca p);
	public void setLimitacao(ELimiteCasas l);
}
