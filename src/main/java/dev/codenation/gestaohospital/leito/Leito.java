package dev.codenation.gestaohospital.leito;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.codenation.gestaohospital.paciente.Paciente;

public class Leito {

	private TipoAcomodacaoEnum tipoAcomodacao;
	@DBRef
	private Paciente paciente;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataEntrada;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataSaida;

	public Leito() {
		super();
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

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
