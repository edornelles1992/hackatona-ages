package br.com.eduardodornelles.infogoods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends AbstractController {

	/**
	 * RESTful method that get all prizes availables that can be redemeed by the
	 * user *
	 *
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String Test()
			throws Exception {
		return "ACHOU";
	}
}
