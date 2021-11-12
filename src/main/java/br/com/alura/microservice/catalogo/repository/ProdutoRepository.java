package br.com.alura.microservice.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.catalogo.modelo.Produtos;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produtos, Long>{

	@Query("SELECT p FROM Produtos p WHERE quantidade > 0")
	List<Produtos> findByQuantidadeDiferenteDeZero(); 
}
