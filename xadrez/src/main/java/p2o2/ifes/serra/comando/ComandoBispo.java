package p2o2.ifes.serra.comando;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalCima;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;

public class ComandoBispo implements ComandoMovimento {
	
	private LinkedList<StrategyMoveInterface> movimentos = new LinkedList<StrategyMoveInterface>();
	
	public ComandoBispo() {
		this.movimentos.add(new StrategyMoveDiagonalCima());
		this.movimentos.add(new StrategyMoveDiagonalBaixo());
	}

	public List<String> listaMovimentosPossiveis(Tabuleiro tabuleiro, Peca peca) {
		List<String> movimentos = new LinkedList<String>();
		for(Object m: movimentos) {
			movimentos.addAll( ((StrategyMoveInterface)m).movePool(tabuleiro, peca) );
		}
		return movimentos;
	}

	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
		for(Object m: movimentos) {
			((StrategyMoveInterface)m).setLimitacao(ELimiteCasas.OITO);
		}
	}
}
