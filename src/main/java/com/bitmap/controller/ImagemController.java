package com.bitmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitmap.controller.dto.ImagemDto;
import com.bitmap.service.ImagemService;
import com.bitmap.service.validation.VetorSize;

@RestController
@RequestMapping(path = "/imagens")
@Validated
public class ImagemController {
	
	@Autowired
	private ImagemService imagemService;
	
	@GetMapping
	public ResponseEntity<ImagemDto> contarElementosDaMatriz(@RequestParam @VetorSize(max = 16) String vetor){
		return ResponseEntity.ok(imagemService.contarElementosDaMatriz(vetor));
	}

}
