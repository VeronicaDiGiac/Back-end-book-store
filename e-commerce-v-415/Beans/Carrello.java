package com.example.demo.Beans;

import java.util.HashMap;

import java.util.Map;


import com.example.demo.DTO.ProdottoDTO;

public class Carrello {

    private Map<ProdottoDTO, Integer> prodottiQuantita;

    public Carrello() {
        this.prodottiQuantita = new HashMap<>();
    }

    public Map<ProdottoDTO, Integer> getProdottiQuantita() {
        return prodottiQuantita;
    }

    public void setProdottiQuantita(Map<ProdottoDTO, Integer> prodottiQuantita) {
        this.prodottiQuantita = prodottiQuantita;
    }

    public void aggiungiProdotto(ProdottoDTO prodottoDTO, int quantita) {
        if (quantita <= 0) {
            throw new IllegalArgumentException("La quantità deve essere maggiore di zero!");
        }
        prodottiQuantita.put(prodottoDTO, prodottiQuantita.getOrDefault(prodottoDTO, 0) + quantita);
    }

    public void rimuoviProdotto(ProdottoDTO prodottoDTO) {
        prodottiQuantita.remove(prodottoDTO);
    }

    public void svuotaCarrello() {
        prodottiQuantita.clear();
    }
	}

