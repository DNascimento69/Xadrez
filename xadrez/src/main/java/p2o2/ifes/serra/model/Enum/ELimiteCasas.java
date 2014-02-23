package p2o2.ifes.serra.model.Enum;

public enum ELimiteCasas {	
	UM(1),
	DOIS(2),
	OITO(8);
	
	private int qtdCasas;

	ELimiteCasas(int i) {
		this.qtdCasas = i;
	}
	
	public int getLimiteCasas() {
		return this.qtdCasas;
	}
}
