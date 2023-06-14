package modelo;

public enum TipoTreino {
	INICIANTE(1,"Iniciante", "\nSeg = Peito e Costas; \nQua = Perna Completo; "
			+ "\nSex = Ombro, Bíceps e Tríceps;"), 
	INTERMEDIARIO(2, "Intermediário", "\nSeg = Peito e Ombro; "
			+ "\nTer = Perna(Ênfase glúteo e posterior); \nQua = Costas e Antebraço; "
			+ "\nQui = Perna(Ênfase quadíceps); \nSex = Bíceps e Tríceps"), 
	AVANCADO(3, "Avançado", "\nSeg = Peito; \nTer = Posterior e Glúteo; \nQua = Costas; "
			+ "\nQui = Quadríceps; \nSex = Tríceps e Ombro; \nSáb = Bíceps e Antebraço");
	
	private Integer id;
	private String treino;
	private String descricao;

	private TipoTreino(Integer id, String treino,String descricao) {
		this.id = id;
		this.treino = treino;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTreino() {
		return treino;
	}

	public void setTreino(String treino) {
		this.treino = treino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
