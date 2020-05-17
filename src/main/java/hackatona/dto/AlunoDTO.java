package hackatona.dto;

import hackatona.model.Time;

public class AlunoDTO {

	private Long id;

	private String matricula;

	private String sugestao;

	private String curso;

	private Time time;

	private String id_curso;

	private String nome;

	public AlunoDTO(String matricula, String sugestao, String curso, String id_curso, String nome) {
		super();
		this.matricula = matricula;
		this.sugestao = sugestao;
		this.curso = curso;
		this.id_curso = id_curso;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getId_curso() {
		return id_curso;
	}

	public void setId_curso(String id_curso) {
		this.id_curso = id_curso;
	}
}
