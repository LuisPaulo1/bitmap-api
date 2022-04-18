package com.bitmap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Imagem {
	
	private int linhas;
	private int colunas;
	private int[] cores;
	
	public Imagem(int linhas, int colunas) {		
		this.linhas = linhas;
		this.colunas = colunas;
		this.cores = new int[linhas * colunas];
	}

}
