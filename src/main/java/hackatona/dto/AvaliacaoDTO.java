package hackatona.dto;

public class AvaliacaoDTO {

	private Integer id;

	private Integer software;

	private Integer processo;

	private Integer pitch;

	private Integer inovacao;

	private UserDTO user;

	private TimeDTO time;
	
	public AvaliacaoDTO() {
		
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public TimeDTO getTime() {
		return time;
	}

	public void setTime(TimeDTO time) {
		this.time = time;
	}

}
