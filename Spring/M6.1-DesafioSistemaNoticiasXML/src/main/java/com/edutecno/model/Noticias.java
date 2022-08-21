package com.edutecno.model;

import java.util.Arrays;

public class Noticias {
	private String [] noticias;
	
	public Noticias() {
	}

	public String[] getNoticias() {
		return noticias;
	}

	public void setNoticias(String[] noticias) {
		this.noticias = noticias;
	}

	@Override
	public String toString() {
		return "Noticias [noticias=" + Arrays.toString(noticias) + "]";
	}
}
