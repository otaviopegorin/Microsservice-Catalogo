package br.com.alura.microservice.catalogo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.catalogo.modelo.Produtos;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produtos, Long>{

	@Query(value = "SELECT * FROM produtos p WHERE quantidade > 0", nativeQuery = true)
	Page<Produtos> findByQuantidadeDiferenteDeZero(Pageable pageable); 
	
	Produtos findByNome(String Nome);

}
