package p2o2.ifes.serra.strategy;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class StrategyMoveDiagonalBaixo implements StrategyMoveInterface {
	private ELimiteCasas limitacaoCasas;
	
	public StrategyMoveDiagonalBaixo() {}
	
	public List<String> movePool(Tabuleiro tabuleiro, Peca peca) {
		List<String> jogadasValidasLst = new LinkedList<String>();
		String jogadaPossivel;
		
		// Direita
		int x = 1;
		boolean parar = false;
		int linhaAuxiliar = Integer.parseInt(peca.getPosicao().substring(0,1)) - 1;
		int colunaAuxiliar = Integer.parseInt(peca.getPosicao().substring(1)) + 1;
		while((x <= this.limitacaoCasas.getLimiteCasas()) && (!parar) && (linhaAuxiliar >= 0) && (colunaAuxiliar <= 7)) {
			
			Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar, colunaAuxiliar);
			jogadaPossivel = Integer.toString(linhaAuxiliar) + Integer.toString(colunaAuxiliar);
			if (pecaPos != null) {
				if (!peca.getCor().equals(pecaPos.getCor())) {
					jogadasValidasLst.add(jogadaPossivel);
				}
				parar = true;
			} else {
				jogadasValidasLst.add(jogadaPossivel);
			}
			linhaAuxiliar--;
			colunaAuxiliar++;
			x++;
		}

		// Esquerda
		x=1;
		parar = false;
		linhaAuxiliar = Integer.parseInt(peca.getPosicao().substring(0,1)) - 1;
		colunaAuxiliar = Integer.parseInt(peca.getPosicao().substring(1)) - 1;
		while((x <= this.limitacaoCasas.getLimiteCasas()) && (!parar) && (linhaAuxiliar >= 0) && (colunaAuxiliar >= 0)) {
			
			Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar, colunaAuxiliar);
			jogadaPossivel = Integer.toString(linhaAuxiliar) + Integer.toString(colunaAuxiliar);
			if (pecaPos != null) {
				if (!peca.getCor().equals(pecaPos.getCor())) {
					jogadasValidasLst.add(jogadaPossivel);
				}
				parar = true;
			} else {
				jogadasValidasLst.add(jogadaPossivel);
			}
			linhaAuxiliar--;
			colunaAuxiliar--;
			x++;
		}
		
		return jogadasValidasLst;
	}

	public void setLimitacao(ELimiteCasas l) {
		this.limitacaoCasas = l;
	}
}