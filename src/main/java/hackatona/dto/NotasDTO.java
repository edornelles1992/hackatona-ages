package hackatona.dto;

public class NotasDTO {

	private Integer software = 0;

	private Integer processo = 0;

	private Integer pitch = 0;

	private Integer inovacao = 0;

	private Integer total = 0;

	private Integer avaliacoes = 0;

	private TimeDTO timeDTO;

	public NotasDTO() {

	}

	public TimeDTO getTimeDTO() {
		return timeDTO;
	}

	public void setTimeDTO(TimeDTO timeDTO) {
		this.timeDTO = timeDTO;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Integer avaliacoes) {
		this.avaliacoes = avaliacoes;
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

}
