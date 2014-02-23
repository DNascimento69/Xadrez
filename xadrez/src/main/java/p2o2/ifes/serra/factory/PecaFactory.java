package p2o2.ifes.serra.factory;

import p2o2.ifes.serra.comando.*;
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.ETipoPeca;
import p2o2.ifes.serra.model.cdp.Peca;

public class PecaFactory {

	public Peca getPiece(ETipoPeca tipo,EPlayerColor cor,int idGame) {
		Peca peca = new Peca();
		peca.setCor(cor);
		peca.setIdGame(idGame);
		peca.setPecaMoveu(EPecaMoveu.nao);
                
		switch(tipo){
			case Torre:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoTorre());
				return peca;
			case Bispo:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoBispo());
				return peca;
			case Cavalo:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoCavalo());
				return peca;
			case Rainha:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoRainha());
				return peca;
			case Rei:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoRei());
				return peca;
			default:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                if(cor.equals(EPlayerColor.black)){
                                    peca.setComando(new ComandoPeaoPreto());
                                }
                                else{
                                     peca.setComando(new ComandoPeaoBranco());
                                }
				return peca;
		}
	}
	
	protected String getPecaId(ETipoPeca tipo,EPlayerColor cor){
		String corPeca = cor == EPlayerColor.black? "P": "B";
		
		switch(tipo){
			case Torre:
				return "T"+corPeca;
			case Bispo:
				return "I"+corPeca;
			case Cavalo:
				return "C"+corPeca;
			case Rainha:
				return "Q"+corPeca;
			case Rei:
				return "k"+corPeca;
			default:
				return "E"+corPeca;
		}
		
	}
}
