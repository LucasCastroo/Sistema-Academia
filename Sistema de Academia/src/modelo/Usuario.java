package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import aplicacao.Principal;

public class Usuario implements Impressao {
	private Integer id;
	private String nomeCompleto;
	private String email;
	private String senha;
	private TipoUsuario tipoUsuario;
	private List<Telefone> listaTelefone;

	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nomeCompleto, String email, String senha, TipoUsuario tipoUsuario,
			List<Telefone> listaTelefone) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.listaTelefone = listaTelefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public static Usuario cadastro(List<Usuario> listaUsuario ,List<Aluno> listaAluno) {
		Usuario usuario = new Usuario();
		List<Telefone> listaTelefone = new ArrayList<Telefone>();

		System.out.println("\n\t** CADASTRE-SE **");
		System.out.println("--------------------------------------------------------------");
		System.out.println("- Preencha as informações para adicionar um novo usuário!\n");
		
		boolean tentativaId = false;
		do {
			try {
				System.out.println("* ID do Usuário:");
				int idExist = Principal.scan.nextInt(); 
				
				for (Usuario u : listaUsuario) {
					if (u.getId() == idExist) {
						throw new Exception("XX ID já existe! XX");
					}
				}	
				usuario.setId(idExist);
				tentativaId = true;
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		} while (tentativaId == false);
		
		Principal.scan.nextLine();
		System.out.println("* Nome Completo:");
		usuario.setNomeCompleto(Principal.scan.nextLine());
		// Não aceitar email sem @
		boolean erro = false;
		do {
			System.out.println("* Email:");
			usuario.setEmail(Principal.scan.next());

			int arroba = usuario.getEmail().indexOf("@");
			if (arroba < 0) {
				System.out.println("\n\tX Informe um email válido! X\n");
				erro = false;
			} else {
				erro = true;
			}
		} while (erro == false);

		System.out.println("* Senha:");
		usuario.setSenha(Principal.scan.next());
		System.out.println("* Tipo de usuário:");
		for (TipoUsuario tipo : TipoUsuario.values()) {
			System.out.println("[" + tipo.getId() + "]" + " - " + tipo.getLabel());
		}
		System.out.print("=> ");
		usuario.setTipoUsuario(TipoUsuario.valueof(Principal.scan.nextInt()));
		if (usuario.getTipoUsuario() == TipoUsuario.ALUNO) {
			listaAluno.add(Aluno.cadastro(usuario.getId(), usuario.getNomeCompleto())); 
		}
		System.out.println("- Deseja adicionar quantos telefones?");
		int telefone = Principal.scan.nextInt();
		for (int i = 0; i < telefone; i++) {
			System.out.println("\n> Telefone " + (i + 1));
			listaTelefone.add(Telefone.adicionarOuAlterar());
		}
		usuario.listaTelefone = listaTelefone;

		System.out.println("--------------------- Cadastro Concluído --------------------\n");
		return usuario;
	}

	public static void alterarDados(Usuario logado) {
		System.out.println("\n\t** ALTERAR DADOS **");
		System.out.println("--------------------------------------\n");
		System.out.println("- Deseja alterar quais dados?");
		System.out.println("[1] - Nome\n[2] - Email\n[3] - Senha\n[4] - Telefone\n");
		System.out.println("--------------------------------------");
		System.out.print("\n=> ");
		int opcao = Principal.scan.nextInt();
		Principal.scan.nextLine();
		switch (opcao) {
		case 1:
			System.out.println("\n* Altere o seu nome:");
			System.out.print("> ");
			logado.setNomeCompleto(Principal.scan.nextLine());
			break;

		case 2:
			System.out.println("\n* Altere o seu email:");
			System.out.print("> ");
			logado.setEmail(Principal.scan.next());
			break;
		case 3:
			System.out.println("\n* Altere a sua senha:");
			System.out.print("> ");
			logado.setSenha(Principal.scan.next());
			break;
		case 4:
			System.out.println("\n* Altere o seu Telefone:");
			logado.listaTelefone.add(Telefone.adicionarOuAlterar());
			
			break;
		default:
			System.out.println("X Opção Inválida! X");
			break;
		}
	}

	@Override
	public void imprimir() {
		System.out.println("\n------------------------------------------------------------------------------------------------------------");
		System.out.println(this);
		System.out.println("--------------------------------------------------------------------------------------------------------------\n");
	}

	@Override
	public String toString() {
		return "Usuario [nomeCompleto = " + nomeCompleto + ", \nemail = " + email + ", \nsenha = " + senha
				+ ", \ntipoUsuario = " + tipoUsuario + ", \nlistaTelefone = " + listaTelefone + "]";
	}

	public static void imprimirOrdenadoPorNome(List<Usuario> listaUsuario) {
		listaUsuario.sort((u1, u2) -> u1.getNomeCompleto().compareTo(u2.getNomeCompleto()));
		listaUsuario.forEach(u -> u.imprimir());
	}
	public static void imprimirOrdenadoPorID(List<Usuario> listaUsuario) {
		listaUsuario.sort((u1, u2) -> u1.getId().compareTo(u2.getId()));
		listaUsuario.forEach(u -> u.imprimir());
	}
	public static void imprimirOrdenadoPorEmail(List<Usuario> listaUsuario) {
		listaUsuario.sort((u1, u2) -> u1.getEmail().compareToIgnoreCase(u2.getEmail()));
		listaUsuario.forEach(u -> u.imprimir());
	}
	
}
