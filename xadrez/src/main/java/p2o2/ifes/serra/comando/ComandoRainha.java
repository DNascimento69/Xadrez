package p2o2.ifes.serra.comando;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalCima;
import p2o2.ifes.serra.strategy.StrategyMoveHorizontalDireita;
import p2o2.ifes.serra.strategy.StrategyMoveHorizontalEsquerda;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;

public class ComandoRainha implements ComandoMovimento {
	
	private LinkedList<StrategyMoveInterface> movimentos = new LinkedList<StrategyMoveInterface>();
	
	public ComandoRainha() {
		this.movimentos.add(new StrategyMoveDiagonalCima());
		this.movimentos.add(new StrategyMoveDiagonalBaixo());
		this.movimentos.add(new StrategyMoveVerticalCima());
		this.movimentos.add(new StrategyMoveVerticalBaixo());
		this.movimentos.add(new StrategyMoveHorizontalDireita());
		this.movimentos.add(new StrategyMoveHorizontalEsquerda());
	}

	public List<String> listaMovimentosPossiveis(Tabuleiro tabuleiro, Peca peca) {
		List<String> movimentosPossiveis = new LinkedList<String>();
		for(StrategyMoveInterface m: movimentos) {
			movimentosPossiveis.addAll( m.movePool(tabuleiro, peca) );
		}
		return movimentosPossiveis;
	}

	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
		for(Object m: movimentos) {
			((StrategyMoveInterface)m).setLimitacao(ELimiteCasas.OITO);
		}
	}
}
