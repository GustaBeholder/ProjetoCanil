package br.com.gustavolemillion.entity;

import java.sql.Date;
import java.util.Calendar;

public class Reserva {

    private int idReserva;
    private int idCachorro;
    private int idCliente;
    private Date dataReserva;
    private String pagoReserva;
    private String pagoIntegral;
    private String entrega;
    private Double valorReserva;
    private Double valorIntegral;
    private String formaEntrega;
    private String formaPagamento;

    public Reserva() {
    }

    public Reserva(int idCachorro, int idCliente, Date dataReserva, String pagoReserva, String pagoIntegral, String entrega, Double valorReserva, Double valorIntegral, String formaEntrega, String formaPagamento) {
        this.idCachorro = idCachorro;
        this.idCliente = idCliente;
        this.dataReserva = dataReserva;
        this.pagoReserva = pagoReserva;
        this.pagoIntegral = pagoIntegral;
        this.entrega = entrega;
        this.valorReserva = valorReserva;
        this.valorIntegral = valorIntegral;
        this.formaEntrega = formaEntrega;
        this.formaPagamento = formaPagamento;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(int idCachorro) {
        this.idCachorro = idCachorro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getPagoReserva() {
        return pagoReserva;
    }

    public void setPagoReserva(String pagoReserva) {
        this.pagoReserva = pagoReserva;
    }

    public String getPagoIntegral() {
        return pagoIntegral;
    }

    public void setPagoIntegral(String pagoIntegral) {
        this.pagoIntegral = pagoIntegral;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public Double getValorIntegral() {
        return valorIntegral;
    }

    public void setValorIntegral(Double valorIntegral) {
        this.valorIntegral = valorIntegral;
    }

    public String getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(String formaEntrega) {
        this.formaEntrega = formaEntrega;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }



}
