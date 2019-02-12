package iface.database;

import java.util.ArrayList;

import iface.negocio.Comunidade;
import iface.negocio.Mensagem;
import iface.negocio.Usuario;

public class BD {
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<Comunidade> comunidades = new ArrayList<>();
	
	//Criacao de Conta
	public void criarConta(Usuario user) {
		usuarios.add(user);
		System.out.println("Usuario " + user.getLogin() + " adicionado!");
		
	}
	
	public Usuario buscarUsuario(String login) {
		Usuario user = null;
		for(Usuario u : usuarios) {
			if(u.getLogin().equals(login)) {
				return u;
			}
		}
		return user;
	}
	
	public Usuario buscarUsuarioNome(String nome) {
		Usuario user = null;
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome)) {
				return u;
			}
		}
		return user;
	}
		
	//Remover Perfil 
	public void removerConta(String login) {
		Usuario usuario = buscarUsuario(login);
		
		for(Usuario u: usuarios) {
			int size = u.getMensagensRecebidas().size();
			int sizeAmigos = u.getAmigos().size();
			ArrayList<Mensagem> removerMensagens = new ArrayList<>();
			
			for(int i=0; i<size; i++) {
				if(u.getMensagensRecebidas().get(i).getRemetente() == usuario) {
					removerMensagens.add(u.getMensagensRecebidas().get(i));
				}
			}
			
			for(Mensagem msg: removerMensagens) {
				u.getMensagensRecebidas().remove(msg);
			}	
			
			u.getAmigos().remove(usuario);
		}
		
		usuarios.remove(usuario);
		System.out.println("Usuario " + usuario.getNome() + " removido!");
	}
	
	//Recuperar Informacoes sobre um determinado Usuario
	public void recuperarInfo(String nome) {
		Usuario user = buscarUsuarioNome(nome);
		if(user!=null) {
			System.out.println(user);
		}
		else {
			System.out.println("Usuario nao foi encontrado!");
		}
	}
	public void recuperarInfoLogin(String login) {
		Usuario user = buscarUsuario(login);
		if(user!=null) {
			System.out.println(user);
		}
		else {
			System.out.println("Usuario nao foi encontrado!");
		}
	}
	
	//Criacao de comunidade
	public void criarComunidade(Comunidade com) {
		comunidades.add(com);
		System.out.println("Comunidade " + com.getNome() + " adicionada!");
	}
	
	public Comunidade buscarComunidade(String nome) {
		Comunidade com = null;
		for(Comunidade c: comunidades) {
			if(c.getNome().equals(nome)) {
				return c;
			}
		}
		return com;
	}
	
	//Buscar mensagens
	public void buscarMensagens(String nome,String usuarioLogado) {
		Usuario remetente = buscarUsuarioNome(nome);
		Usuario destinatario = buscarUsuario(usuarioLogado);
		
		if(remetente!=null) {
			ArrayList<Mensagem> msgRecebidas = destinatario.getMensagensRecebidas();
			int cont = 0;
			for(Mensagem msg : msgRecebidas) {
				if(msg.getRemetente().equals(remetente)) {
					System.out.println(msg+"\n");
					cont++;
				}
			}
			if(cont==0) {
				System.out.println("Voce nao recebeu nenhuma mensagem de "+remetente.getNome()+".");
			}
		}
		else {
			System.out.println("Usuario nao foi encontrado!");
		}
	}
}
