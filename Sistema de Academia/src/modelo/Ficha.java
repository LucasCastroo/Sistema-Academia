package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import aplicacao.Principal;

public class Ficha implements Impressao{
	private Integer altura;
	private Double peso;
	private Integer mesesTreino;
	private TipoTreino tipotreino;
	private LocalDate dataVencimento;
	
	public Ficha() {
		
	}
	
	public Ficha(Integer altura, Double peso, Integer mesesTreino, TipoTreino tipoTreino, LocalDate dataVencimento) {
		this.altura = altura;
		this.peso = peso;
		this.mesesTreino = mesesTreino;
		this.tipotreino = tipoTreino;
		this.dataVencimento = dataVencimento;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getMesesTreino() {
		return mesesTreino;
	}

	public void setMesesTreino(Integer mesesTreino) {
		this.mesesTreino = mesesTreino;
	}

	public TipoTreino getTipotreino() {
		return tipotreino;
	}

	public void setTipotreino(TipoTreino tipotreino) {
		this.tipotreino = tipotreino;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public static Ficha preencher() {
		Ficha ficha = new Ficha();
		
		System.out.println("\n\t** AVALIAÇÃO FÍSICA **");
		System.out.println("--------------------------------------------------------------");
		System.out.println("- Seu treino será montado de acordo com essa avaliação!\n");
		System.out.println("* Altura: (cm)");
		ficha.setAltura(Principal.scan.nextInt());
		System.out.println("* Peso:");
		ficha.setPeso(Principal.scan.nextDouble());
		System.out.println("* Quantidade de meses de treino:");
		ficha.setMesesTreino(Principal.scan.nextInt());
		if (ficha.getMesesTreino() <= 6) {
			ficha.setTipotreino(TipoTreino.INICIANTE);
		} else if (ficha.getMesesTreino() > 6 && ficha.getMesesTreino() <= 12) {
			ficha.setTipotreino(TipoTreino.INTERMEDIARIO);
		} else {
			ficha.setTipotreino(TipoTreino.AVANCADO);
		}
		System.out.println("* Data de Vencimento da Ficha: (dd/mm/aaaa)");
		String dataVencimento = Principal.scan.next();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    ficha.setDataVencimento(LocalDate.parse(dataVencimento,formatter));
	    
	    System.out.println("--------------------- Avaliação Concluída ---------------------\n");
		
		return ficha;
	}
	
	@Override
	public String toString() {
		return "Ficha [altura = " + altura + ", peso = " + peso + ", mesesTreino = " + mesesTreino + ", tipotreino = "
				+ tipotreino + ", dataVencimento = " + dataVencimento + "]";
	}

	@Override
	public void imprimir() {
		System.out.println(this);
	}
}
