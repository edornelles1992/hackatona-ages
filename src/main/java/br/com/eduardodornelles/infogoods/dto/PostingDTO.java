package br.com.eduardodornelles.infogoods.dto;

import java.util.Date;

public class PostingDTO {
	
	private Long id;
		
	private UserDTO user;
		
	private ProductDTO produto;
	
	private Long curtidas;	
	
	private Date dataPublicacao;

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Long curtidas) {
		this.curtidas = curtidas;
	}

	public Long getId() {
		return id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public ProductDTO getProduto() {
		return produto;
	}

	public void setProduto(ProductDTO produto) {
		this.produto = produto;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
