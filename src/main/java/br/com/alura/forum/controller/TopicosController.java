package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.service.TopicoDtoService;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoDtoService topicoDtoService;
	
	
	
	@GetMapping
	
	 public List<TopicoDto> lista(String nomeCurso) { 
		return topicoDtoService.lista(nomeCurso);
	 }
	 
	
	@PostMapping("/cadastrar")
	public TopicoDto cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		/*
		 * Topico topico = form.converter(cursoRepository);
		 * topicoRepository.save(topico);
		 */
		/*
		 * URI uri =
		 * uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		 * return ResponseEntity.created(uri).body(new TopicoDto(topico));
		 */
		return topicoDtoService.cadastrar(form);
	}
	
	@GetMapping("/{id}")
	public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
			
		return topicoDtoService.detalhar(id);
	}
		
	

}
