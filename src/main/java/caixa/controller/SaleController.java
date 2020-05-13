package caixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import caixa.dto.HttpResponseDTO;
import caixa.dto.PaymentDTO;
import caixa.dto.SaleDTO;
import caixa.service.SaleService;

@RestController
@RequestMapping("/api/venda")
public class SaleController extends AbstractController {

	@Autowired
	private SaleService saleService;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listProducts(SaleDTO dto) throws Exception {
		return super.response(saleService.registerSale(dto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pagamento", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listProducts(PaymentDTO dto) throws Exception {
		return super.response(saleService.makePayment(dto), HttpStatus.OK);
	}
}
