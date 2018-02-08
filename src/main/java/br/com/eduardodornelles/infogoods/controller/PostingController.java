package br.com.eduardodornelles.infogoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardodornelles.infogoods.service.PostingService;

@RestController
@RequestMapping("/api/postagens")
public class PostingController {

	@Autowired
	private PostingService postingService;
}
