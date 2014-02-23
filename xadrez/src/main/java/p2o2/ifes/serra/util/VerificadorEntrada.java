/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.util;

/**
 *
 * @author Nascimento
 */
public class VerificadorEntrada {
	
	public static boolean verificaEntradaJogada(String s) {
		String[] ver = {"0","1","2","3","4","5","6","7"};
		int x = 0, y = 1;
		boolean achou = false;
		
		if ((s.equalsIgnoreCase("O-O")) || (s.equalsIgnoreCase("O-O-O"))) {
			return true;
		}
		
		if (!(s.length() == 4)) {
			return false;
		}
		
		while (x <= 3) {
			achou = false;
			String verifica = s.substring(x, y);
			for(String v: ver) {
				if (v.equalsIgnoreCase(verifica)) {
					achou = true;
				}
			}
			x++;
			y++;
		}
		if (!achou) {
			return false;
		}
		return true;
	}
}
