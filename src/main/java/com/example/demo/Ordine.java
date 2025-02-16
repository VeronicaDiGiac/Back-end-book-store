package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Ordine {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idO;
	private String email;
	private String citta;
	private String via;
	private String cap;
	private String provincia;
	private int quantitaR;
	private double prezzoOr=0;


	@ManyToMany(cascade = CascadeType.ALL) // Oppure REMOVE, se vuoi solo rimuovere
	@JoinTable(
			name = "ordine_prodotto",
			joinColumns = @JoinColumn(name = "ordine_id"),
			inverseJoinColumns = @JoinColumn(name = "prodotto_id")
			)
	@JsonBackReference
	private List<Prodotto> prodotti;
	

	public Ordine(String email, String citta, String via, String cap, String provincia, int quantitaR,
			 List<Prodotto> prodotti) {
		super();
		this.email = email;
		this.citta = citta;
		this.via = via;
		this.cap = cap;
		this.provincia = provincia;
		this.quantitaR = quantitaR;
		
		this.prodotti = prodotti;
	}

	public Ordine() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getQuantitaR() {
		return quantitaR;
	}

	public void setQuantitaR(int quantitaR) {
		this.quantitaR = quantitaR;
	}
	
	public double getPrezzoOr() {
		return prezzoOr;
	}

	public void setPrezzoOr(double prezzoOr) {
		this.prezzoOr=prezzoOr;
	}
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public Long getIdO() {
		return idO;
	}
	
}
