package aplicacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Aluno;
import modelo.Ficha;
import modelo.Telefone;
import modelo.TipoTreino;
import modelo.TipoUsuario;
import modelo.Usuario;

public class Principal {

	public static final Scanner scan = new Scanner(System.in);
	static Usuario logado;

	public static void main(String[] args) {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		
		// Usuário já cadastrados
		listaUsuario.add(new Usuario(1, "Lucas Castro", "lucas@gmail.com", "1111", TipoUsuario.ALUNO, new ArrayList<Telefone>()));
		listaUsuario.add(new Usuario(2, "Filipe Dias", "filipe@gmail.com", "2222", TipoUsuario.ALUNO, new ArrayList<Telefone>()));
		listaUsuario.add(new Usuario(3, "Álvaro Calebe", "alvaro@gmail.com", "3333", TipoUsuario.ALUNO, new ArrayList<Telefone>()));
		listaUsuario.add(new Usuario(4, "Matheus Naves", "matheus@gmail.com", "0000", TipoUsuario.INSTRUTOR, new ArrayList<Telefone>()));
		// Ficha já cadastradas
		Ficha fichaLucas = new Ficha(172, 69.0, 25, TipoTreino.AVANCADO, LocalDate.of(2023, 06, 13));
		Ficha fichaFilipe = new Ficha(170, 75.6, 4, TipoTreino.INICIANTE, LocalDate.of(2023, 07, 02));
		// Alunos Cadastrados
		listaAluno.add(new Aluno(1, "Lucas Castro", "laskdkngnsk", 18, LocalDate.now(), fichaLucas));
		listaAluno.add(new Aluno(2, "Filipe Dias", "ppqiwjthtw", 21, LocalDate.now(), fichaFilipe));
		listaAluno.add(new Aluno(3, "Álvaro Calebe", "rthqejrop", 22, LocalDate.now(), null));
		
		// CRUD ESTÁ SENDO FEITO DIRETAMENTE NESTA CLASSE PRINCIPAL
		
		System.out.println("\nOlá Usuário, bem-vindo ao sistema da Academia Castro!");
		int opcao;
		do {
			System.out.println("\n\t** TELA INICIAL **");
			System.out.println("----------------------------------------------");
			System.out.println("\n* Escolha uma opção:");
			System.out.println("[1] - Login\n[2] - Cadastro\n[0] - Encerrar\n");
			System.out.println("----------------------------------------------");
			System.out.print("\n=> ");
			opcao = scan.nextInt();

			
			switch (opcao) {
			case 1:
				login(listaUsuario);
					if (logado.getTipoUsuario() == TipoUsuario.ALUNO) {
						int opcao2;
						do {
							System.out.println("\n\n\t** ALUNO **");
							System.out.println("------------------------------------------------");
							System.out.println("\n* Escolha uma opção:");
							System.out.println("[1] - Vizualizar ficha\n[2] - Alterar dados\n[0] - Finalizar Sessão");
							System.out.println("\n----------------------------------------------");
							System.out.print("\n=> ");
							opcao2 = scan.nextInt();
							switch (opcao2) {

							case 1:
								//Read
								Aluno alunoLogado = getAluno(listaAluno, logado.getId());
								System.out.println("\n\t** TREINO **");
								System.out.print("------------------------------------------------");
								System.out.println(alunoLogado.getFicha().getTipotreino().getDescricao());
								System.out.println("------------------------------------------------");
								break;
							case 2:
								//UpDate
								Usuario.alterarDados(logado);
								break;
							case 0:
								opcao2 = 0;
								break;
							default:
								System.out.println("X Opção Inválida! X");
								break;
							}
						} while (opcao2 != 0);
						break;
					} else{
						int opcao2;
						do {
							System.out.println("\n\n\t** INSTRUTOR **");
							System.out.println("------------------------------------------------");
							System.out.println("\n* Escolha uma opção:");
							System.out.println("[1] - Realizar Avaliação Física\n[2] - Listar todos os Usuários\n[3] - Listar todos os Alunos\n[4] - Deletar um aluno\n[5] - Alterar dados\n[0] - Finalizar Sessão");
							System.out.println("\n----------------------------------------------");
							System.out.print("\n=> ");
							opcao2 = scan.nextInt();
							switch (opcao2) {

							case 1:
								//Create
								listaAluno.forEach(a -> a.imprimir());
								System.out.println("\n* Selecione (pela matrícula) o aluno que deseja fazer a avaliação:");
								System.out.print("=> ");
								int selecionarAluno = Principal.scan.nextInt();
								getAluno(listaAluno, selecionarAluno).setFicha(Ficha.preencher());
								break;
							case 2:
								//Read
								System.out.println("\n- Deseja imprimir ordenado por qual critério?");
								System.out.println("[1] - Nome\n[2] - ID\n[3] - Email\n");
								System.out.print("\n=> ");
								int ordemListar = scan.nextInt();
								if (ordemListar == 1) {
									Usuario.imprimirOrdenadoPorNome(listaUsuario);
								}else if (ordemListar == 2) {
									Usuario.imprimirOrdenadoPorID(listaUsuario);
								}else if (ordemListar == 3) {
									Usuario.imprimirOrdenadoPorEmail(listaUsuario);
								}else {
									System.out.println("XX Opção Inválida! XX");
								}
								break;
							case 3:
								//Read
								System.out.println("\n* Listando por idade:");
								Aluno.imprimirOrdenadoPorIdade(listaAluno);
								break;
							case 4:
								// Delete
								listaAluno.forEach(a -> a.imprimir());
								System.out.println("\n* Selecione (pela matrícula) o aluno que deseja deletar:");
								System.out.print("=> ");
								int selecionarAluno2 = Principal.scan.nextInt();
								listaAluno.remove(getAluno(listaAluno, selecionarAluno2));
								break;
							case 5:
								//UpDate
								Usuario.alterarDados(logado);
								break;	
							case 0:
								opcao2 = 0;
								break;
							default:
								System.out.println("X Opção Inválida! X");
								break;
							}
						} while (opcao2 != 0);
						break;
					}

			case 2:
				//Create
				listaUsuario.add(Usuario.cadastro(listaUsuario,listaAluno));
				break;

			case 0:
				System.out.println("\n\t** Obrigado, volte sempre! **");
				opcao = 0;
				break;

			default:
				System.out.println("X Opção Inválida! X");
				break;
			}

		} while (opcao != 0);

	}
	
	public static void login(List<Usuario> listaUsuario) {
		boolean tentativaLogin = false;
		System.out.println("\n\t** LOGIN **");
		do {
			System.out.println("----------------------------------------------");
			System.out.println("* Email");
			System.out.print("> ");
			String email = Principal.scan.next();
			System.out.println("* Senha");
			System.out.print("> ");
			String senha = Principal.scan.next();
			System.out.println("----------------------------------------------");
			if (listaUsuario.size() == 0) {
				System.out.println("\tX Nenhuma conta cadastrada! X");
				break;
			}
			
			for (Usuario usuario : listaUsuario) {
					if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
							System.out.println("\t✓ Logado com Sucesso! ✓");
							logado = usuario;
							tentativaLogin = true;
							break;
					} 
			} 
			if (tentativaLogin == false) {
				System.out.println("\tX Email ou Senha Incorreta! X");
			}
		} while (tentativaLogin == false);
		
	}
	
	public static Aluno getAluno(List<Aluno> listaAluno, Integer matricula) {
		return listaAluno.stream().
				filter(a -> a.getMatricula() == matricula).findFirst().orElse(null);
	}

}
