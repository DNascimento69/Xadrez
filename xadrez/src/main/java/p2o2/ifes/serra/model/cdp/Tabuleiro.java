package p2o2.ifes.serra.model.cdp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p2o2.ifes.serra.controller.movimentosEspeciais.MoveRoqueMaior;
import p2o2.ifes.serra.controller.movimentosEspeciais.MoveRoqueMenor;
import p2o2.ifes.serra.model.Enum.EPecaMoveu;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;
import p2o2.ifes.serra.model.Enum.EXeque;

public class Tabuleiro {

	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private Peca[][] matrizTabuleiro = new Peca[8][8];
	private List<Peca> listPecasComidas = new ArrayList<Peca>();
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="GetSeters">
	public void setPecaPosicao(Peca peca, int linha, int coluna) {
		matrizTabuleiro[linha][coluna] = peca;
	}

	public Peca getPecaPosicao(int linha, int coluna) {
		return this.matrizTabuleiro[linha][coluna];
	}

	public Peca[][] getMatrixTabuleiro() {
		return matrizTabuleiro;
	}

	public void setMatrixTabuleiro(Peca[][] matrixTabuleiro) {
		this.matrizTabuleiro = matrixTabuleiro;
	}

	public List<Peca> getListPecasComidas() {
		return listPecasComidas;
	}

	public void setListPecasComidas(List<Peca> listPecasComidas) {
		this.listPecasComidas = listPecasComidas;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Processamento">
	// Calcula a pontuação das peças brancas foras do jogo
	public int ChecaPontosBrancos() {
		int pontuacao = 0;
		if (listPecasComidas.size() > 0) {
			for (int i = 0; i < listPecasComidas.size(); i++) {
				if (((listPecasComidas.get(i)).getCor()).equals(EPlayerColor.white)) {
					pontuacao += (listPecasComidas.get(i)).getPontuacao();
				}
			}
			return pontuacao;
		} else {
			return 0;
		}
	}

	// Calcula a pontuação das peças pretas fora do jogo
	public int ChecaPontosPretos() {
		int pontuacao = 0;
		if (listPecasComidas.size() > 0) {
			for (int i = 0; i < listPecasComidas.size(); i++) {
				if (((listPecasComidas.get(i)).getCor()).equals(EPlayerColor.black)) {
					pontuacao += (listPecasComidas.get(i)).getPontuacao();
				}
			}
			return pontuacao;
		} else {
			return 0;
		}
	}

	public LinkedList<Peca> getPecasBrancas() {
		LinkedList<Peca> listaPecas = new LinkedList<Peca>();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (((matrizTabuleiro[x][y]).getCor()).equals(EPlayerColor.white)) {
					listaPecas.add(matrizTabuleiro[x][y]);
				}
			}
		}
		return listaPecas;
	}

	public LinkedList<Peca> getPecasPretas() {
		LinkedList<Peca> listaPecas = new LinkedList<Peca>();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (((matrizTabuleiro[x][y]).getCor()).equals(EPlayerColor.black)) {
					listaPecas.add(matrizTabuleiro[x][y]);
				}
			}
		}
		return listaPecas;
	}

	public boolean jogada(Game game, String posicao) {

		if (posicao.equals("O-O")) {
			MoveRoqueMenor mrm = new MoveRoqueMenor();
			return mrm.movimentoRoqueMenor(game);

		} else {
			MoveRoqueMaior mrm = new MoveRoqueMaior();
			return mrm.movimentoRoqueMaior(game);
		}

	}

	public boolean jogada(String posicao, EPlayerColor cor) {



		int posicaoColunaInicial = Integer.parseInt(posicao.substring(1, 2));
		int posicaoLinhaInicial = Integer.parseInt(posicao.substring(0, 1));
		String posicaoDestino = posicao.substring(2);

		Peca pecaAMover = this.matrizTabuleiro[posicaoLinhaInicial][posicaoColunaInicial];

		if (pecaAMover == null || !pecaAMover.getCor().equals(cor)) {
			return false;
		} else {
			List<String> lstMovimentos = pecaAMover.getComando().listaMovimentosPossiveis(this, pecaAMover);

			if (lstMovimentos.contains(posicaoDestino)) {
				this.movePeca(pecaAMover, posicaoDestino);
				return true;
			} else {
				return false;
			}
		}

	}

	public EXeque verificaXeque(EPlayerColor eCor) { // pega todas as jogadas possiveis para o exercito inimigo e verifica se o rei esta em uma delas
		List<Peca> pecasInimigas;
		pecasInimigas = new LinkedList<Peca>();

		String posRei;
		if (eCor.equals(EPlayerColor.white)) {
			posRei = achaRei("KB");
			pecasInimigas = getPecasPretas();
		} else {
			posRei = achaRei("KP");
			pecasInimigas = getPecasBrancas();
		}
		int posReiX = Integer.getInteger(posRei.substring(0, 1));
		int posReiY = Integer.getInteger(posRei.substring(1));
		Peca rei = matrizTabuleiro[posReiX][posReiY];

		List<String> todasPossibilidadesInimigo = null;

		for (int x = 0; x < pecasInimigas.size(); x++) {
			todasPossibilidadesInimigo.addAll(pecasInimigas.get(x).listaMovimentosPossiveisPeca(this));
		}

		int x = 0;
		boolean xeque = false;
		if (todasPossibilidadesInimigo != null) {
			while ((x < todasPossibilidadesInimigo.size()) && (!xeque)) {
				if (todasPossibilidadesInimigo.get(x).equalsIgnoreCase(posRei)) {
					xeque = true;
				}
				x++;
			}
		}

		if (xeque == true) { // se o rei estiver em xegue, esta parte vai testar se ele esta em xeque mate
			List<String> todasPossibilidadesRei = rei.listaMovimentosPossiveisPeca(this);

			if ((todasPossibilidadesRei != null) && (todasPossibilidadesRei.size() > 0)) {
				return (EXeque.Xeque);
			} else {
				return (EXeque.XequeMate);
			}
		}
		return EXeque.Livre;
	}

	private String achaRei(String idRei) {
		boolean achou = false;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (this.matrizTabuleiro[x][y].getPecaId().equalsIgnoreCase(idRei)) {
					return Integer.toString(x) + Integer.toString(y);
				}
			}
		}
		return null;
	}

	public void movePeca(Peca peca, String posicaoDestino) {
		int posicaoColunaDestino = Integer.parseInt(posicaoDestino.substring(1, 2));
		int posicaoLinhaDestino = Integer.parseInt(posicaoDestino.substring(0, 1));
		int posicaoColunaInicial = Integer.parseInt(peca.getPosicao().substring(1, 2));
		int posicaoLinhaInicial = Integer.parseInt(peca.getPosicao().substring(0, 1));

		Peca pecaDestino = this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino];

		if (pecaDestino != null) {
			pecaDestino.setStatusPeca(EStatusPeca.morto);
			this.listPecasComidas.add(pecaDestino);
		}
		this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino] = null;
		this.matrizTabuleiro[posicaoLinhaInicial][posicaoColunaInicial] = null;

		peca.setPosicao(posicaoDestino);
		peca.setPecaMoveu(EPecaMoveu.sim);
		this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino] = peca;
	}

	public LinkedList<String> listaPosicoesPossiveis(LinkedList<Peca> listaPecas) {
		LinkedList<String> listaPosicoes = new LinkedList<String>();
		for (Peca l : listaPecas) {
			listaPosicoes.addAll(l.listaMovimentosPossiveisPeca(this));
		}
		return listaPosicoes;
	}

	public List<Peca> listarPecasJogo() {
		List<Peca> lstPecas = new ArrayList<Peca>();
		lstPecas.addAll(this.listPecasComidas);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.matrizTabuleiro[i][j] != null) {
					lstPecas.add(this.matrizTabuleiro[i][j]);
				}
			}
		}

		return lstPecas;
	}
	// </editor-fold>	
}
