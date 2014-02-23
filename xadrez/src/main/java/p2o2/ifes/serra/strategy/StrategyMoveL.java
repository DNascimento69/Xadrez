package p2o2.ifes.serra.strategy;

import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class StrategyMoveL implements StrategyMoveInterface {

	public List<String> movePool(Tabuleiro tabuleiro, Peca peca) {
		List<String> jogadasValidasLst = new ArrayList<String>();
		int linhaAuxiliar = Integer.parseInt(peca.getPosicao().substring(0, 1));
		int colunaAuxiliar = Integer.parseInt(peca.getPosicao().substring(1));
		String jogadaPossivel;

		// Jogada para cima
		if (linhaAuxiliar + 2 <= 7) {
			if (colunaAuxiliar + 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar + 2, colunaAuxiliar + 1);
				jogadaPossivel = Integer.toString(linhaAuxiliar + 2) + (colunaAuxiliar + 1);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
			if (colunaAuxiliar - 1 >= 0) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar + 2, colunaAuxiliar + 1);
				jogadaPossivel = Integer.toString(linhaAuxiliar + 2) + (colunaAuxiliar - 1);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
		}

		// Jogada para baixo
		if (linhaAuxiliar - 2 >= 0) {
			if (colunaAuxiliar + 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar - 2, colunaAuxiliar + 1);
				jogadaPossivel = Integer.toString(linhaAuxiliar - 2) + (colunaAuxiliar + 1);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
			if (colunaAuxiliar - 1 >= 0) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar - 2, colunaAuxiliar - 1);
				jogadaPossivel = Integer.toString(linhaAuxiliar - 2) + (colunaAuxiliar - 1);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}

			}
		}

		// Jogada pra direita
		if (colunaAuxiliar + 2 <= 7) {
			if (linhaAuxiliar + 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar + 1, colunaAuxiliar + 2);
				jogadaPossivel = Integer.toString(linhaAuxiliar + 1) + (colunaAuxiliar + 2);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
			if (linhaAuxiliar - 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar - 1, colunaAuxiliar + 2);
				jogadaPossivel = Integer.toString(linhaAuxiliar - 1) + (colunaAuxiliar + 2);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
		}

		// Jogada para esquerda
		if (colunaAuxiliar - 2 >= 0) {
			if (linhaAuxiliar + 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar + 1, colunaAuxiliar - 2);
				jogadaPossivel = Integer.toString(linhaAuxiliar + 1) + (colunaAuxiliar - 2);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
			if (linhaAuxiliar - 1 <= 7) {
				Peca pecaPos = tabuleiro.getPecaPosicao(linhaAuxiliar - 1, colunaAuxiliar - 2);
				jogadaPossivel = Integer.toString(linhaAuxiliar - 1) + (colunaAuxiliar - 2);
				if (pecaPos != null) {
					if (peca.getCor().equals(pecaPos.getCor())) {
						jogadasValidasLst.add(jogadaPossivel);
					}
				} else {
					jogadasValidasLst.add(jogadaPossivel);
				}
			}
		}
		
		return jogadasValidasLst;
	}

	public void setLimitacao(ELimiteCasas l) {	}
}
