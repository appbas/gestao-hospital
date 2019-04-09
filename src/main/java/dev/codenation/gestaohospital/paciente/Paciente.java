package dev.codenation.gestaohospital.paciente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codenation.gestaohospital.documents.BaseDocument;

import java.util.Date;

@Document(collection = "pacientes")
public class Paciente extends BaseDocument<String> {
    @Id
    private String id;
    private String CPF;
    private String nomeCompleto;
    private Genero genero;
    private Date dataNascimento;
    private Date dataEntradaHospital;
    private Date dataSaidaHospital;

    public Paciente(){}

    public Paciente(String cpf, String nomeCompleto, Date dataNascimento, Genero genero){
        this.CPF = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    
    @Override
    public String getId() {
    	return id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataEntradaHospital() {
        return dataEntradaHospital;
    }

    public void setDataEntradaHospital(Date dataEntradaHospital) {
        this.dataEntradaHospital = dataEntradaHospital;
    }

    public Date getDataSaidaHospital() {
        return dataSaidaHospital;
    }

    public void setDataSaidaHospital(Date dataSaidaHospital) {
        this.dataSaidaHospital = dataSaidaHospital;
    }
}
