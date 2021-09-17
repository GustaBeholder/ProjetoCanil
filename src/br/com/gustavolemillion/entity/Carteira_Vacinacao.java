package br.com.gustavolemillion.entity;

import java.util.Calendar;

public class Carteira_Vacinacao {

    private int idCachorro;
    private int idVacina;
    private Calendar dataAplicacao;

    public int getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(int idCachorro) {
        this.idCachorro = idCachorro;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public Calendar getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Calendar dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
