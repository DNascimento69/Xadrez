/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.model.Enum;

/**
 *
 * @author Vic
 */
public enum EPecaMoveu {
	
	sim (1),
	nao (2);
	
	private final int value;
	
	EPecaMoveu(int valor) {
	        this.value = valor;
	}

	 public int getValue() { return value; }
	
}
