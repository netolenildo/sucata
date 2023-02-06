package br.com.sucatabusiness.model;

public enum TipoMovimentacao {
	VENDA(1),
	COMPRA(2);

	public Integer tipo;

	TipoMovimentacao(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}
}
