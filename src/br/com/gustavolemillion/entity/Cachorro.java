package br.com.gustavolemillion.entity;

import java.util.*;

public class Cachorro {

    private int id;
    private String nome;
    private String nomeMae;
    private String nomePadreador;
    private String numeroPedigree;
    private String numeroMicrochip;
    private String dono;
    private String tipo;
    private String sexo;

    private List<Carteira_Vacinacao> carteira_vacinacao = new ArrayList<Carteira_Vacinacao>();
    private List<Prescricao_Alimentacao> prescricao_alimentacao = new ArrayList<Prescricao_Alimentacao>();
    private List<Prescricao_Tratamento> prescricao_tratamento = new ArrayList<Prescricao_Tratamento>();

    public List<Carteira_Vacinacao> getCarteira_vacinacao() {
        return carteira_vacinacao;
    }

    public void setCarteira_vacinacao(List<Carteira_Vacinacao> carteira_vacinacao) {
        this.carteira_vacinacao = carteira_vacinacao;
    }

    public List<Prescricao_Alimentacao> getPrescricao_alimentacao() {
        return prescricao_alimentacao;
    }

    public void setPrescricao_alimentacao(List<Prescricao_Alimentacao> prescricao_alimentacao) {
        this.prescricao_alimentacao = prescricao_alimentacao;
    }

    public List<Prescricao_Tratamento> getPrescricao_tratamento() {
        return prescricao_tratamento;
    }

    public void setPrescricao_tratamento(List<Prescricao_Tratamento> prescricao_tratamento) {
        this.prescricao_tratamento = prescricao_tratamento;
    }

    public Cachorro() {
    }

    public Cachorro(String nome, String nomeMae, String nomePadreador, String numeroPedigree, String numeroMicrochip, String dono, String tipo, String sexo) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePadreador = nomePadreador;
        this.numeroPedigree = numeroPedigree;
        this.numeroMicrochip = numeroMicrochip;
        this.dono = dono;
        this.tipo = tipo;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePadreador() {
        return nomePadreador;
    }

    public void setNomePadreador(String nomePadreador) {
        this.nomePadreador = nomePadreador;
    }

    public String getNumeroPedigree() {
        return numeroPedigree;
    }

    public void setNumeroPedigree(String numeroPedigree) {
        this.numeroPedigree = numeroPedigree;
    }

    public String getNumeroMicrochip() {
        return numeroMicrochip;
    }

    public void setNumeroMicrochip(String numeroMicrochip) {
        this.numeroMicrochip = numeroMicrochip;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData(){
        return "nome: "+this.getNome()+" mãe: "+this.getNomeMae()+" Padreador: "+this.getNomePadreador();
    }
}
