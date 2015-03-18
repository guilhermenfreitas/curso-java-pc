package org.br.locadora;

public class Produto {

	private String produto;
	private Double preco;

	public Produto(String produto, double preco) {
		this.produto = produto;
		this.preco = preco;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
