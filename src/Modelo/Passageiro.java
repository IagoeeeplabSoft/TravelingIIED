/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Iago
 */
public class Passageiro {
   // Nome	cpf	rg	telefone	IdDistino	DataSair	DataChegar;
private String nome;
private String cpf;
private  String rg;
private String telefone;
private String dataSair;
private String dataChegar;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataSair() {
        return dataSair;
    }

    public void setDataSair(String dataSair) {
        this.dataSair = dataSair;
    }

    public String getDataChegar() {
        return dataChegar;
    }

    public void setDataChegar(String dataChegar) {
        this.dataChegar = dataChegar;
    }
}
