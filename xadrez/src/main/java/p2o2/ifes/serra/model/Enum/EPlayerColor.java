package p2o2.ifes.serra.model.Enum;

public enum EPlayerColor {
	
	white (1),
	black (2),
	zeus (3);
	
	private final int value;
	
	EPlayerColor(int valor) {
	        this.value = valor;
	}

	 public int getValue() { return value; }


}
