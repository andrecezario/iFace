package iface.ui;

import java.util.ArrayList;
import java.util.Scanner;

import iface.database.BD;
import iface.negocio.Comunidade;
import iface.negocio.Mensagem;
import iface.negocio.Usuario;

public class Main {
	static BD banco = new BD();
	static String usuarioLogado;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("------------------------------\n"
					+ "	     "+"iFace\n"
					+ "------------------------------\n"
					+ "1 - Efetuar Login\n"
					+ "2 - Criar nova conta\n");
			int opcao = scanner.nextInt();
			
			if(opcao==1) {
				System.out.print("Login: ");
				String login = scanner.next();
				System.out.print("Senha: ");
				String senha = scanner.next();
				
				if(banco.buscarUsuario(login)!=null) {
					if(!banco.buscarUsuario(login).getSenha().equals(senha)) {
						System.out.println("Senha incorreta!");
					}
					else {
						System.out.println("Login efetuado!");
						usuarioLogado = login;
						entrar();
					}
				}
				else {
					System.out.println("Usuario nao existe!");
				}		
			}
			
			else if(opcao==2) {
				System.out.println("-------------------------- \n" +
						   "     "+"Criacao de conta" +
						   "\n--------------------------");
				String login;
				do {
					System.out.print("Login: ");
					login = scanner.next();
					
					if(banco.buscarUsuario(login)!=null) {
						System.out.println("Login já existe! Tente outro!");
					}
					
				} while(banco.buscarUsuario(login)!=null);
								
				System.out.print("Senha: ");
				String senha = scanner.next();
				scanner.nextLine();
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				
				Usuario usuario = new Usuario(login,nome,senha);
				banco.criarConta(usuario);
			}
		}
	}
	public static void entrar() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("------------------------------\n"
						+ "	  "+"Página inicial\n"
						+ "------------------------------\n" +
				           "1 - Meu perfil\n" +
				           "2 - Meus amigos\n" +
				           "3 - Minhas comunidades\n"+
				           "4 - Adicionar amigos\n" +
				           "5 - Solicitacoes de amizade\n" +
				           "6 - Enviar mensagem\n" +
				           "7 - Mensagens\n" +
				           "8 - Criar comunidade\n" +
				           "9 - Entrar numa comunidade\n" +
				           "10 - Buscar usuario\n" +
				           "11 - Editar perfil\n" +
				           "12 - Deletar conta\n" +
				           "0 - Sair\n");
				int opcao = scanner.nextInt();
				switch(opcao) {
					case 1:
						System.out.print("------------------------------\n"
								+ "	  "+"Meu perfil\n"
								+ "------------------------------\n");
						banco.recuperarInfoLogin(usuarioLogado);
						break;
						
					case 2:
						System.out.print("------------------------------\n"
								+ "	  "+"Meus amigos\n"
								+ "------------------------------\n");
						int cont = 1;
						if(banco.buscarUsuario(usuarioLogado).getAmigos().size()==0) {
							System.out.println("Nenhum amigo para mostrar.");
						}
						else {
							for(Usuario u : banco.buscarUsuario(usuarioLogado).getAmigos()) {
								System.out.printf("(%d) %s%n",cont++,u.getNome());
							}
						}
						break;
						
					case 3:
						System.out.print("------------------------------\n"
								+ "	 "+"Minhas comunidades\n"
								+ "------------------------------\n");
						int contd = 1;
						if(banco.buscarUsuario(usuarioLogado).getComunidades().size()==0) {
							System.out.println("Nenhuma comunidade para mostrar.");
						}
						else {
							for(Comunidade c : banco.buscarUsuario(usuarioLogado).getComunidades()) {
								System.out.printf("(%d) %s%n",contd++,c.getNome());
							}
						}
						break;
							
					case 4:
						System.out.print("------------------------------\n"
								+ "	 "+"Adicionar amigo\n"
								+ "------------------------------\n"
								+ "Digite o nome do usuario que deseja adicionar: ");
						
						scanner.nextLine();
						String nomeAmigo = scanner.nextLine();
						Usuario amigo = banco.buscarUsuarioNome(nomeAmigo);
						Usuario logado = banco.buscarUsuario(usuarioLogado);
						if(amigo!=null) {
							amigo.getSolicitacoes().add(logado);
							System.out.println("Solicitacao enviado com sucesso!");
						}
						else {
							System.out.println("Usuario nao foi encontrado!");
						}
						break;
						
					case 5:
						System.out.print("------------------------------\n"
								+ "	 "+"Solicitacoes de amizade\n"
								+ "------------------------------\n");
						int contador = 1;
						Usuario userLogado = banco.buscarUsuario(usuarioLogado);
						
						if(userLogado.getSolicitacoes().size()==0){
							System.out.println("Nenhuma solicitacao de amizade pendente.");
						}
						
						else {
							ArrayList<Usuario> removerSolicitacoes = new ArrayList<>();
							
							for(Usuario user: userLogado.getSolicitacoes()) {
								System.out.printf("(%d) %s%n",contador++,user.getNome());
								System.out.println("1 - Confirmar\n2 - Excluir");
								int alter = scanner.nextInt();
								if(alter==1) {
									userLogado.getAmigos().add(user);
									user.getAmigos().add(userLogado);
									//userLogado.getSolicitacoes().remove(user);
									removerSolicitacoes.add(user);
								}
								else if(alter==2) {
									//userLogado.getSolicitacoes().remove(user);
									removerSolicitacoes.add(user);
								}
							}
							
							for(Usuario user : removerSolicitacoes) {
								userLogado.getSolicitacoes().remove(user);
							}
						}
						break;
						
					case 6:
						System.out.print("------------------------------\n"
								+ "	  "+"Enviar mensagem\n"
								+ "------------------------------\n"
								+ "1 - Para um usuário\n"
								+ "2 - Para uma comunidade\n");
						int opc = scanner.nextInt();
						
						if(opc==1) {
							System.out.println("Digite o nome do usuario: ");
							scanner.nextLine();
							String nomeRemet = scanner.nextLine();
							Usuario remetente = banco.buscarUsuario(usuarioLogado);
							Usuario destinatario = banco.buscarUsuarioNome(nomeRemet);
							
							if(destinatario!=null) {
								System.out.println("Digite o conteudo da mensagem: ");
								//scanner.nextLine();
								String conteudo = scanner.nextLine();
								Mensagem msg = new Mensagem(remetente,destinatario,conteudo);
								remetente.getMensagensEnviadas().add(msg);
								destinatario.getMensagensRecebidas().add(msg);
								System.out.println("Mensagem enviada para usuario "+destinatario.getNome()+"!");
							}
							
							else {
								System.out.println("Usuario nao foi encontrado!");
							}
						}
						
						else if(opc==2) {
							System.out.println("Digite o nome da comunidade: ");
							scanner.nextLine();
							String nomeCom = scanner.nextLine();
							Comunidade com = banco.buscarComunidade(nomeCom);
							
							if(com!=null) {
								ArrayList<Usuario> membros = com.getMembros();
								
								System.out.println("Digite o conteudo da mensagem: ");
								//scanner.nextLine();
								String conteudo = scanner.nextLine();
								Usuario remetente = banco.buscarUsuario(usuarioLogado);
								
								for(Usuario destinatario: membros) {
									Mensagem msg = new Mensagem(remetente,destinatario,conteudo);
									remetente.getMensagensEnviadas().add(msg);
									destinatario.getMensagensRecebidas().add(msg);
								}
								System.out.println("Mensagem enviada para comunidade "+com.getNome()+"!");
							}
							else {
								System.out.println("Comunidade nao foi encontrada!");
							}
						}
						break;
					
					case 7:
						System.out.print("------------------------------\n"
								+ "	 "+"Mensagens\n"
								+ "------------------------------\n");
						System.out.println("Ver as mensagens recebidas do usuario: ");
						scanner.nextLine();
						String nomeUser = scanner.nextLine();
						
						banco.buscarMensagens(nomeUser, usuarioLogado);
						
						break;
						
					case 8:
						System.out.print("------------------------------\n"
								+ "	 "+"Criar comunidade\n"
								+ "------------------------------\n");
						String nomeCom;
						do {
							System.out.print("Nome: ");
							scanner.nextLine();
							nomeCom = scanner.nextLine();
							
							if(banco.buscarComunidade(nomeCom)!=null) {
								System.out.println("Nome já existe! Tente outro!");
							}
							
						} while(banco.buscarComunidade(nomeCom)!=null);
										
						System.out.print("Descricao: ");
						//scanner.nextLine();
						String descricao = scanner.nextLine();
						
						Comunidade com = new Comunidade(nomeCom,descricao,banco.buscarUsuario(usuarioLogado));
						banco.buscarUsuario(usuarioLogado).getComunidades().add(com);
						banco.criarComunidade(com);
						break;
					
					case 9:
						System.out.print("------------------------------\n"
								+ "	 "+"Adicionar membros\n"
								+ "------------------------------\n");
						System.out.println("Digite o nome da comunidade: ");
						scanner.nextLine();
						String nomeComu= scanner.nextLine();
						Comunidade comunidade = banco.buscarComunidade(nomeComu);
						
						if(comunidade!=null) {
							boolean membro = false;
							for(Usuario user : comunidade.getMembros()) {
								if(user.getLogin().equals(usuarioLogado)) {
									membro = true;
									break;
								}
							}
	
							if(!membro) {
								comunidade.getMembros().add(banco.buscarUsuario(usuarioLogado));
								System.out.println("Voce tornou-se membro desta comunidade!");
							}
							else {
								System.out.println("Voce ja pertence a esta comunidade.");
							}
						}
						
						else {
							System.out.println("Comunidade nao foi encontrada!");
						}
						
						break;
							
					case 10:
						System.out.print("------------------------------\n"
								+ "	  "+"Buscar usuario\n"
								+ "------------------------------\n"
								+ "Digite o nome do usuario para busca: ");
						scanner.nextLine();
						String nomeUsuario = scanner.nextLine();
						banco.recuperarInfo(nomeUsuario);
						break;
					case 11:
						System.out.print("------------------------------\n"
								+ "	  "+"Editar perfil\n"
								+ "------------------------------\n"
								+"1 - Nome\n"
								+"2 - Login\n"
								+"3 - Senha\n"
								+"4 - Novo atributo\n");
						int op = scanner.nextInt();
						switch(op) {
							case 1:
								System.out.println("Novo nome:");
								scanner.nextLine();
								String nome = scanner.nextLine();
								banco.buscarUsuario(usuarioLogado).setNome(nome);
								System.out.println("Atributo alterado!\n");
								break;
							case 2:
								String login;
								do {
									System.out.print("Novo login: ");
									login = scanner.next();
									
									if(banco.buscarUsuario(login)!=null) {
										System.out.println("Login já existe! Tente outro!");
									}
									
								} while(banco.buscarUsuario(login)!=null);
								banco.buscarUsuario(usuarioLogado).setLogin(login);
								usuarioLogado = login;
								System.out.println("Atributo alterado!\n");
								break;
							case 3:
								System.out.println("Nova senha");
								String senha = scanner.next();
								banco.buscarUsuario(usuarioLogado).setSenha(senha);
								System.out.println("Atributo alterado!\n");
								break;
							case 4:
								System.out.println("Digite o nome do atributo:");
								String chave = scanner.next();
								System.out.println("Digite o valor do atributo:");
								scanner.nextLine();
								String valor = scanner.nextLine();
								banco.buscarUsuario(usuarioLogado).getNovosAtributos().put(chave, valor);
								
								System.out.println("Atributo adicionado!");
								
						}
						
						break;
						
					case 12:
						System.out.print("------------------------------\n"
								+ "	 "+"Deletar conta\n"
								+ "------------------------------\n");
						System.out.println("Tem certeza que quer deletar sua conta? Todos os dados serao perdidos!\n"
								+ "1 - SIM\n"
								+ "2 - NAO");
						int deletar = scanner.nextInt();
						
						if(deletar==1) {
							banco.removerConta(usuarioLogado);
						}					
						
					case 0:
						main(null);
						break;					
					}
			} catch (Exception e) {
				System.out.println("Ocorreu algum um erro!");
			}
		}		
			
		
	}

}
