package modelo;

import aplicacao.Principal;

public class Telefone implements Impressao {
	private Integer codigoArea;
	private Integer numero;

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public static Telefone adicionarOuAlterar() {
		Telefone telefone = new Telefone();
		
		System.out.println("\n* Digite o código de área:");
		telefone.setCodigoArea(Principal.scan.nextInt());
		System.out.println("* Digite o número:");
		telefone.setNumero(Principal.scan.nextInt());
		
		return telefone;
	}

	@Override
	public void imprimir() {
		System.out.println("* Telefone");
		System.out.println("> Código de Área = " + getCodigoArea());
		System.out.println("> Número = " + getNumero());
	}

	@Override
	public String toString() {
		return "(" + this.codigoArea + ") " + this.numero;
	}

}
