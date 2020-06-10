package hackatona.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	private Integer software;

	private Integer processo;

	private Integer pitch;

	private Integer inovacao;

	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Time time;

	public Avaliacao(User user, Time time) {
		super();
		this.user = user;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSoftware() {
		return software;
	}

	public void setSoftware(Integer software) {
		this.software = software;
	}

	public Integer getProcesso() {
		return processo;
	}

	public void setProcesso(Integer processo) {
		this.processo = processo;
	}

	public Integer getPitch() {
		return pitch;
	}

	public void setPitch(Integer pitch) {
		this.pitch = pitch;
	}

	public Integer getInovacao() {
		return inovacao;
	}

	public void setInovacao(Integer inovacao) {
		this.inovacao = inovacao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
