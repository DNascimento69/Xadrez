/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.controller.cci;

import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.view.cih.TabuleiroView;

/**
 *
 * @author Nascimento
 */
public class TabuleiroControllerView {
	TabuleiroView tabuleiroView = new TabuleiroView();
	
	public void imprimirTabuleiro(Game gameDaVez) {
		tabuleiroView.imprimeTabuleiro(gameDaVez);
	}
}
