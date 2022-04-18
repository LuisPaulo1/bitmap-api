package com.bitmap.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImagemTests {
	
	@Test
	public void  imagemDeveriaTerUmaEstruturaCorreta() {
	
		Imagem imagem = new Imagem();
		imagem.setLinhas(256);
		imagem.setColunas(256);
		imagem.setCores(new int[]{84147255,123456789,255255255,000,3981154,255226106,39221224});
		
		Assertions.assertNotNull(imagem.getLinhas());
		Assertions.assertNotNull(imagem.getCores());
		Assertions.assertNotNull(imagem.getCores());
	}

}
