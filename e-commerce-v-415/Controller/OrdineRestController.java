package com.example.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.Ordine;
import com.example.demo.Beans.Prodotto;
import com.example.demo.DTO.OrdineDTO;
import com.example.demo.DTO.ProdottoDTO;
import com.example.demo.Repository.OrdineRepository;
import com.example.demo.Repository.ProdottoRepository;
import com.example.demo.Service.OrdineService;
import com.example.demo.Service.ProdottoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

 
	@RestController
	@RequestMapping("/api/v1/ordini")
	@Tag(name = "Ordine Controller", description = "Gestisce le operazioni sugli ordini")
	public class OrdineRestController {

		@Autowired
		private OrdineRepository ordineRepository;

		@Autowired
		private OrdineService ordineService;

		@GetMapping
		@Operation(summary = "Ottieni tutti gli ordini", description = "Restituisce una lista di tutti gli ordini")
		public List<OrdineDTO> getAllOrdini() {
			List<Ordine> ordine = ordineRepository.findAll();
			return ordine.stream().map(OrdineDTO::fromEntity).collect(Collectors.toList());
		}
}
