package br.com.alura.microservice.catalogo.modelo;

import java.util.ArrayList;
import java.util.List;



public class ListaDeProdutos {

	private List<Produtos> produtos = new ArrayList<>();

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produto) {
		this.produtos = produto;
	}
	
	public void adicionar(Produtos produto) {
		produtos.add(produto);
	}
	
}
