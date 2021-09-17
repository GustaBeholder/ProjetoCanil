package br.com.gustavolemillion.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Veterinario {

    private int id;
    private String nomePessoa;
    private String cpf;
    private String rg;
    private Calendar dataNascimento;
    private String cep;
    private String rua;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String crmv;

    private List<Telefone_Veterinario> telefone_veterinario = new ArrayList<Telefone_Veterinario>();

    public List<Telefone_Veterinario> getTelefone_veterinario() {
        return telefone_veterinario;
    }

    public void setTelefone_veterinario(List<Telefone_Veterinario> telefone_veterinario) {
        this.telefone_veterinario = telefone_veterinario;
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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
}
