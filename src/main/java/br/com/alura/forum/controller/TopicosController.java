package br.com.alura.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {	

	@Autowired
	TopicoRepository repository;
	
	@RequestMapping("/topicos")
	public ResponseEntity<List<TopicoDTO>> lista(@RequestParam(name="curso", required=false) String curso) {
		List<Topico> topicos = new ArrayList<>(0);
		if(curso != null && !"".equals(curso)) {
			topicos = repository.findByCursoNomeContains(curso);
		} else {
			topicos = repository.findAll();
		}
		
		return ResponseEntity.ok(TopicoDTO.converter(topicos));
	}
	
	
}
