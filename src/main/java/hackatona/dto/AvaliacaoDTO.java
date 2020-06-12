package hackatona.dto;

public class AvaliacaoDTO {

	private Integer id;

	private Integer software;

	private Integer processo;

	private Integer pitch;

	private Integer inovacao;

	private AvaliadorDTO avaliador;

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

	public AvaliadorDTO getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(AvaliadorDTO avaliador) {
		this.avaliador = avaliador;
	}

	public TimeDTO getTime() {
		return time;
	}

	public void setTime(TimeDTO time) {
		this.time = time;
	}

}
