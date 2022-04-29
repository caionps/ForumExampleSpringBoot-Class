package br.com.alura.forum.service;



import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@Service
public class TopicoFormService {
	
	@Autowired
	private CursoRepository cursorepository;
	
	@Autowired
	private TopicoRepository topicoRepository;
	
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
