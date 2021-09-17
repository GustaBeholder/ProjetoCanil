package br.com.gustavolemillion.entity;

public class Prescricao_Alimentacao {

    private String quatidade;
    private int idAlimentacao;
    private int idCachorro;

    public String getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(String quatidade) {
        this.quatidade = quatidade;
    }

    public int getIdAlimentacao() {
        return idAlimentacao;
    }

    public void setIdAlimentacao(int idAlimentacao) {
        this.idAlimentacao = idAlimentacao;
    }

    public int getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(int idCachorro) {
        this.idCachorro = idCachorro;
    }
}
