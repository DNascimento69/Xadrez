package p2o2.ifes.serra.model.Enum;

public enum ETipoPeca {
	
	Piao (1),
	Torre (2),
	Bispo (3),
	Cavalo (4),
	Rainha (5),
	Rei (6);
	
	private final int value;
	
	ETipoPeca(int valor) {
	        this.value = valor;
	}
	
	 public int getValue() { return value; }

}
