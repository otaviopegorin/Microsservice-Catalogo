package br.com.alura.microservice.catalogo.modelo;

import java.math.BigDecimal;

public class ProdutosDto {

	private String nome;

	private Categoria categoria;

	private BigDecimal valor;

	private int quantidade;

	private String urlImagem;
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutosDto(String nome, Categoria categoria, BigDecimal valor, int quantidade) {
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
