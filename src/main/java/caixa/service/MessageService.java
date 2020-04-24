package caixa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caixa.dao.MessageDao;
import caixa.dto.MessageDTO;
import caixa.model.MessagesConfiguration;
import caixa.utility.GeneralUtils;

@Service
public class MessageService {

	@Autowired
	MessageDao messageDao;

	/**
	 * Find a message given it's code.
	 * 
	 * @param code {@link String}
	 * @return {@link MessageDTO}
	 */
	public MessageDTO getMessageDTOByCode(final String code) {
		final MessagesConfiguration messageConfiguration;

		if (code == null) {
			return null;
		}

		messageConfiguration = this.messageDao.findOne(code);

		if (messageConfiguration == null) {
			return null;
		}

		return new MessageDTO(messageConfiguration.getMensagem(), code);
	}

	/**
	 * Format a message containing '%s' bindings.
	 * 
	 * @param message {@link MessageDTO}.
	 * @param parameters {@link String}[]
	 * @return {@link MessageDTO}.
	 */
	public static MessageDTO format(MessageDTO message, String... parameters) {

		if (GeneralUtils.isEmpty(message) || GeneralUtils.isEmpty(parameters)) {
			return null;
		} else {
			return new MessageDTO(String.format(message.getMessage(), (Object[]) parameters), message.getCode());
		}
	}

}
