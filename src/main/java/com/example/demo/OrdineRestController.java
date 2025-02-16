package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/ordini")
@Tag(name = "Ordine Controller", description = "Gestisce le operazioni sugli ordini")
public class OrdineRestController {
	
	@Autowired
	private OrdineRepository orR;
	@Autowired
	private OrdineService orS;
	
	
	@GetMapping
	@Operation(summary = "Ottieni tutti gli ordini", description = "Restituisce una lista di tutti gli ordini")
	public List<OrdineDTO> getAllOrdini() {
		List<Ordine> ordini = orR.findAll();				
        return ordini.stream().map(OrdineDTO::fromEntity).collect(Collectors.toList());
	}
	
	@GetMapping("/titolo/{titolo}")
	@Operation(summary = "Ottieni titoli per nome", description = "Restituisce una lista di titoli che corrispondono al nome dato")
	public List<OrdineDTO> getByTitolo(@PathVariable("titolo") String titolo) {
		List<Ordine> ordini = orS.findByTitProd(titolo);
		return ordini.stream().map(OrdineDTO::fromEntity).collect(Collectors.toList());
	}
	
	

	

}
