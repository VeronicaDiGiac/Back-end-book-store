package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> aggiungiProdotto(
            @RequestParam("quantita") int quantita, 
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
    
    @DeleteMapping("/rimuoviProd")
    public Map<ProdottoDTO, Integer> eliminaProd(@RequestBody ProdottoDTO prodottoDTO) {
    	carrelloService.rimuoviProdotto(prodottoDTO);
    	return carrelloService.getCarrello().getProdottiQuantita();
    }
}
