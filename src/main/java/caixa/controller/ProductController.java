package caixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import caixa.dto.HttpResponseDTO;
import caixa.service.ProductService;

@RestController
@RequestMapping("/api/produtos")
public class ProductController extends AbstractController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listProducts() throws Exception {
		return super.response(productService.listProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> getProduct(Long id) throws Exception {
		return super.response(productService.getProduct(id), HttpStatus.OK);
	}	

}
