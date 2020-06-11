package hackatona.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_time")
	private Integer idTime;

	private String nome;
	
	public Time() {
		
	}

	public Time(Integer id, String nome) {
		super();
		this.idTime = id;
		this.nome = nome;
	}

	public Integer getId() {
		return idTime;
	}

	public void setId(Integer id) {
		this.idTime = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
