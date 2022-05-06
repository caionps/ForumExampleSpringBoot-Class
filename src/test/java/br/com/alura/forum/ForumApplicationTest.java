package br.com.alura.forum;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.service.TopicoService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumApplicationTest {
	
	@InjectMocks
	private TopicoService topicoService;
	
	@Mock
	private TopicoRepository topicoRepository;
	
	@Mock
	private CursoRepository cursorepository;

	
	private TopicoDto topicoDto;
	
	private Topico topico;
	
	private Curso curso;
	
	
	@Before
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveriaListarTodosTopicos() {
		Mockito.when(topicoService.lista(Mockito.anyString())).thenReturn(startTopico());
		Assertions.assertNotNull(topicoDto);
	}

	private List<TopicoDto> startTopico() {
		topico = new Topico("Erro no codigo", "Mensagem teste", curso);
		topicoDto = new TopicoDto(topico);
		return (List<TopicoDto>) topicoDto;
	}
}
