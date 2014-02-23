package p2o2.ifes.serra.strategy;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class StrategyMoveVerticalCima implements StrategyMoveInterface {
	private ELimiteCasas limitacaoCasas;
	
	public StrategyMoveVerticalCima() {}
	
	public List<String> movePool (Tabuleiro tabuleiro, Peca peca) {
		List<String> jogadasValidasLst = new LinkedList<String>();
		int linhaAuxiliar = Integer.parseInt(peca.getPosicao().substring(0,1));
		int colunaAuxiliar = Integer.parseInt(peca.getPosicao().substring(1));
		String jogadaPossivel;
		
		int x = 1;
		boolean parar = false;
		while ((x <= this.limitacaoCasas.getLimiteCasas() && !parar) && (linhaAuxiliar + x <= 7)) {
			Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar + x, colunaAuxiliar);
			jogadaPossivel = Integer.toString(linhaAuxiliar + x) + Integer.toString(colunaAuxiliar);
			if (pecaPos != null) {
				if (peca.getCor().equals(pecaPos.getCor())) {
					jogadasValidasLst.add(jogadaPossivel);
				}
				parar = true;
			} else {
				jogadasValidasLst.add(jogadaPossivel);
			}
			x++;
		}
		return jogadasValidasLst;
	}

	public void setLimitacao(ELimiteCasas l) {
		this.limitacaoCasas = l;
	}
}
