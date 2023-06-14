package modelo;


public enum TipoUsuario {
	ALUNO(1, "Aluno"), INSTRUTOR(2, "Instrutor");
	
	private Integer id;
	private String label;

	private TipoUsuario(Integer id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	// Método comparar id da classe
	public static TipoUsuario valueof(Integer id) {
		if (id == null) {
			return null;
		}

		for (TipoUsuario tipo : TipoUsuario.values()) {
			if (tipo.getId() == id) {
				return tipo;
			}
		}

		return null;
	}

}
