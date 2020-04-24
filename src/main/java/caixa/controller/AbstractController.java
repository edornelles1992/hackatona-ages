package caixa.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import com.totvs.mobile.backend.commons.security.spring.AuthenticationFilter;
//import com.totvs.mobile.backend.commons.security.spring.AuthenticationPrincipal;
//import com.totvs.mobile.backend.commons.utility.GeneralUtils;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Abstract controller implementing default
 * methods for some actions.
 */
public class AbstractController {

	/**
	 * Form a ResponseEnity based on
	 * a body and a http status
	 *
	 * @param body
	 *            response body
	 * @param status
	 *            response status code
	 * @return {@link ResponseEntity} to be returned
	 *         to the client.
	 */
	public <T> ResponseEntity<T> response(final T body, final HttpStatus status) {
		return new ResponseEntity<>(body, status);
	}

	/**
	 * Form a ResponseEnity based on
	 * a body and a http status
	 *
	 * @param body
	 *            response body
	 * @param status
	 *            response status code
	 * @return {@link ResponseEntity} to be returned
	 *         to the client.
	 * @throws UnsupportedEncodingException
	 */
//	public <T> ResponseEntity<T> response(final T body, final HttpStatus status,
//			final AuthenticationPrincipal loggedUser) throws UnsupportedEncodingException {
//
//		if (GeneralUtils.isEmpty(loggedUser) || GeneralUtils.isEmpty(loggedUser.getSession()) || !loggedUser
//				.getSession().isValid()) {
//			return response(body, status);
//		}
//
//		final String token = generateWebToken(loggedUser);
//		final HttpHeaders headers = new HttpHeaders();
//
//		headers.set(AuthenticationFilter.AUTHORIZATION_HEADER, AuthenticationFilter.AUTHORIZATION_PREFIX + " " + token);
//
//		return new ResponseEntity<>(body, headers, status);
//	}

	/**
	 * Generate a web token based on the authenticated user.
	 * 
	 * @param loggedUser
	 *            {@link AuthenticationPrincipal}.
	 * @return a string representing a web token
	 * @throws UnsupportedEncodingException
	 *             in case of a unsupported encoding for the secret.
	 */
//	private String generateWebToken(final AuthenticationPrincipal loggedUser) throws UnsupportedEncodingException {
//		
//		return Jwts.builder()
//				.signWith(SignatureAlgorithm.HS256, loggedUser.getSecurityConfiguration().getSigningKey().getBytes(
//						"UTF-8"))
//				.claim("session", loggedUser.getSession().getSessionMap())
//				.claim(AuthenticationFilter.X_AUTH_TOKEN, loggedUser.getSession().getToken())
//				.claim(AuthenticationFilter.X_FINGER_TOKEN, loggedUser.getSession().get("fingerprintToken"))
//				.claim(AuthenticationFilter.X_OPER_TOKEN, loggedUser.getSession().getOperationToken())
//				.compact();
//	}
}
