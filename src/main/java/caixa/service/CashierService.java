package caixa.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caixa.dao.CashierDao;
import caixa.dto.CashierDTO;
import caixa.dto.HttpResponseDTO;
import caixa.model.Cashier;
import caixa.utility.GeneralUtils;

@Service
public class CashierService extends AbstractService {
	
	private static final Long CAIXA_ID = 1l;
	
	@Autowired
	private CashierDao cashierDao;

	public HttpResponseDTO openCashier() {
		this.LogServiceConsumed(this.getClassName(), "openCashier");
		HttpResponseDTO response = new HttpResponseDTO();
		Cashier cashier = cashierDao.findOne(CAIXA_ID);
		
		if (cashier != null) {
			cashier.setDataAbertura(LocalDateTime.now());
			CashierDTO cashierDTO = modelMapper.map(cashier, CashierDTO.class);	
			response.setSuccess(true);
			response.addContent(cashierDTO);
			response.addMessage("Caixa aberto com sucesso");
		} else {
			response.setSuccess(false);
			response.addMessage("Erro ao abrir o caixe");
		}	
		return response;
	}
	
	public HttpResponseDTO closeCashier() {
		this.LogServiceConsumed(this.getClassName(), "closeCashier");
		HttpResponseDTO response = new HttpResponseDTO();
		Cashier cashier = cashierDao.findOne(CAIXA_ID);
		
		if (cashier != null) {
			cashier.setDataFechamento(LocalDateTime.now());
			CashierDTO cashierDTO = modelMapper.map(cashier, CashierDTO.class);	
			response.setSuccess(true);
			GeneralUtils.totalizaValoresPagos();
			response.addContent(cashierDTO);
			response.addMessage("Caixa fechado com sucesso");
		} else {
			response.setSuccess(false);
			response.addMessage("Erro fechar abrir o caixe");
		}	
		return response;
	}



}
