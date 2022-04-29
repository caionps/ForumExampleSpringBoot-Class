package br.com.alura.forum.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.service.TopicoDtoService;
import br.com.alura.forum.service.TopicoFormService;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoDtoService topicoDtoService;
	
	@Autowired
	private TopicoFormService topicoFormService;
	
	
	@GetMapping
	
	 public List<TopicoDto> lista(String nomeCurso) { 
		return topicoDtoService.lista(nomeCurso);
	 }
	 
	
	@PostMapping("/cadastrar")
	@Transactional
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
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
		
		return topicoDtoService.detalhar(id);
	}
		
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
		
				
		
		return topicoFormService.atualizar(id, form);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		return topicoFormService.remover(id);
	}
	
}
