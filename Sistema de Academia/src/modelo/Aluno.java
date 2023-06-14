package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import aplicacao.Principal;

public class Aluno implements Impressao{
	private Integer matricula;
	private String nome;
	private String endereco;
	private Integer idade;
	private LocalDate dataCadastro;
	private Ficha ficha;	
	
	public Aluno() {
		
	}
	
	public Aluno(Integer matricula, String nome,String endereco, Integer idade, LocalDate dataCadastro, Ficha ficha) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.dataCadastro = dataCadastro;
		this.ficha = ficha;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public static Aluno cadastro(Integer id, String nome) {
		Aluno aluno = new Aluno();
		Principal.scan.nextLine();
		
		System.out.println("\n\t** Novo Aluno **");
		System.out.println("--------------------------------------------------------------");
		System.out.println("- Preencha as informações para adicionar um novo aluno!\n");
		aluno.setMatricula(id);
		aluno.setNome(nome);
		System.out.println("* Endereço:");
		aluno.setEndereco(Principal.scan.nextLine());
		System.out.println("* Idade:");
		aluno.setIdade(Principal.scan.nextInt());
		Principal.scan.nextLine();
		System.out.println("* Data de Cadastro: (dd/MM/yyyy)");
		String dataCadastro = Principal.scan.next();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    aluno.setDataCadastro(LocalDate.parse(dataCadastro,formatter));
		
		System.out.println("--------------------- Aluno Adicionado ---------------------\n");
		
		return aluno;
	}
	
	@Override
	public String toString() {
		return "Aluno [ matricula = " + matricula + ", \nnome = "+ nome +", \nendereco = " + endereco + ", \nidade = " + idade + ", \ndataCadastro = "
				+ dataCadastro +"]";
	}
	
	@Override
	public void imprimir() {
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println(this);
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
	
	public static void imprimirOrdenadoPorIdade(List<Aluno> listaAluno) {
		listaAluno.sort((a1, a2) -> a1.getIdade().compareTo(a2.getIdade()));
		listaAluno.forEach(a -> a.imprimir());
	}
}
