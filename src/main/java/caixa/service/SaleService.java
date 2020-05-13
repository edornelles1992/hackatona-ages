package caixa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caixa.dao.SaleDao;
import caixa.domain.PaymentType;
import caixa.dto.HttpResponseDTO;
import caixa.dto.PaymentDTO;
import caixa.dto.SaleDTO;
import caixa.model.Sale;
import caixa.utility.GeneralUtils;

@Service
public class SaleService extends AbstractService {

	@Autowired
	private SaleDao saleDao;

	public HttpResponseDTO registerSale(SaleDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "registerSale");
		HttpResponseDTO response = new HttpResponseDTO();

		if (dto != null) {
			saleDao.save(modelMapper.map(dto, Sale.class));
			response.setSuccess(true);
			response.addContent(dto);
			response.addMessage("venda criada com sucesso");
		} else {
			response.setSuccess(false);
			response.addMessage("Erro ao criar a venda");
		}

		return response;
	}

	public HttpResponseDTO makePayment(PaymentDTO dto) throws Exception {
		this.LogServiceConsumed(this.getClassName(), "makePayment");
		HttpResponseDTO response = new HttpResponseDTO();

		if (dto != null) {
			if (dto.getPaymentType().equals(PaymentType.DINHEIRO)) {
				GeneralUtils.pagamentoDinheiro(dto);
			} else { // cartão
				GeneralUtils.pagamentoDinheiro(dto);
			}

			response.setSuccess(true);
			response.addMessage("Pagamento Realizado com sucesso");
		} else {
			response.setSuccess(false);
			response.addMessage("Erro ao criar a venda");
		}

		return response;
	}

}
