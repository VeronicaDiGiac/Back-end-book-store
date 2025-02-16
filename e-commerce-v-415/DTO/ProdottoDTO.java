package com.example.demo.DTO;

import java.util.Objects;

import com.example.demo.Beans.Prodotto;

public class ProdottoDTO {
	private Long idP;
	private String titolo;
	private String autore;
	private String casaEditrice;
	private String annoPubblicazione;
	private String genere;
	private String url;
	private double prezzo;
	private int quantita;
	private int quantitaV;
	private String descrizione;

	public ProdottoDTO(Long idP, String titolo, String autore, String casaEditrice, String annoPubblicazione,
			String genere, String url, double prezzo, int quantita, int quantitaV, String descrizione) {
		super();
		this.idP = idP;
		this.titolo = titolo;
		this.autore = autore;
		this.casaEditrice = casaEditrice;
		this.annoPubblicazione = annoPubblicazione;
		this.genere = genere;
		this.url = url;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.quantitaV = quantitaV;
		this.descrizione = descrizione;
	}

	public Long getIdP() {
		return idP;
	}

	public void setIdP(Long idP) {
		this.idP = idP;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getQuantitaV() {
		return quantitaV;
	}

	public void setQuantitaV(int quantitaV) {
		this.quantitaV = quantitaV;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProdottoDTO that = (ProdottoDTO) o;
		return idP == that.idP; // Assumiamo che idP sia l'unico campo che serve per identificare il prodotto
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idP); // Usa lo stesso campo per la hash
	}
	
	public static ProdottoDTO fromEntity(Prodotto prodotto) {
		return new ProdottoDTO(prodotto.getIdP(), prodotto.getTitolo(), prodotto.getAutore(),
				prodotto.getCasaEditrice(), prodotto.getAnnoPubblicazione(), prodotto.getGenere(), prodotto.getUrl(),
				prodotto.getPrezzo(), prodotto.getQuantita(), prodotto.getQuantitaV(), prodotto.getDescrizione());
	}
}
	
