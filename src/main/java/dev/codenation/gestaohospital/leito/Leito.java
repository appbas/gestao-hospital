package dev.codenation.gestaohospital.leito;

import dev.codenation.gestaohospital.paciente.Paciente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

@Document(collection = "leitos")
public class Leito {

    @Id
    private int id;
    private TipoAcomodacaoEnum tipoAcomodacao;
    private Paciente paciente;
    private Date dataEntrada;
    private Date dataSaida;

    public Leito(){}

    public int getId() {
        return id;
    }

    public TipoAcomodacaoEnum getTipoAcomodacao() {
        return tipoAcomodacao;
    }

    public void setTipoAcomodacao(TipoAcomodacaoEnum tipoAcomodacao) {
        this.tipoAcomodacao = tipoAcomodacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
}
