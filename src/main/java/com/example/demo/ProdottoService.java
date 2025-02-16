package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProdottoService {
	
	private  ProdottoRepository prodottoRepository;
	private Prodotto prodotto;
	private Optional<Prodotto> prod;
	
	public ProdottoService(ProdottoRepository prodottoRepository) {
		this.prodottoRepository=prodottoRepository;
	}
	
	//Salva un nuovo prodotto
	public Prodotto saveProdotto(Prodotto prodotto) {
		return prodottoRepository.save(prodotto);
	}
	
	//trova libro per titolo
	public Prodotto findProdottobyTitolo(String titolo) {
		return prodottoRepository.findByTitolo(titolo);
	}
	
	//trova libro per categoria
		public List<Prodotto> findProdottobyCategoria(String categoria) {
			return prodottoRepository.findByGenere(categoria);
		}
		
		
	
	//visualizza tutti i prodotti
	public List<Prodotto> getAllProd() {
		return prodottoRepository.findAll();
	}
	
	//aggiorna prezzo
	public Prodotto updatePrezzo(Long idP, double prezzo) {
		
		prod = prodottoRepository.findById(idP);
		
		if(prod.isPresent()) {
			prodotto = prod.get();
			prodotto.setPrezzo(prezzo);
			
			return prodottoRepository.save(prodotto);
		}
		return null;
	}
	
	
	public Prodotto updateQuantita(Long idP, int quantita) {
		prod = prodottoRepository.findById(idP);
		
		if(prod.isPresent()) {
			prodotto=prod.get();
			prodotto.setQuantita(quantita+prodotto.getQuantita());
			return prodottoRepository.save(prodotto);
		}
		return null;
	}

	public Prodotto updateUrl(Long idP, String url) {
		prod = prodottoRepository.findById(idP);
		if(prod.isPresent()) {
			prodotto=prod.get();
			prodotto.setUrl(url);
			return prodottoRepository.save(prodotto);
		}
		
		return null;
	}

	public void deleteLibro(Long idP) {
		
		prod = prodottoRepository.findById(idP);
		if (prod.isPresent()){
			prodottoRepository.deleteById(idP); // Metodo built-in per eliminare l'entità
		} else {
			throw new RuntimeException("Prodotto con titolo  non trovato");
		}

	}
	
	private List<String> getGeneri(){
		List<Prodotto> listaP = prodottoRepository.findAll();
		return null;
	}
	
	public List<String> getCategorieUniche() {
	    
	    List<Prodotto> listaP = prodottoRepository.findAll();  // Assicurati che findAll() restituisca una lista di 'Prodotto'

	    // Estrai il campo 'genere' da ogni prodotto e restituisci una lista unica
	    return listaP.stream()
	                 .map(Prodotto::getGenere)  // Estrai il campo 'genere' da ogni 'Prodotto'
	                 .distinct()                // Rimuovi duplicati
	                 .collect(Collectors.toList());  // Colleziona i risultati in una lista
	}
	
	public List<String> getListaAutori() {
	    
	    List<Prodotto> listaP = prodottoRepository.findAll();  // Assicurati che findAll() restituisca una lista di 'Prodotto'

	    // Estrai il campo 'autore' da ogni prodotto e restituisci una lista unica
	    return listaP.stream()
	                 .map(Prodotto::getAutore)  // Estrai il campo 'genere' da ogni 'Prodotto'
	                 .distinct()                // Rimuovi duplicati
	                 .collect(Collectors.toList());  // Colleziona i risultati in una lista
	}
	
}
