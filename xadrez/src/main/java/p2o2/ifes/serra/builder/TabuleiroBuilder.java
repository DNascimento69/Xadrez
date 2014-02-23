package p2o2.ifes.serra.builder;

import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.factory.PecaFactory;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;
import p2o2.ifes.serra.model.Enum.ETipoPeca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.model.cdp.Peca;

public class TabuleiroBuilder {
        private int idGame;
	private Tabuleiro tabuleiro;

	public TabuleiroBuilder(int id) {
		this.tabuleiro = new Tabuleiro();
                this.idGame = id;
	}
	
	
	public void CriarPecas(){
		List<Peca> listPecas = new ArrayList<Peca>();
		listPecas.addAll(criarPecasBrancas());
		listPecas.addAll(criarPecasPretas());
		
		inserirPecas(listPecas);
	}
	
	public void RemakePecas(List<Peca> listPeca){
		List<Peca> lstPecaViva = new ArrayList<Peca>();
		List<Peca> lstPecaMorta = new ArrayList<Peca>();
		
		for(Peca peca:listPeca){
			if(peca.getStatusPeca().equals(EStatusPeca.vivo)){
				lstPecaViva.add(peca);
			}
			else{
				lstPecaMorta.add(peca);
			}
		}
		
		tabuleiro.setListPecasComidas(lstPecaMorta);
		inserirPecas(lstPecaViva);
	}
	
	private void inserirPecas(List<Peca> pecasAInserir){
		int linhaPeca;
		int colunaPeca;
		for(Peca peca : pecasAInserir){
			colunaPeca = Integer.parseInt(peca.getPosicao().substring(0,1));
			linhaPeca = Integer.parseInt(peca.getPosicao().substring(1));
			
			tabuleiro.setPecaPosicao(peca, colunaPeca, linhaPeca);
		}
	}
	
	//Cria todas as Pecas Brancas de um jogo NOVO
	private  List<Peca> criarPecasBrancas(){
		PecaFactory fabricapeca = new PecaFactory();
		List<Peca> listPecasBrancas = new ArrayList<Peca>();
		int colunaMaximaTabuleiro = 7;
		int linhaDosPiao = 6;
		int LinhaDasBrancas = 7;
		Peca pecaCriada = new Peca();
		
               
		//Cria Peões
		for(int coluna= 0; coluna <= colunaMaximaTabuleiro; coluna++){
			pecaCriada = fabricapeca.getPiece(ETipoPeca.Piao ,EPlayerColor.white,idGame);
			pecaCriada.setPosicao(Integer.toString(linhaDosPiao)+Integer.toString(coluna));
                        listPecasBrancas.add(pecaCriada);
		}
		
		//Cria Cavalos
		for(int coluna= 1; coluna < colunaMaximaTabuleiro; coluna = coluna+5){
			pecaCriada = fabricapeca.getPiece(ETipoPeca.Cavalo ,EPlayerColor.white,idGame);
			pecaCriada.setPosicao(Integer.toString(LinhaDasBrancas)+Integer.toString(coluna));
                        listPecasBrancas.add(pecaCriada);
		}
		
		//Cria Bispo
		for(int coluna= 2; coluna < colunaMaximaTabuleiro; coluna = coluna+3){
			pecaCriada = fabricapeca.getPiece(ETipoPeca.Bispo ,EPlayerColor.white,idGame);
			pecaCriada.setPosicao(Integer.toString(LinhaDasBrancas)+Integer.toString(coluna));
                        listPecasBrancas.add(pecaCriada);
		}
			
		//Cria Rei
		pecaCriada = fabricapeca.getPiece(ETipoPeca.Rei ,EPlayerColor.white,idGame);
		pecaCriada.setPosicao(Integer.toString(LinhaDasBrancas)+Integer.toString(4));
                listPecasBrancas.add(pecaCriada);
		
		//Cria Rainha
		pecaCriada = fabricapeca.getPiece(ETipoPeca.Rainha ,EPlayerColor.white,idGame);
		pecaCriada.setPosicao(Integer.toString(LinhaDasBrancas)+Integer.toString(3));
                listPecasBrancas.add(pecaCriada);
                
                 //Cria Torres
                for(int coluna= 0; coluna <= colunaMaximaTabuleiro; coluna = coluna+7){
                    pecaCriada = fabricapeca.getPiece(ETipoPeca.Torre , EPlayerColor.white,idGame);
                    pecaCriada.setPosicao(Integer.toString(LinhaDasBrancas)+Integer.toString(coluna));
                    listPecasBrancas.add(pecaCriada);
                }
		
		return listPecasBrancas;
	}
	
	//Cria todas as Pecas Pretas de um jogo NOVO
		private  List<Peca> criarPecasPretas(){
			PecaFactory fabricapeca = new PecaFactory();
			List<Peca> listPecasPretas = new ArrayList<Peca>();
			int colunaMaximaTabuleiro = 7;
			int linhaDosPiao = 1;
			int LinhaDasPretas = 0;
			Peca pecaCriada;
			
			//Cria Peões
			for(int coluna= 0; coluna <= colunaMaximaTabuleiro; coluna++){
				pecaCriada = fabricapeca.getPiece(ETipoPeca.Piao , EPlayerColor.black,idGame);
				pecaCriada.setPosicao(Integer.toString(linhaDosPiao)+Integer.toString(coluna));
                                listPecasPretas.add(pecaCriada);
			}
			
			//Cria Cavalos
			for(int coluna= 1; coluna < colunaMaximaTabuleiro; coluna = coluna+5){
				pecaCriada = fabricapeca.getPiece(ETipoPeca.Cavalo ,EPlayerColor.black,idGame);
				pecaCriada.setPosicao(Integer.toString(LinhaDasPretas)+Integer.toString(coluna));
                                listPecasPretas.add(pecaCriada);
			}
			
			//Cria Bispo
			for(int coluna= 2; coluna < colunaMaximaTabuleiro; coluna = coluna+3){
				pecaCriada = fabricapeca.getPiece(ETipoPeca.Bispo , EPlayerColor.black,idGame);
				pecaCriada.setPosicao(Integer.toString(LinhaDasPretas)+Integer.toString(coluna));
                                listPecasPretas.add(pecaCriada);
			}
				
			//Cria Rei
			pecaCriada = fabricapeca.getPiece(ETipoPeca.Rei , EPlayerColor.black,idGame);
			pecaCriada.setPosicao(Integer.toString(LinhaDasPretas)+Integer.toString(4));
                        listPecasPretas.add(pecaCriada);
			
			//Cria Rainha
			pecaCriada = fabricapeca.getPiece(ETipoPeca.Rainha , EPlayerColor.black,idGame);
			pecaCriada.setPosicao(Integer.toString(LinhaDasPretas)+Integer.toString(3));
                        listPecasPretas.add(pecaCriada);
                        
                        //Cria Torres
                        for(int coluna= 0; coluna <= colunaMaximaTabuleiro; coluna = coluna+7){
                            pecaCriada = fabricapeca.getPiece(ETipoPeca.Torre , EPlayerColor.black,idGame);
                            pecaCriada.setPosicao(Integer.toString(LinhaDasPretas)+Integer.toString(coluna));
                            listPecasPretas.add(pecaCriada);
                        }
                        
		
			return listPecasPretas;
		}
	
	public Tabuleiro getTabuleiro(){
		return tabuleiro;
	}

}
