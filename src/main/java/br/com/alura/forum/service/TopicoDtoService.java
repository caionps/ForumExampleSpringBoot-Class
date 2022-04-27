package br.com.alura.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@Service
public class TopicoDtoService {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TopicoFormService topicoFormService;

	public List<TopicoDto> lista(String nomeCurso) { 
		
		if (nomeCurso == null) {
		List<Topico> topicos = topicoRepository.findAll(); 
		return TopicoDto.converter(topicos); 
		} else { List<Topico> topicos =	topicoRepository.findByCursoNome(nomeCurso); 
		return TopicoDto.converter(topicos); 
		} 
	}
	
	public TopicoDto cadastrar(TopicoForm form) {
		Topico topico = topicoFormService.converter(form);
		topicoRepository.save(topico);
		return new TopicoDto(topico);
	}
	
	public TopicoDto detalhar(@PathVariable Long id) {
		
		Topico topico = topicoRepository.getOne(id);
		return new TopicoDto(topico);
	}
}
