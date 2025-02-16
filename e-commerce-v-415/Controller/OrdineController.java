//package com.example.demo.Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.EmailService;
//import com.example.demo.Beans.Carrello;
//import com.example.demo.Beans.Carrello.CarrelloItem;
//import com.example.demo.Beans.Ordine;
//import com.example.demo.Beans.Prodotto;
//import com.example.demo.Repository.OrdineRepository;
//import com.example.demo.Repository.ProdottoRepository;
//import com.example.demo.Service.OrdineService;
//import com.example.demo.Service.ProdottoService;
//import com.stripe.Stripe;
//
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import com.stripe.param.ChargeCreateParams;
//
//import jakarta.mail.MessagingException;
//
//
//@Controller
//public class OrdineController {
//
//	@Autowired
//	private OrdineRepository or1;
//	@Autowired
//	private OrdineService or2;
//	@Autowired
//	private ProdottoRepository p1;
//	@Autowired
//	private ProdottoService p2;
//	
//	@Autowired
//	EmailService emailService;
//	
//	@Value("${stripe.currency}")
//	private String currency;
//	
//	@Value("${stripe.secretKey}")
//    private String stripeSecretKey;
//
//	@Autowired
//	private Carrello carrello;
//	
//	private Optional<Prodotto> prod;
//	
//
//	private List<CarrelloItem> carrelloItem; 
//	private double totOr=0;
//	@PostMapping("/ordina")
//	public String confermaOrdine(@RequestParam("idP") Long idP, Model model) {
//		
//		carrelloItem=carrello.getCarrelloItems(); 
//		model.addAttribute("carrelloItem", carrelloItem);
//		
//		for (CarrelloItem item : carrelloItem) {
//			totOr =totOr+item.getProdotto().getPrezzo()*item.getQuantita();
//	        System.out.println("Prodotto: " + item.getProdotto().getTitolo() + ", Quantità: " + item.getQuantita());
//	    }	
//		model.addAttribute("totOr", totOr);
//	    return "ProvaOrdine";
//	}
//		
//
//	@PostMapping("/confermaOrdine") 
//	public String insOrdine(@RequestParam("email") String email, @RequestParam("citta") String citta, 
//			@RequestParam("via") String via,  @RequestParam("cap") String cap, @RequestParam("provincia") String provincia,
//			@RequestParam("token") String token,
//			 Model model) throws MessagingException {
//
//		List<Carrello.CarrelloItem> carrelloItems = carrello.getCarrelloItems();
//		List<Prodotto> prodotti = new ArrayList<>();
//		ArrayList<String> listaU = new ArrayList<>();
//		String oggetto = "hai acquistato: ";
//		
//		for(Carrello.CarrelloItem item : carrelloItems) {
//			totOr =totOr+item.getProdotto().getPrezzo()*item.getQuantita();
//	        Prodotto prodotto = item.getProdotto();
//	        listaU.add(item.getProdotto().getUrl());
//	        int quantCarr = item.getQuantita();
//	        
//	        
//	        if(prodotto!=null) {
//	        	if(prodotto.getQuantita() >0 && prodotto.getQuantita() >= quantCarr) {
//	        		prodotto.setQuantitaV(prodotto.getQuantitaV()+quantCarr);
//	        		prodotto.setQuantita(prodotto.getQuantita()-quantCarr);
//	        	    prodotti.add(p1.save(prodotto));
//	        	    oggetto+= " " + prodotti;
//	        	} else {
//	        		//quantita prodotto insufficiente
//	        	}
//	        }
//		}
//		
//		if(!prodotti.isEmpty()) {
//			Ordine ordine = new Ordine(email, citta, via, cap, provincia,  prodotti.size(), prodotti);
//			or1.save(ordine);
//			emailService.sendEmailWithImage(email, "Mail da LIbri&Libri", oggetto, listaU);
//			model.addAttribute("ordine", ordine);
//			return "recap";
//		}
//		
//		try {
//            // Imposta la chiave segreta di Stripe
//            Stripe.apiKey = stripeSecretKey;
//
//            // Crea una richiesta di pagamento
//            ChargeCreateParams params = ChargeCreateParams.builder()
//                    .setAmount((long)  totOr * 100) // Importo in centesimi
//                    .setCurrency("eur")
//                    .setSource(token) // Usa il token di test fornito
//                    .build();
//            
//            
//            Charge charge = Charge.create(params);
//            
//            System.out.println("Pagamento completato: " + charge.toJson());
//            
//            System.out.println("Visualizza ricevuta: " +  charge.getReceiptUrl());
//            
//         //risult = "Pagamento andato a buon fine";
//         
//         model.addAttribute("urlRicevuta",charge.getReceiptUrl());
//  //  ok = true;
//            
//            
//        } catch (StripeException e) {
//        	
//        	//risult = "Pagamento non riuscito, riprova";
//        	//ok = false;
//        	 
//        }
//		return "recap";
//	}
//
//	
//}
