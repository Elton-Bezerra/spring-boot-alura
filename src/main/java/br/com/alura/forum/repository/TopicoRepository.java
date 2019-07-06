package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNomeContains(String valor);


	@Query("SELECT t FROM Topico t where t.curso.nome = :curso")
	List<Topico> carregarPorNomeDoCurso(@Param("curso") String curso);
}
