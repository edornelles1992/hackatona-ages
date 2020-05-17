package hackatona.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Cursos {

	ENGENHARIA_DE_SOFTWARE("111", "Engenharia de Software"),
	CIENCIA_DA_COMPUTACAO("222", "Ciência da Computação"),
	SISTEMAS_DE_INFORMACAO("333", "Sistemas de Informação"),
	ENGENHARIA_DE_COMPUTACAO("444", "Engenharia de Computação");

	private String valor;
	private String descricao;

	Cursos(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static List<Cursos> list(){
		return new ArrayList<Cursos>(Arrays.asList(Cursos.values()));
	}
}
