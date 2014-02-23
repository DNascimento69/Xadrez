package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.cdp.reuse.Model;

public class Jogador extends Model{

	
	private String nome;
	private int pontos;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
        
   

	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
}
