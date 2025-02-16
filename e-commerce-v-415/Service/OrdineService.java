package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Beans.Ordine;
import com.example.demo.Repository.OrdineRepository;

@Service
public class OrdineService {

    private OrdineRepository ordineRepository;
    private Ordine ordine;

    public OrdineService(OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
    }

    //Salva un nuovo ordine
    public Ordine saveOrdine(Ordine ordine) {
        return ordineRepository.save(ordine);
      }
}
