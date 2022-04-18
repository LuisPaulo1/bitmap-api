package com.bitmap.service;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitmap.controller.dto.ImagemDto;
import com.bitmap.model.Imagem;
import com.bitmap.util.ImagemResource;
import com.bitmap.util.URL;

@Service
public class ImagemService {

	public ImagemDto contarElementosDaMatriz(String vetor) {
		
		ImagemResource imagemResource = new ImagemResource();
		BufferedImage img = imagemResource.buscarImagem();
		Raster raster = img.getRaster();
		int linhas = img.getHeight();
		int colunas = img.getWidth();		
		Imagem imagem = new Imagem(linhas, colunas);
		List<Integer> elementos = URL.decodeIntegerList(vetor);
		List<String> resultados = new ArrayList<>();
		Map<Integer, Integer> qts = new HashMap<>();
		
		for (int i = 0; i < elementos.size(); i++) {
			boolean aux = false;
			for (int x = 0; x < imagem.getColunas(); x++) {
				for (int y = 0; y < imagem.getLinhas(); y++) {

					raster.getPixel(x, y, imagem.getCores()); // -> captura da combinação de cor RGB do pixel e adiciona no vetor de cores 
					int pixel = Integer.parseInt(String.valueOf(imagem.getCores()[0]) + String.valueOf(imagem.getCores()[1]) + String.valueOf(imagem.getCores()[2]));						
					if (elementos.get(i) == pixel) { // -> compara o elemento input na posição i com o valor do pixel capturado na posição x y da imagem   
						aux = true;
						if (qts.containsKey(elementos.get(i))) {
							
							int primeiraOcorrencia = elementos.indexOf(elementos.get(i));							
							if(i == primeiraOcorrencia) // -> verifica se o valor do elemento input na posição i já foi contabilizado anteriormente. Utilizado para tratar valores repetidos  
								qts.put(elementos.get(i), qts.get(elementos.get(i)) + 1);
							
						} else {
							qts.put(elementos.get(i), 1);
						}
					}
				}
			}
			if (!aux)
				qts.put(elementos.get(i), 0);
		}				

		qts.forEach((chave, valor) -> {
			resultados.add("Elemento com a cor RGB: "+(chave == 0 ? "000" : chave)+ " foi encontrado "+valor+" vezes na matriz de bitmap");
			});
		
		return new ImagemDto(resultados);
	}

}
