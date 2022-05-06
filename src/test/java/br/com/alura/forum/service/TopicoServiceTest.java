package br.com.alura.forum.service;

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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TopicoServiceTest {
	
	@InjectMocks
	private TopicoService topicoService;
	
	@Mock
	private TopicoRepository topicoRepository;
	
	@Mock
	private CursoRepository cursorepository;

	@Mock
	private TopicoDto topicoDto;
	
	@Mock
	private Topico topico;
	
	private Curso curso;
	
	@Mock 
	private List<TopicoDto> lista;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveriaListarTodosTopicos() {
		Mockito.when(topicoService.lista("")).thenReturn(startTopico());
		Assert.assertNotNull(startTopico());
	}

	private List<TopicoDto> startTopico() {
		topico = new Topico("Erro no codigo", "Mensagem teste", curso);
		topicoDto = new TopicoDto(topico);
		return (List<TopicoDto>) topicoDto;
	}
}