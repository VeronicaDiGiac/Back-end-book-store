package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {
	

	private final Carrello carrello;
	 
	 @Autowired
	 private ProdottoRepository prodRes;

	 public CarrelloService() {
	     this.carrello = new Carrello();
	 }
	    
	 public void aggiungiProdotto(ProdottoDTO prodottoDTO, int quantita) {
	     if (quantita <= 0) {
	         throw new IllegalArgumentException("La quantità deve essere maggiore di zero!");
	     } else {
	    	 Optional<Prodotto> prod = prodRes.findById(prodottoDTO.getIdP());
	    	 
	    	 if (prod.isPresent()) {
	    		 Prodotto prodotto = prod.get();
	    		 prodottoDTO.setTitolo(prodotto.getTitolo());
	             prodottoDTO.setAutore(prodotto.getAutore());
	             prodottoDTO.setCasaEditrice(prodotto.getCasaEditrice());
	             prodottoDTO.setAnnoPubblicazione(prodotto.getAnnoPubblicazione());
	             prodottoDTO.setGenere(prodotto.getGenere());
	             prodottoDTO.setUrl(prodotto.getUrl());
	             prodottoDTO.setPrezzo(prodotto.getPrezzo());
	             prodottoDTO.setDescrizione(prodotto.getDescrizione());

	    	 if(carrello.getProdottiQuantita().containsKey(prodottoDTO)) {
	    		 int quantitaAttuale = carrello.getProdottiQuantita().get(prodottoDTO);
	             carrello.getProdottiQuantita().put(prodottoDTO, quantitaAttuale + quantita);
	    		 
	    	 } else {
	    		 carrello.aggiungiProdotto(prodottoDTO, quantita);	 
	    	 }
	     } else {
	    	 throw new IllegalArgumentException("Il prodotto non esiste nel database!");
	     	}
	     }
	 }

	 public Carrello getCarrello() {
		    return carrello;	
	 }
	 
	 
	 public void clearCarr() {
		 carrello.getProdottiQuantita().clear();
	 }
	 
	 public void rimuoviProdotto(ProdottoDTO prodottoDTO) {
		    if (carrello.getProdottiQuantita().containsKey(prodottoDTO)) {
		        carrello.getProdottiQuantita().remove(prodottoDTO);
		        System.out.println("Prodotto rimosso dal carrello.");
		    } else {
		        throw new IllegalArgumentException("Il prodotto non è presente nel carrello.");
		    }
	 }

}
	 
