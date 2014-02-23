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
		this.modificaLimitaçãoEstrategia(ELimiteCasas.OITO);
	}

	public List<String> listaMovimentosPossiveis(Tabuleiro tabuleiro, Peca peca) {
		List<String> posicoes = new LinkedList<String>();
		for(StrategyMoveInterface m: movimentos) {
			posicoes.addAll(m.movePool(tabuleiro, peca));
		}
		return posicoes;
	}

	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
		for(StrategyMoveInterface m: movimentos) {
			m.setLimitacao(ELimiteCasas.OITO);
		}
	}
}
