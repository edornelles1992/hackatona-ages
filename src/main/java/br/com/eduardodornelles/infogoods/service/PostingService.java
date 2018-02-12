package br.com.eduardodornelles.infogoods.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.dto.PostingDTO;
import br.com.eduardodornelles.infogoods.dto.ProductDTO;
import br.com.eduardodornelles.infogoods.dto.UserDTO;
import br.com.eduardodornelles.infogoods.entity.Posting;

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
		HttpResponseDTO response = new HttpResponseDTO();
		response.setSuccess(true);
		ArrayList<PostingDTO> postingsDTOs = new ArrayList<PostingDTO>();

		Collection<Posting> postings = postingDao.findAll();
		
		if (postings != null) {
			if (postings.size() > 0)
				postings = postings.stream().sorted(Comparator.comparing(Posting::getCurtidas).reversed())
						.collect(Collectors.toList());
			
			postingsDTOs = convertPostingsListToDTOs(postings);
		}			
		
		response.addContent("postings", postingsDTOs);
		return response;
	}
	
	/**
	 * method to pass a list of entity posts to a 
	 * Arraylist of DTO posts
	 * @param postings
	 * @return
	 */
	private ArrayList<PostingDTO> convertPostingsListToDTOs(Collection<Posting> postings) {
		ArrayList<PostingDTO> postingsDTOs = new ArrayList<PostingDTO>(); 		
		
		for (Posting post: postings) {		
			PostingDTO postDTO = modelMapper.map(post, PostingDTO.class);
			postingsDTOs.add(postDTO);
		
		}		
		return postingsDTOs;
	}

}
