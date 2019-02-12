
package iface.negocio;

import java.util.ArrayList;

public class Comunidade {
	private String nome;
	private String descricao;
	private Usuario proprietario;
	private ArrayList<Usuario> membros = new ArrayList<>();
	
	public Comunidade() {
		
	}
	
	public Comunidade(String nome, String descricao, Usuario proprietario) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.proprietario = proprietario;
	}
	
	public String toString() {
		
		return "Nome: "+nome+"\n" +
			   "Descricao: "+descricao+"\n" ;	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public ArrayList<Usuario> getMembros() {
		return membros;
	}

	public void setMembros(ArrayList<Usuario> membros) {
		this.membros = membros;
	}
}
