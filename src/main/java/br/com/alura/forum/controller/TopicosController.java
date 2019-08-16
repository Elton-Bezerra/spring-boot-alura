package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Optional;

import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

import javax.validation.Valid;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository repository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    @Cacheable(value = "listaDeTopicos")
    public ResponseEntity<Page<TopicoDTO>> lista(
            @RequestParam(name = "curso", required = false) String curso,
            @PageableDefault(
                sort="id", direction = Sort.Direction.ASC,
                page = 0,
                size = 10
            ) Pageable paginacao) {

        if (curso != null && !"".equals(curso)) {
            Page<Topico> topicos = repository.findByCursoNome(curso, paginacao);
            return ResponseEntity.ok(TopicoDTO.converter(topicos));
        } else {
            Page<Topico> topicos = repository.findAll(paginacao);
            return ResponseEntity.ok(TopicoDTO.converter(topicos));
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico t = form.converter(cursoRepository);
        t = repository.save(t);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(t.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(t));
    }

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesTopicoDTO> detalhar(@PathVariable("id") Long id) {
		Optional<Topico> topico = repository.findById(id);
		if(topico.isPresent()) {
			DetalhesTopicoDTO dto = new DetalhesTopicoDTO(topico.get());
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();

	}

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable("id") Long id,
            @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent()) {
            Topico tpc = form.atualizar(id, repository);
            return ResponseEntity.ok(new TopicoDTO(tpc));
        }
        return ResponseEntity.notFound().build();

    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable("id")Long id) {
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent()) {
            repository.delete(topico.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
