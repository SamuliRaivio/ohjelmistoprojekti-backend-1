package com.example.ohjelmistoprojektiBackend.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Kayttaja {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kayttaja_id;
	private String nimimerkki;
	private boolean isAdmin;
	
	public Kayttaja(String nimimerkki, boolean isAdmin) {
		super();
		this.nimimerkki = nimimerkki;
		this.isAdmin = isAdmin;
	}

	
	public Long getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(Long kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}
	
	public String getNimimerkki() {
		return nimimerkki;
	}

	public void setNimimerkki(String nimimerkki) {
		this.nimimerkki = nimimerkki;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Kayttaja [kayttaja_id=" + kayttaja_id + ", nimimerkki=" + nimimerkki + ", isAdmin=" + isAdmin + "]";
	}
	
}
