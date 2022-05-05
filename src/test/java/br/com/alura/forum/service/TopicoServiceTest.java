package br.com.alura.forum.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.TopicoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicoServiceTest {

	@Autowired
	private TopicoService topicoService;
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Test
	public void deveriaListarTodosTopicos() {
		String nomeCurso = "";
		Assert.assertNotNull(topicoService.lista(nomeCurso));
		
		
	}
	
	@Test
	public void deveriaListarApenasTopicosDoNomeCurso() {
		String nomeCurso = "";
		Assert.assertNotNull(topicoService.lista(nomeCurso));
		//Assert.assert
		
	}
}
