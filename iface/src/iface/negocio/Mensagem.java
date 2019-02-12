package iface.negocio;

public class Mensagem {
	private Usuario remetente;
	private Usuario destinatario;
	private String conteudo;
	
	public Mensagem() {
		
	}
		
	@Override
	public String toString() {
		return "Enviado por: " + remetente.getNome() + "\nConteudo: " + conteudo;
	}

	public Mensagem(Usuario remetente, Usuario destinatario, String conteudo) {
		super();
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.conteudo = conteudo;
	}
	
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
