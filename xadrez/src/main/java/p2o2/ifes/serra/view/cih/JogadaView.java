package p2o2.ifes.serra.view.cih;

public class JogadaView {
	
		// Mostrando o menu
		public void show() {
			mostrarMenu();
		}

		// Mostrando o menu
		private void mostrarMenu() {

			System.out.println("Escolha a Opção de Jogo");
			System.out.println("1 - Jogar");
			System.out.println("2 - Propor Empate");
			System.out.println("3 - Desistir");
			System.out.println("4 - Salvar");
			
		}
		
		//Mensagem de opão Invalida
		public void mensagemOpcaoInvalida (){
			System.out.println("Opcão invalida");
		}
		
		//Mensavem de fim de execução
		public void mensagemFim (){
			System.out.println("Fim do programa!");
		}
		
		public void mensagemZeusJogando(){
			System.out.println("Zeus está fazendo sua jogada");
		}

}
