package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {
	
	@Autowired
	private OrdineRepository ordineRepository;
	@Autowired
	private ProdottoRepository prodR;
	
	private Ordine ordine;
	
	
	public OrdineService(OrdineRepository ordineRepository) {
		this.ordineRepository = ordineRepository;
	}
	
	//Salva un nuovo ordine
	public Ordine saveOrdine(Ordine ordine) {
		return ordineRepository.save(ordine);
	}
	
	public List<Ordine> findByTitProd(String titolo) {
		List<Ordine> listOr = ordineRepository.findAll();
		List<Prodotto> prodF = prodR.findByTitoloContaining(titolo);
		if(prodF.isEmpty()) {
			return null;
			
		}
		
		
		List<Long> idOP = prodF.stream().map(Prodotto::getIdP).collect(Collectors.toList());

		List<Ordine> ordiniFiltrati = listOr.stream()
			    .filter(ordine -> ordine.getProdotti().stream()
			        .anyMatch(prodotto -> prodotto.getIdP().equals(idOP.get(1)))) // Filtra se il prodotto è nell'ordine
			    .collect(Collectors.toList()); 
		
		
		System.out.println("\n\n\n\n\nIdO lista: " + ordiniFiltrati);
		return ordiniFiltrati;
	}
	
	
	
	
	
	
	
	

}
