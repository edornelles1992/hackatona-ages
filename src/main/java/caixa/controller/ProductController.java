package caixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import caixa.service.ProductService;

@RestController
@RequestMapping("/api/produtos")
public class ProductController extends AbstractController {

	@Autowired
	private ProductService productService;
}
