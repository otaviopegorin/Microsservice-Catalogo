package br.com.alura.microservice.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.catalogo.modelo.ListaDeProdutos;
import br.com.alura.microservice.catalogo.modelo.Produtos;
import br.com.alura.microservice.catalogo.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoService service;
	
	
	@GetMapping
	private String paginaProdutosVazia() {
		return null;
	}
	
	@GetMapping("/{pagina}")
	private ListaDeProdutos MostraCatalogo(@PathVariable int pagina) {
		ListaDeProdutos produtos = service.pegarProdutos(pagina);
		return produtos;
	}
	
	@GetMapping("/totalDePaginas")
	private int PegaNumeroTotalDePaginas() {
		int paginasTotais = service.pegarQuantidadeMaximaDePaginas();
		return paginasTotais;
	}
	
	@GetMapping("/BuscarPorNome/{nome}")
	private Produtos buscarProdutoPorNome(@PathVariable String nome) {
		Produtos produto = service.pegaProdutoPorNome(nome);
		return produto;
	}
	
	@GetMapping("/DarBaixaNoEstoque/{nome}&{quantidade}")
	private Boolean baixaNoEstoque(@PathVariable String nome,@PathVariable String quantidade) {
		try {
			service.baixaNoEstoque(quantidade, nome);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}
