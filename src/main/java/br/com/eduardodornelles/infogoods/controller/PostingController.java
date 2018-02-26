package br.com.eduardodornelles.infogoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.service.PostingService;

@RestController
@RequestMapping("/api/postagens")
public class PostingController extends AbstractController {

	@Autowired
	private PostingService postingService;
	
	/**
	 * RESTful method that return the mosts likeds posts.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findMostLikedPosts() throws Exception{		
		return super.response(postingService.getMostLikedPosts(), HttpStatus.OK);
	}
	
	/**
	 * RESTful method that return the posts that corresponding
	 * with the searchTerm passed by parameter.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findPostsByTerm(@RequestParam(value = "searchTerm") String searchTerm) throws Exception{		
		return super.response(postingService.getPostsByTerm(searchTerm), HttpStatus.OK);
	}
}
