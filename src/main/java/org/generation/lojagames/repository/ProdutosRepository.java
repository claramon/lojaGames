package org.generation.lojagames.repository;

import java.util.List;

import org.generation.lojagames.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	public List<Produtos> findAllByProdutosContainingIgnoreCase ();
	
}
