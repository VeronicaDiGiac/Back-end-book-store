package com.example.demo.Beans;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
public class Prodotto {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idP;
	private String titolo;
	private String autore;
	private String casaEditrice;
	private String annoPubblicazione;
	private String genere;
	@Column(name = "url", length = 2000)
	private String url;
	private double prezzo;
	private int quantita;
	private int quantitaV;
	private String descrizione;
	
	@ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordini;
 
 
public Prodotto(String titolo, String autore, String casaEditrice,String annoPubblicazione,String genere,String url,double prezzo,int quantita, String descrizione){
	super();
	
	this.titolo = titolo;
	this.autore = autore;
	this.casaEditrice = casaEditrice;
	this.annoPubblicazione = annoPubblicazione;
	this.genere = genere;
	this.url = url;
	this.prezzo = prezzo;
	this.quantita = quantita;
	this.descrizione = descrizione;
 
}

	public Prodotto() {

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

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}


	
	@Override
	public String toString() {
		return "Prodotto [idP=" + idP + ", titolo=" + titolo + ", autore=" + autore + ", casaEditrice=" + casaEditrice
				+ ", annoPubblicazione=" + annoPubblicazione + ", genere=" + genere + ", url=" + url + ", prezzo="
				+ prezzo + ", quantita=" + quantita + ", quantitaV=" + quantitaV + ", descrizione=" + descrizione
				+ ", ordini=" + ordini + "]";
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prodotto prodotto = (Prodotto) obj;
        return Objects.equals(titolo, prodotto.titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo);
    }

}