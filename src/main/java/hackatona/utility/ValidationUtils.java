package hackatona.utility;

import hackatona.domain.Messages;
import hackatona.domain.Parameters;
import hackatona.dto.AlunoDTO;
import hackatona.dto.AvaliacaoDTO;
import hackatona.model.User;

/**
 * class containing validations that are used through the application
 * 
 * @author Eduardo Dornelles
 *
 */
public class ValidationUtils {

	/**
	 * method to validate all fields and the object received when an user sign-up.
	 * 
	 * @param user
	 * @return
	 */
	public static String validateUserFields(User user) {
		if (user == null)
			return Messages.A003;
		if (user.getSenha() == null || user.getNome() == null)
			return Messages.A004;
		if (user.getSenha() == "" || user.getNome() == "")
			return Messages.A004;
		if (user.getSenha().length() < Parameters.PASSWORD_MIN_SIZE)
			return Messages.A006;
		return null;
	}

	public static String validarCadastroAluno(AlunoDTO dto) {
		if (dto == null)
			return "Aluno inválido.";
		if (dto.getNome() == null || dto.getNome().isEmpty())
			return "Nome inválido.";
		if (dto.getCurso() == null || dto.getCurso().isEmpty())
			return "Curso inválido.";
		if (dto.getId_curso() == null)
			return "ID do Curso inválido.";
		if (dto.getMatricula() == null || dto.getMatricula().isEmpty())
			return "Matrícula inválida.";
		return null;
	}

	public static String validarAvaliacao(AvaliacaoDTO dto) {
		if (dto == null)
			return "Avaliação inválida.";
		if (dto.getInovacao() == null || (dto.getInovacao() < 0 || dto.getInovacao() > 5))
			return "Critério Inovação invalido.";
		if (dto.getPitch() == null || (dto.getPitch() < 0 || dto.getPitch() > 5))
			return "Critério Pitch invalido.";
		if (dto.getProcesso() == null || (dto.getProcesso() < 0 || dto.getProcesso() > 5))
			return "Critério Processo invalido.";
		if (dto.getSoftware() == null || (dto.getSoftware() < 0 || dto.getSoftware() > 5))
			return "Critério Software invalido.";
		return null;
	}
}
