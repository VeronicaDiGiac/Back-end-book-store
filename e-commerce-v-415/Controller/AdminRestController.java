package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.Prodotto;
import com.example.demo.Repository.ProdottoRepository;
import com.example.demo.Service.ProdottoService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/magazzino/admin")
public class AdminRestController {
	
	@Autowired
	private ProdottoService prodottoService;
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@GetMapping
	public List<Prodotto> getAllProdotti() {
		return prodottoRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Prodotto> getProdottById(@PathVariable("id") Long id) {
		return prodottoRepository.findById(id);
	}
	

	 // Correzione qui: il PostMapping è direttamente su /api/magazzino/admin
	@PostMapping(value = "/prod", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> aggiungiProdotto(@RequestBody Prodotto prodotto) {
        prodottoService.saveProdotto(prodotto);
        return new ResponseEntity<>(prodotto, HttpStatus.CREATED);
    }

	@PostMapping("/updateQuantita")
	public Prodotto aggiornaQuantita(@RequestBody Map<String, Object> request) {
	    Long id = ((Number) request.get("id")).longValue(); 
	    int nuovaQuantita = (int) request.get("quantita"); 
	    return prodottoService.updateQuantita(id, nuovaQuantita);
	}
	
	@PostMapping("/updatePrezzo")
	public Prodotto aggiornaPrezzo(@RequestBody Map<String, Object> request) {
	    Long id = ((Number) request.get("id")).longValue();
	    double nuovoPrezzo=((double) request.get("prezzo"));
	    return prodottoService.updatePrezzo(id, nuovoPrezzo);
	}
	
	@PostMapping("/updateUrl")
	public Prodotto aggiornaUrl(@RequestBody Map<String, Object> request) {
		Long id= ((Number) request.get("id")).longValue();
	    String nuovoUrl= (String) request.get("url");
	    return prodottoService.updateUrl(id, nuovoUrl);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProd(@PathVariable("id") Long id) {
		prodottoService.deleteLibro(id);
		return "Prodotto Cancellato";
	}
}
    
