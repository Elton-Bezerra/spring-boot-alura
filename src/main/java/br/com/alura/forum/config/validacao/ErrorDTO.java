package br.com.alura.forum.config.validacao;

public class ErrorDTO {

    private String campo;
    private String erro;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public ErrorDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
