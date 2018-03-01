package br.com.eduardodornelles.infogoods.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.dto.PostingDTO;
import br.com.eduardodornelles.infogoods.entity.Posting;
import br.com.eduardodornelles.infogoods.utility.ValidationUtils;

/**
 * class that have method related to services concerning Postings
 * 
 * @author Eduardo Dornelles
 */
@Service
public class PostingService extends AbstractService {	

	/**
	 * method that return the most likeds product posts on databases
	 * 
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO getMostLikedPosts() {			
		this.LogServiceConsumed(this.getClassName(), "getMostLikedPosts" );
			
		HttpResponseDTO response = new HttpResponseDTO();
		response.setSuccess(true);
		ArrayList<PostingDTO> postingsDTOs = new ArrayList<PostingDTO>();

		Collection<Posting> postings = postingDao.findAll();

		if (postings != null) {
			if (postings.size() > 0)
				postings = sortByLikes(postings);
			postingsDTOs = convertPostingsListToDTOs(postings);
		}

		response.addContent("postings", postingsDTOs);
		return response;
	}

	/**
	 * method to pass a list of entity posts to a Arraylist of DTO posts
	 * 
	 * @param postings
	 * @return
	 */
	private ArrayList<PostingDTO> convertPostingsListToDTOs(final Collection<Posting> postings) {
		ArrayList<PostingDTO> postingsDTOs = new ArrayList<PostingDTO>();

		for (Posting post : postings) {
			PostingDTO postDTO = modelMapper.map(post, PostingDTO.class);
			postingsDTOs.add(postDTO);

		}
		return postingsDTOs;
	}

	/**
	 * method that receive a collections of postings and sort by quantity of likes
	 * likes
	 * 
	 * @param postings
	 * @return
	 */
	private Collection<Posting> sortByLikes(Collection<Posting> postings) {
		postings = postings.stream().sorted(Comparator.comparing(Posting::getCurtidas).reversed())
				.collect(Collectors.toList());
		return postings;
	}

	/**
	 * method that return a lists of posts that the searchTerm corresponding with
	 * the product name of the posts. return a empty list if no postings was found
	 * 
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO getPostsByTerm(final String searchTerm) {
		this.LogServiceConsumed(this.getClassName(), "getPostsByTerm");		
		HttpResponseDTO response = new HttpResponseDTO();
		response.setSuccess(true);
		ArrayList<PostingDTO> postingsDTOs = new ArrayList<PostingDTO>();

		Collection<Posting> postings = postingDao.findBySearchTermInProductName(searchTerm);

		if (postings.size() > 1)
			postings = sortByLikes(postings);

		postingsDTOs = convertPostingsListToDTOs(postings);
		response.addContent("postings", postingsDTOs);

		return response;
	}

	/**
	 * method to create a post. may launch an exception
	 * if some parameter in object is null the validate method 
	 * validateEmptyPostFields throws an NullPointerException.
	 * @param postingDTO
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO addPost(final PostingDTO postingDTO) {
		this.LogServiceConsumed(this.getClassName(), "addPost");		
		HttpResponseDTO response = new HttpResponseDTO();
		response.setSuccess(true);

		try {			
			ValidationUtils.validateEmptyPostFields(postingDTO);
		
			

		} catch (NullPointerException e) {
			response.addMessage("Parametros recebidos são inválidos.");
			response.setSuccess(false);
		} catch (Exception e) {
			response.addMessage("Erro Inesperado ao criar Postagem.");
			response.setSuccess(false);
		}

		return response;
	}

}
