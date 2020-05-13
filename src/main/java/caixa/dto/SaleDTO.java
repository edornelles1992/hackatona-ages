package caixa.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

	private List<ProductDTO> produtos;
	private LocalDateTime horarioVenda;

	public List<ProductDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProductDTO> produtos) {
		this.produtos = produtos;
	}

	public LocalDateTime getHorarioVenda() {
		return horarioVenda;
	}

	public void setHorarioVenda(LocalDateTime horarioVenda) {
		this.horarioVenda = horarioVenda;
	}

}
