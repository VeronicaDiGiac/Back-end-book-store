package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
	
	Prodotto findByTitolo(String titolo);
	List<Prodotto> findByTitoloContaining(String titolo);
	List<Prodotto> findByGenere(String genere);
	List<Prodotto> findByAutoreContaining(String autore);
	Optional<Prodotto> findById(Long id);

} 