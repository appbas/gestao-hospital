package dev.codenation.gestaohospital.padrao;

import java.util.List;

public class Paginacao<T extends GestaoHospitalResource> {

	private T objeto;
	private int tamanhoPagina;
	private int pagina;
	private long totalRegistros;
	private List<T> resultado;

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public int getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(int tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	public List<T> getResultado() {
		return resultado;
	}

	public void setResultado(List<T> resultado) {
		this.resultado = resultado;
	}

}
