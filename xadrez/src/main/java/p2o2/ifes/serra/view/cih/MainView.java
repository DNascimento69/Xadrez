package p2o2.ifes.serra.view.cih;

public class MainView {
	
	
	// Mostrando o menu
	public void show() {
		mostrarMenu();
	}

	// Mostrando o menu
	private void mostrarMenu() {

		System.out.println("Bem vindo ao XezMaster's Poo2");
		System.out.println("1 - Iniciar uma nova partida");
		System.out.println("2 - Retornar uma partida");
		System.out.println("3 - Dados das partidas");
		System.out.println("4 - Sair");

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
