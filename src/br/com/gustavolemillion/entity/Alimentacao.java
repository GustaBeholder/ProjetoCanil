package br.com.gustavolemillion.entity;

public class Alimentacao {

    private int idAlimentacao;
    private String marcaRacao;
    private String tipo;

    public int getIdAlimentacao() {
        return idAlimentacao;
    }

    public void setIdAlimentacao(int idAlimentacao) {
        this.idAlimentacao = idAlimentacao;
    }

    public String getMarcaRacao() {
        return marcaRacao;
    }

    public void setMarcaRacao(String marcaRacao) {
        this.marcaRacao = marcaRacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
