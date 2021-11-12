package br.com.alura.microservice.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.catalogo.modelo.Produtos;
import br.com.alura.microservice.catalogo.modelo.ProdutosDto;
import br.com.alura.microservice.catalogo.repository.ProdutoRepository;

@Service
public class CatalogoService {

	@Autowired
	private ProdutoRepository repository;

	public List<ProdutosDto> pegarProdutos() {
//		Pageable pageable = PageRequest.of(0, 10);
		List<ProdutosDto> produtosDto = new ArrayList<>();
		List<Produtos> produtos = repository.findByQuantidadeDiferenteDeZero();
//		System.out.println(produtos);//numero de paginas
//		System.out.println("Pagina atual: "+produtos.getNumber());//qual a pagina que o cliente esta visualizando
		produtos.forEach(produto -> {
			ProdutosDto p = new ProdutosDto(produto.getNome(),
											produto.getCategoria(),
											produto.getValor(),
											produto.getQuantidade());
			produtosDto.add(p);
		});		
		return produtosDto;
	}
	
	
}
