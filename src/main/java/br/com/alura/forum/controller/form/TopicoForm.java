package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {

    @NotEmpty
    @Length(min = 5, max = 30)
    private String titulo;
    @NotEmpty
    @Length(min=1, max=255)
    private String mensagem;
    @NotEmpty
    @Length(min=3, max=30)
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository repository) {

        Topico t = new Topico(this.titulo, this.mensagem, repository.findFirstByNome(this.nomeCurso));
        t.setMensagem(this.mensagem);
        t.setTitulo(this.titulo);
        return t;
    }
}
