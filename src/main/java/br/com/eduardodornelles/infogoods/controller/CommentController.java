package br.com.eduardodornelles.infogoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardodornelles.infogoods.service.CommentService;

@RestController
@RequestMapping("/api/comentarios")
public class CommentController extends AbstractController {

	@Autowired
	private CommentService commentService;
}
