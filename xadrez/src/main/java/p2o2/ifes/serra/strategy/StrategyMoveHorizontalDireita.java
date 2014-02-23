package p2o2.ifes.serra.strategy;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class StrategyMoveHorizontalDireita implements StrategyMoveInterface {
	private ELimiteCasas limitacaoCasas;

	public StrategyMoveHorizontalDireita() {}

	public List<String> movePool(Tabuleiro tabuleiro, Peca peca) {
		List<String> jogadasValidasLst = new LinkedList<String>();
		int linhaAuxiliar = Integer.parseInt(peca.getPosicao().substring(0,1));
		int colunaAuxiliar = Integer.parseInt(peca.getPosicao().substring(1));
		String jogadaPossivel;
		
		int x = 1;
		boolean parar = false;
		while ((x <= this.limitacaoCasas.getLimiteCasas()) && (!parar) && (colunaAuxiliar + x <= 7)) {
			Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar, colunaAuxiliar + x);
			jogadaPossivel = Integer.toString(linhaAuxiliar) + Integer.toString(colunaAuxiliar + x);
			if (pecaPos != null) {
				if (peca.getCor().equals(pecaPos.getCor())) {
					jogadasValidasLst.add(jogadaPossivel);
				}
				parar = true;
			} else {
				jogadasValidasLst.add(jogadaPossivel);
			}
		}
		
		return jogadasValidasLst;
	}

	public void setLimitacao(ELimiteCasas l) {
		this.limitacaoCasas = l;
	}
}
