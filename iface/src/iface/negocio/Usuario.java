package iface.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private String login;
	private String nome;
	private String senha;
	private ArrayList<Usuario> amigos = new ArrayList<>();
	private ArrayList<Usuario> solicitacoes = new ArrayList<>();	
	private ArrayList<Comunidade> comunidades = new ArrayList<Comunidade>();
	private ArrayList<Mensagem> mensagensRecebidas = new ArrayList<>();
	private ArrayList<Mensagem> mensagensEnviadas = new ArrayList<>();
	private Map<String,String> novosAtributos = new HashMap<>();
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String nome, String senha) {
		super();
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}

	@Override
	public String toString() {
		
		String outros = "";
		for (Map.Entry<String,String> atributo : novosAtributos.entrySet()) {
			outros = outros.concat("\n"+atributo.getKey()+": "+atributo.getValue());
		}
		
		return "Login: " + login + "\nNome: " + nome + outros +
				"\nNº de amigos: "+ amigos.size() + "\nNº de comunidades: " +comunidades.size() +
				"\nNº de mensagens recebidas: "+mensagensRecebidas.size() +
				"\nNº de mensagens enviadas: "+mensagensEnviadas.size();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}

	public ArrayList<Usuario> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(ArrayList<Usuario> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public ArrayList<Comunidade> getComunidades() {
		return comunidades;
	}

	public void setComunidades(ArrayList<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public ArrayList<Mensagem> getMensagensRecebidas() {
		return mensagensRecebidas;
	}

	public void setMensagensRecebidas(ArrayList<Mensagem> mensagensRecebidas) {
		this.mensagensRecebidas = mensagensRecebidas;
	}

	public ArrayList<Mensagem> getMensagensEnviadas() {
		return mensagensEnviadas;
	}

	public void setMensagensEnviadas(ArrayList<Mensagem> mensagensEnviadas) {
		this.mensagensEnviadas = mensagensEnviadas;
	}

	public Map<String, String> getNovosAtributos() {
		return novosAtributos;
	}

	public void setNovosAtributos(Map<String, String> novosAtributos) {
		this.novosAtributos = novosAtributos;
	}


}
