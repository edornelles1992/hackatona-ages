package caixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import caixa.dto.HttpResponseDTO;
import caixa.service.CashierService;

@RestController
@RequestMapping("/api/caixa")
public class CashierController extends AbstractController {

	@Autowired
	private CashierService cashierService;
	
	/**
	 * Registrar novo usuário.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/abrir", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> openCashier() throws Exception {
		return super.response(cashierService.openCashier(), HttpStatus.OK);
	}
	
	/**
	 * Registrar novo usuário.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/fechar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> closeCashier() throws Exception {
		return super.response(cashierService.closeCashier(), HttpStatus.OK);
	}
	
}
