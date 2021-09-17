package br.com.gustavolemillion.entity;

import java.util.Calendar;

public class Prescricao_Tratamento {

    private Calendar dataInicio;
    private Calendar dataFim;
    private String justificativa;
    private int idCachoroo;
    private int idMedicamento;

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public int getIdCachoroo() {
        return idCachoroo;
    }

    public void setIdCachoroo(int idCachoroo) {
        this.idCachoroo = idCachoroo;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }
}
