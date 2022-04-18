package com.bitmap.util;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.bitmap.service.exception.ResourceNotFoundException;

public class ImagemResource {
			
	public BufferedImage buscarImagem() {
		try {
			InputStream input = getClass().getResourceAsStream("/imagem/icone.bmp");
			return ImageIO.read(input);			
		} catch (Exception e) {
			throw new ResourceNotFoundException("Recurso inválido. Verifique se o recurso existe no resources ou se URI do recurso está correta.");
		}
	}

}
