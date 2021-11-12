package br.com.alura.microservice.catalogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.catalogo.modelo.ProdutosDto;
import br.com.alura.microservice.catalogo.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired
	private CatalogoService service;
	
	@RequestMapping
	private List<ProdutosDto> MostraCatalogo() {
		List<ProdutosDto> listaDeProdutos = new ArrayList<>();
		listaDeProdutos = service.pegarProdutos();
		System.out.println(listaDeProdutos);
		return listaDeProdutos;
	}
}
