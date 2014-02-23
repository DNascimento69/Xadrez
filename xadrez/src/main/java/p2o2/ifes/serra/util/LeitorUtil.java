package p2o2.ifes.serra.util;

import java.util.Scanner;

// Classe retirada do exemplo CalculadoraMVC do professor Paulo Sergio Santos Junior
public class LeitorUtil {
	
	private Scanner leitorOpcao; 
	
	public static Integer lervalorInteiro() {
		Scanner s = new Scanner(System.in);
		 
		return  s.nextInt();
	}

	public static Double lervalorDouble() {
		 Scanner s = new Scanner(System.in);
		return s.nextDouble();
	}
	
	// Função adicionada ao original
	public static String lervalorString() {
		Scanner s = new Scanner(System.in);
		return s.next();
	}
	
}
