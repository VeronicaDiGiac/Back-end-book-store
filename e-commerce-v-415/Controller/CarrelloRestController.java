package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProdottoDTO;
import com.example.demo.Service.CarrelloService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/carrello")
public class CarrelloRestController {

	private final CarrelloService carrelloService;

	@Autowired
	public CarrelloRestController(CarrelloService carrelloService) {
		this.carrelloService = carrelloService;
	}

	// Aggiungi prodotto al carrello
	@PostMapping("/aggiungi")
	public ResponseEntity<String> aggiungiProdotto(@RequestParam("quantita") int quantita,
			@RequestBody ProdottoDTO prodottoDTO) {

		try {
			carrelloService.aggiungiProdotto(prodottoDTO, quantita);
			return ResponseEntity.ok("Prodotto aggiunto al carrello");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// Visualizza tutti i prodotti nel carrello
	@GetMapping("/visualizza")
	public Map<ProdottoDTO, Integer> visualizzaCarrello() {

		return carrelloService.getCarrello().getProdottiQuantita();
	}

	@GetMapping("/svuota")
	public Map<ProdottoDTO, Integer> svuotaCarrello() {
		carrelloService.clearCarr();
		return carrelloService.getCarrello().getProdottiQuantita();
	}
	
	@GetMapping("/rimuoviProd")
    public Map<ProdottoDTO, Integer> eliminaProd(@RequestBody ProdottoDTO prodottoDTO) {
        carrelloService.rimuoviProdotto(prodottoDTO);
        return carrelloService.getCarrello().getProdottiQuantita();
    }
}