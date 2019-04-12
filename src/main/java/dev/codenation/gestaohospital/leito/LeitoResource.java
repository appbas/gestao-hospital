package dev.codenation.gestaohospital.leito;

import java.util.Date;

import dev.codenation.gestaohospital.paciente.Paciente;
import dev.codenation.gestaohospital.padrao.GestaoHospitalResource;

public class LeitoResource implements GestaoHospitalResource {

	private String id;
	private TipoAcomodacaoEnum tipoAcomodacao;
	private Paciente paciente;
	private Date dataEntrada;
	private Date dataSaida;

	public LeitoResource() {
		super();
	}

	public LeitoResource(String id, TipoAcomodacaoEnum tipoAcomodacao, Paciente paciente, Date dataEntrada,
			Date dataSaida) {
		super();
		this.id = id;
		this.tipoAcomodacao = tipoAcomodacao;
		this.paciente = paciente;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public String getId() {
		return id;
	}

	public TipoAcomodacaoEnum getTipoAcomodacao() {
		return tipoAcomodacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;
		private TipoAcomodacaoEnum tipoAcomodacao;
		private Paciente paciente;
		private Date dataEntrada;
		private Date dataSaida;

		public Builder comId(String id) {
			this.id = id;
			return this;
		}

		public Builder comTipoAcomodacao(TipoAcomodacaoEnum tipoAcomodacao) {
			this.tipoAcomodacao = tipoAcomodacao;
			return this;
		}

		public Builder comPaciente(Paciente paciente) {
			this.paciente = paciente;
			return this;
		}

		public Builder comDataEntrada(Date dataEntrada) {
			this.dataEntrada = dataEntrada;
			return this;
		}

		public Builder comDataSaida(Date dataSaida) {
			this.dataSaida = dataSaida;
			return this;
		}

		public LeitoResource build() {
			return new LeitoResource(id, tipoAcomodacao, paciente, dataEntrada, dataSaida);
		}

	}

}
