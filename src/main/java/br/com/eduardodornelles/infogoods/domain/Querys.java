package br.com.eduardodornelles.infogoods.domain;

public interface Querys {

	public static final String FIND_POSTINGS_WITH_GIVEN_PRODUCT_NAME = "SELECT p FROM Posting p where p.produto.nome like %:searchTerm%";
}
