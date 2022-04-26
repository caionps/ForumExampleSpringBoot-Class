package br.com.alura.forum.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

@Service
public class TopicoFormService {

	@Autowired
	private CursoRepository cursorepository;
	
	public Topico converter(TopicoForm topicoForm) {
		Curso curso = this.cursorepository.findByNome(topicoForm.getNomeCurso());
		return new Topico(topicoForm.getTitulo(), topicoForm.getMensagem(), curso);
	}
}
