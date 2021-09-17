package br.com.gustavolemillion.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;


public class Cliente {
    private int id;
    private String nomePessoa;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String cep;
    private String rua;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente() {
    }

    public Cliente(String nomePessoa, String cpf, String rg, Date dataNascimento, String cep, String rua, String numeroEndereco, String bairro, String cidade, String estado) {
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.rua = rua;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    private List<Telefone_Cliente> telefone_cliente = new ArrayList<Telefone_Cliente>();

    public List<Telefone_Cliente> getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(List<Telefone_Cliente> telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
