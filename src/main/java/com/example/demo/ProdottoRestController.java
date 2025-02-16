package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/prodotti")
@Tag(name = "Prodotto Controller", description = "Gestisce le operazioni sui prodotti")
public class ProdottoRestController {

    @Autowired
    private ProdottoRepository prodottoRepository;
    
    @Autowired
    private ProdottoService	prodottoService;
    
    //private ArrayList<Prodotto> prodottoL;
    //private List<Prodotto> pro;
    
    //private Prodotto prodotto;

    @GetMapping
    @Operation(summary = "Ottieni tutti i prodotti", description = "Restituisce una lista di tutti i prodotti")
    public List<ProdottoDTO> getAllProdotti() {
    	List<Prodotto> pro=prodottoRepository.findAll();
        return pro.stream().map(ProdottoDTO::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Ottieni un prodotto", description = "Restituisce un prodotto in base all'ID")
    public ProdottoDTO getProdottoById(@PathVariable("id") Long id) {
    	Prodotto prodotto= prodottoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
    	
    	return ProdottoDTO.fromEntity(prodotto);
    }
   
    @GetMapping("/titolo/{titolo}")
    @Operation(summary = "Ottieni titoli per nome", description = "Restituisce una lista di titoli che corrispondono al nome dato")
    public List<ProdottoDTO> getByTitolo(@PathVariable("titolo") String titolo) {
        List<Prodotto> pro = prodottoRepository.findByTitoloContaining(titolo);
    	return pro.stream().map(ProdottoDTO::fromEntity).collect(Collectors.toList());
    }
    
    @GetMapping("/autore/{autore}")
    @Operation(summary = "Ottieni autori per nome", description = "Restituisce una lista di autori che corrispondono al nome dato")
    public List<ProdottoDTO> getByAutore(@PathVariable("autore") String autore) {
    	List<Prodotto> pro = prodottoRepository.findByAutoreContaining(autore);
        return pro.stream().map(ProdottoDTO::fromEntity).collect(Collectors.toList());
    }
    
    @GetMapping("/generi")
    @Operation(summary = "Ottieni tutti i generi", description = "Restituisce una lista di tutti i generi dei prodotti")
    public List<String> getGeneri() {
        return prodottoService.getCategorieUniche();
    }
    
    @GetMapping("/lista-autori")
    @Operation(summary = "Ottieni autori per nome", description = "Restituisce una lista di autori che corrispondono al nome dato")
    public List<String> getAutori() {
        return  prodottoService.getListaAutori();
    }
    
  

}
