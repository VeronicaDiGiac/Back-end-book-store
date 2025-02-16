package com.example.demo;

import java.util.List;

public class OrdineDTO {
	private Long idO;
	private String email;
	private String citta;
	private String via;
	private String cap;
	private String provincia;
	private int quantitaR;
	private double prezzoOr=0;
	private List<ProdottoDTO> prodotti;
	
	
	public OrdineDTO(Long idO, String email, String citta, String via, String cap, String provincia, 
			int quantitaR, List<ProdottoDTO> prodotti) {
		super();
		this.idO = idO;
		this.email = email;
		this.citta = citta;
		this.via = via;
		this.cap = cap;
		this.provincia = provincia;
		this.quantitaR = quantitaR;
		this.prodotti=prodotti;
	}


	public OrdineDTO() {
		super();
	}


	public Long getIdO() {
		return idO;
	}


	public void setIdO(Long idO) {
		this.idO = idO;
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
		this.prezzoOr = prezzoOr;
	}
	
	
	public List<ProdottoDTO> getProdotti() {
		return prodotti;
	}


	public void setProdotti(List<ProdottoDTO> prodotti) {
		this.prodotti = prodotti;
	}


	public static OrdineDTO fromEntity(Ordine ordine) {
		return new OrdineDTO(ordine.getIdO(), 
							 ordine.getEmail(), 
							 ordine.getCitta(), 
							 ordine.getVia(),
							 ordine.getCap(),
							 ordine.getProvincia(),
							 ordine.getQuantitaR(),
							 ordine.getProdotti()!= null 
				                ? ordine.getProdotti().stream().map(ProdottoDTO::fromEntity).toList()
				                        : null);
	}
	
	

}
