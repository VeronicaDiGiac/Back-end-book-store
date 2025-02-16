package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@Autowired
	private ProdottoRepository p1;
	@Autowired
	private ProdottoService p2;
	
	
	@GetMapping("private/form")
	public String getForm1(Model model) {
		ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
		model.addAttribute("listaP", listaP);
		return "ProvaAdmin";
	}
	
	@PostMapping("private/submit")
	public String insertLibro(@RequestParam("titolo") String titolo, @RequestParam("autore") String autore, 
			@RequestParam("casaEd") String casaEd, @RequestParam("annoP") String annoP, @RequestParam("genere") String genere, 
			@RequestParam("prezzo") double prezzo, @RequestParam("url") String url,
			@RequestParam("quantita") int quantita, @RequestParam("descrizione") String descrizione, Model model) {
		
		Prodotto nuovoP = new Prodotto();
		
		nuovoP = new Prodotto(titolo, autore, casaEd, annoP, genere, url, prezzo, nuovoP.getQuantita()+quantita, descrizione);

		p1.save(nuovoP);
		ArrayList<Prodotto> listaP = (ArrayList<Prodotto>)p1.findAll();
		
			model.addAttribute("listaP", listaP);
	
		return "ProvaAdmin";
	}
	
	@PostMapping("private/updateP")
	public String updatePrezzo(@RequestParam("idP") Long idP, @RequestParam("prezzo") double prezzo, Model model) {
	    Prodotto prodotto = p2.updatePrezzo(idP, prezzo);
	    ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
	    model.addAttribute("listaP", listaP);
	    return "ProvaAdmin";
	}
	@PostMapping("private/updateQ")
	public String updateQuantita(@RequestParam("idP") Long idP, @RequestParam("quantita") int quantita, Model model) {
	    Prodotto prodotto = p2.updateQuantita(idP, quantita);
	    ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
	    model.addAttribute("listaP", listaP);
	    return "ProvaAdmin";
	}
	
	@PostMapping("private/updateUrl")
	public String updateUrl(@RequestParam("idP") Long idP, @RequestParam("url") String url, Model model) {
		Prodotto prodotto = p2.updateUrl(idP, url);
		ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
		model.addAttribute("listaP", listaP);
		return "ProvaAdmin";
	}
	
	@PostMapping("private/delete")
	public String delete(@RequestParam("idDelete") Long idP, Model model) {
		System.out.println("\n\n\n\n\n\n\n\n\n" + idP + "\n\n\n\n\n\n");
		p2.deleteLibro(idP);
		ArrayList<Prodotto> listaP = (ArrayList<Prodotto>) p1.findAll();
		model.addAttribute("listaP", listaP);
		return "ProvaAdmin";
	}


}
