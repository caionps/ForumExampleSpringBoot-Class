package br.com.alura.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@Service
public class TopicoService {
	
	@Autowired
	private TopicoRepository topicoRepository;
		
	@Autowired
	private TopicoService topicoService;
	
	@Autowired
	private CursoRepository cursorepository;

	public List<TopicoDto> lista(String nomeCurso) { 
		
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll(); 
			return TopicoDto.converter(topicos); 
		} else { 
			List<Topico> topicos =	topicoRepository.findByCursoNome(nomeCurso); 
			return TopicoDto.converter(topicos); 
		} 
	}
	
	public TopicoDto cadastrar(TopicoForm form) {
		Topico topico = topicoService.converter(form);
		topicoRepository.save(topico);
		return new TopicoDto(topico);
	}
	
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(Long id) {
		
		Optional<Topico> topico = topicoRepository.findById(id);
		if (topico.isPresent()) {
		return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public Topico converter(TopicoForm topicoForm) {
		Curso curso = this.cursorepository.findByNome(topicoForm.getNomeCurso());
		return new Topico(topicoForm.getTitulo(), topicoForm.getMensagem(), curso);
	}
	
	public ResponseEntity<TopicoDto> atualizar(Long id, AtualizacaoTopicoForm form) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(form.getTitulo());
		topico.setMensagem(form.getMensagem());		
		
		return ResponseEntity.ok(new TopicoDto(topico));
	}
	
	public ResponseEntity<?> remover(Long id) {
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
