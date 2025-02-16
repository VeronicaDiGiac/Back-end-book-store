package com.example.demo.Repository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Beans.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    Prodotto findByTitolo(String titolo);
    List<Prodotto> findByTitoloContaining(String titolo);
    List<Prodotto> findByAutoreContaining(String autore);
    List<Prodotto> findByGenere(String genere);
    Optional<Prodotto> findById(Long id);
}