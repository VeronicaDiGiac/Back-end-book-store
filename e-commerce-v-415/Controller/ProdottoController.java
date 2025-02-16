package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Beans.Prodotto;
import com.example.demo.Repository.ProdottoRepository;
import com.example.demo.Service.ProdottoService;
import org.springframework.ui.Model;

@Controller
public class ProdottoController {
	
	/*@Autowired
	ProdottoModel p1;*/
	
	@Autowired
	private ProdottoRepository p1;
	@Autowired
	private ProdottoService p2;

	@GetMapping("/")
	public String getIndex(Model model) {
	    List<Prodotto> listaP = p1.findAll(); // Ottieni tutti i prodotti
	    if (listaP.size() > 4) {
	        listaP = listaP.subList(0, 4); // Prendi solo i primi 4
	    }
	    model.addAttribute("listaP", listaP);
	    return "index";
	}
	
	
 
	@GetMapping("/store")
	public String getTabella (Model model){
		ArrayList <Prodotto> listaP = (ArrayList<Prodotto>)p1.findAll();
		List <String> listaG = p2.getCategorieUniche();
		model.addAttribute("listaP", listaP);
		model.addAttribute("listaG", listaG);
		return "tabella2";
   }
	
	
	
	@PostMapping("/cerca")
	public String cercaByTitolo(@RequestParam("titolo") String titolo, Model model) {
	    
	    List<Prodotto> listaP = p1.findByTitoloContaining(titolo);
	    model.addAttribute("listaP", listaP);
	    return "ProvaAdmin";
	}
	
	@GetMapping("/filterByCategoria")
	public String filterByCategoria(@RequestParam("genere") String genere, Model model) {
	    List<Prodotto> listaP;
	  
	    System.out.println("\n\n\n\n" + genere + "\n\n\n\n");
	    if (genere.equals("Tutti")) {
	        listaP = p1.findAll();
	    } else {
	        listaP = p1.findByGenere(genere);
	    }
	    List<String> listaG = p2.getCategorieUniche(); // Per mantenere la lista delle categorie nel filtro
	    model.addAttribute("listaP", listaP);
	    for (Prodotto prodotto : listaP) {
	        System.out.println("\n\n\n\n\n\nCaaaaaaaaaa "+prodotto);
	    }
	    model.addAttribute("listaG", listaG);
	    model.addAttribute("genere", genere); // Aggiungi il genere selezionato al modello
	    return "tabella2"; // Modifica con la vista corretta
	}
	@GetMapping("/filterByChoise")
    public String filterByChoise(
               @RequestParam(name = "autore", required = false) String autore,
                @RequestParam(name = "titolo", required = false) String titolo,
                @RequestParam(name ="genere", required = false) String genere, Model model) {
        List<Prodotto> listaP = new ArrayList<>();
        List<String> listaG = p2.getCategorieUniche();
        String errorMessage = null;

        if (autore != null && !autore.isEmpty()) {
            listaP = p1.findByAutoreContaining(autore);
            if (listaP.isEmpty()) {
                errorMessage = "Autore non esistente.";
            }
        } else if (titolo != null && !titolo.isEmpty()) {
            listaP = p1.findByTitoloContaining(titolo);
            if (listaP.isEmpty()) {
                errorMessage = "Titolo non esistente.";
            }
        } else if (genere != null && !genere.isEmpty()) {


            System.out.println("\n\n\n\n" + genere + "\n\n\n\n");
            if (genere.equals("Tutti")) {
                listaP = p1.findAll();
            } else {
                listaP = p1.findByGenere(genere);
            }
            // Per mantenere la lista delle categorie nel filtro
            model.addAttribute("listaP", listaP);
            for (Prodotto prodotto : listaP) {
                System.out.println("\n\n\n\n\n\n "+prodotto);
            }
            model.addAttribute("listaG", listaG);
            model.addAttribute("genere", genere); // Aggiungi il genere selezionato al modello
            return "tabella2"; // Modifica con la vista corretta
        }
            if (listaP.isEmpty()) {
                errorMessage = "Titolo non esistente.";
            }

            model.addAttribute("listaG", listaG);
        model.addAttribute("listaP", listaP); // Aggiungi i risultati al modello
        model.addAttribute("errorMessage", errorMessage);
        return "tabella2"; // Nome della vista con i risultati
    }

	
}
