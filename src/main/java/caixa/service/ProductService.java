package caixa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caixa.dao.ProductDao;
import caixa.dto.HttpResponseDTO;
import caixa.dto.ProductDTO;

/**
 * 
 * 
 * @author Eduardo Dornelles
 */
@Service
public class ProductService extends AbstractService {

	@Autowired
	private ProductDao productDao;

	public HttpResponseDTO listProducts() {
		this.LogServiceConsumed(this.getClassName(), "listProducts");
		HttpResponseDTO response = new HttpResponseDTO();

		List<ProductDTO> productsDtos = modelMapper.map(productDao.findAll(), List.class);
		response.setSuccess(true);
		response.addContent(productsDtos);
		return response;
	}

	public HttpResponseDTO getProduct(Long id) {
		this.LogServiceConsumed(this.getClassName(), "getProduct");
		HttpResponseDTO response = new HttpResponseDTO();

		ProductDTO productDto = modelMapper.map(productDao.findOne(id), ProductDTO.class);
		if (productDto != null) {
			response.setSuccess(true);
			response.addContent(productDto);
		} else {
			response.setSuccess(false);
			response.addMessage("Produto não encontrado!");
		}
		return response;
	}

}
