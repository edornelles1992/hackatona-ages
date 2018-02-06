package br.com.eduardodornelles.infogoods.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_MENSAGEM")
public class MessagesConfiguration{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String cod_mensagem;

	private String mensagem;

	public String getCod_mensagem() {
		return cod_mensagem;
	}

	public void setCod_mensagem(String cod_mensagem) {
		this.cod_mensagem = cod_mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
