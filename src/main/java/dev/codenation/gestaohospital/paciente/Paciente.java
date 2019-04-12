package dev.codenation.gestaohospital.paciente;

import dev.codenation.gestaohospital.padrao.BaseDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Document(collection = "pacientes")
public class Paciente extends BaseDocument<String> {
    @Id
    private String id;
    private String cpf;
    private String nomeCompleto;
    private Genero genero;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    public Paciente(){}

    public Paciente(String cpf, String nomeCompleto, Date dataNascimento, Genero genero){
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
    	return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String CPF) {
        this.cpf = CPF;
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

}
