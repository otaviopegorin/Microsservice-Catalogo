package br.com.alura.microservice.catalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.catalogo.modelo.ListaDeProdutos;
import br.com.alura.microservice.catalogo.modelo.Produtos;
import br.com.alura.microservice.catalogo.repository.ProdutoRepository;

@Service
public class CatalogoService {

	@Autowired
	private ProdutoRepository repository;

	
	public ListaDeProdutos pegarProdutos(int pagina) {
		Pageable pageable = PageRequest.of(pagina, 10);
		Page<Produtos> produtos = repository.findByQuantidadeDiferenteDeZero(pageable);
		ListaDeProdutos listaDeProdutos = new ListaDeProdutos();
		produtos.forEach(p ->{
			listaDeProdutos.adicionar(p);
		});
		return listaDeProdutos;
	}


	public int pegarQuantidadeMaximaDePaginas() {
		Pageable pageable = PageRequest.of(1, 10);
		return repository.findByQuantidadeDiferenteDeZero(pageable).getTotalPages();
	}
	
	public Produtos pegaProdutoPorNome(String nome) {
		Produtos produto = repository.findByNome(nome);
		return produto;
		
	}


	public Boolean baixaNoEstoque(String quantidade,String nome) {
		try {
			Produtos produto = pegaProdutoPorNome(nome);
			int qtd = Integer.parseInt(quantidade); 
			if(produto.getQuantidade() - qtd >= 0){
			int novaQuantidade = produto.getQuantidade() - qtd;
			produto.setQuantidade(novaQuantidade);
			repository.save(produto);
			return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
}
