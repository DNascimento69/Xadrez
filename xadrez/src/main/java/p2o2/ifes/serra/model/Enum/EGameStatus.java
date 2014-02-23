package p2o2.ifes.serra.model.Enum;

public enum EGameStatus {
	EmAndamento (1),
	Terminado (2);
        
        private final int value;
	
	EGameStatus(int valor) {
	        this.value = valor;
	}

	 public int getValue() { return value; }
}
