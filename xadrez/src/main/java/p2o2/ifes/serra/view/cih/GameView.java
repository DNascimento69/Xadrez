package p2o2.ifes.serra.view.cih;

public class GameView {
	
	// Mostrando o menu
	public void show() {
		mostrarMenu();
	}

	// Mostrando o menu
	private void mostrarMenu() {

		System.out.println("Escolha a Opção de Jogo");
		System.out.println("1 - Jogar sozinho");
		System.out.println("2 - Modo desafio (2 player's)");
	}
	
	//Mensagem de opão Invalida
	public void mensagemOpcaoInvalida (){
		System.out.println("Opcão invalida");
	}
	
	//Mensavem de fim de execução
	public void mensagemFim (){
		System.out.println("Fim do programa!");
	}


}
