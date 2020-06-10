package hackatona.service.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hackatona.domain.Cursos;
import hackatona.dto.AlunoDTO;

@Service
public class AlunoServiceConsumer {
	
	private static List<AlunoDTO> alunos;
	
	static {
		alunos = new ArrayList<>();
		alunos.add(new AlunoDTO("11111111", "Time A", Cursos.CIENCIA_DA_COMPUTACAO.getDescricao(), Cursos.CIENCIA_DA_COMPUTACAO.getValor(), "João da Silva"));
		alunos.add(new AlunoDTO("22222222", "Time B", Cursos.ENGENHARIA_DE_SOFTWARE.getDescricao(), Cursos.ENGENHARIA_DE_SOFTWARE.getValor(), "Maria Gomes"));
		alunos.add(new AlunoDTO("33333333", null, Cursos.SISTEMAS_DE_INFORMACAO.getDescricao(), Cursos.SISTEMAS_DE_INFORMACAO.getValor(), "Paulo Manuel Silva"));
		alunos.add(new AlunoDTO("44444444", "Time C", Cursos.ENGENHARIA_DE_COMPUTACAO.getDescricao(), Cursos.ENGENHARIA_DE_COMPUTACAO.getValor(), "Eduardo José Paulo"));
		alunos.add(new AlunoDTO("55555555", null, Cursos.ENGENHARIA_DE_COMPUTACAO.getDescricao(), Cursos.ENGENHARIA_DE_COMPUTACAO.getValor(), "Lucas Silva"));
		alunos.add(new AlunoDTO("66666666", "Time B", Cursos.ENGENHARIA_DE_SOFTWARE.getDescricao(), Cursos.ENGENHARIA_DE_SOFTWARE.getValor(), "Gustavo zé"));
		alunos.add(new AlunoDTO("77777777", "Time A", Cursos.ENGENHARIA_DE_SOFTWARE.getDescricao(), Cursos.ENGENHARIA_DE_SOFTWARE.getValor(), "João Abreu"));
		alunos.add(new AlunoDTO("88888888", null, Cursos.ENGENHARIA_DE_SOFTWARE.getDescricao(), Cursos.ENGENHARIA_DE_SOFTWARE.getValor(), "Gustavo zé"));
		alunos.add(new AlunoDTO("99999999", "Time C", Cursos.ENGENHARIA_DE_SOFTWARE.getDescricao(), Cursos.ENGENHARIA_DE_SOFTWARE.getValor(), "Paulo Paulera"));
	}

	public List<AlunoDTO> importarAlunos() {		
		return alunos;
	}

}
