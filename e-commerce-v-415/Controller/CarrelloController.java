//
//
//package com.example.demo.Controller;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.Beans.Carrello;
//import com.example.demo.Beans.Prodotto;
//import com.example.demo.Repository.ProdottoRepository;
//import com.example.demo.Service.ProdottoService;
//
//@Controller
//public class CarrelloController {
//	@Autowired
//	private Carrello c1;
//	@Autowired
//	private ProdottoService p2;
//	@Autowired
//	private ProdottoRepository p1;
//	
//	private Optional<Prodotto> prod;
//	
//	
//	public CarrelloController(Carrello carrello) {
//		this.c1 = carrello;
//	}
//	
//	@PostMapping("/add")
//	public String aggiungiProdotto(@RequestParam("idPCarr") Long idP, @RequestParam("quantitaR") int quantita, Model model) {
//		List<String> listaG = p2.getCategorieUniche();
//	    prod  = p1.findById(idP);
//	    
//	    if(prod.isPresent()) {
//	    	Prodotto prodotto= prod.get();
//	    	
//	    	if (c1.verificaProdEsistente(prodotto)) {
//		        // Aggiorna la quantità se il prodotto esiste già
//		        c1.aggiornaQuantita(prodotto, quantita);
//		    } else {
//		        // Aggiunge il prodotto se non esiste
//		        c1.aggiungiProd(prodotto, quantita);
//		    }
//	    }
//
//	    // Aggiungi i prodotti al modello per il rendering della pagina
//	    model.addAttribute("carrello", c1.getCarrelloItems());
//	    ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
//	    model.addAttribute("listaP", listaP);
//	    model.addAttribute("listaG", listaG);
//	    return "tabella2";
//	}
//	
//	@PostMapping("/clear")
//	public String svuotaCarrello(Model model) {
//		List<String> listaG = p2.getCategorieUniche();
//		c1.svuotaCarrello();
//		model.addAttribute("carrello", c1.getCarrelloItems());
//		ArrayList <Prodotto> listaP = (ArrayList<Prodotto>)p1.findAll();
//		model.addAttribute("listaP", listaP);
//		model.addAttribute("listaG", listaG);
//		return "tabella2";
//	}
//	
//	
//}
