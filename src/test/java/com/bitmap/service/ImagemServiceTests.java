package com.bitmap.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitmap.controller.dto.ImagemDto;

@ExtendWith(SpringExtension.class)
public class ImagemServiceTests {
	
	@InjectMocks
	private ImagemService service;
		
	private ImagemDto imagemDto;
	private String cores;
	private String coresIguais;
	private String parametroValorInvalido;
	private String parametroValorVazio;
	
	@BeforeEach
	void setUp() throws Exception {
		imagemDto = new ImagemDto();
		cores = "84147255,123456789,255255255,000,3981154,255226106,39221224";
		coresIguais = "255255255,255255255,255255255,255255255";
		parametroValorInvalido = "841r47255,1234-56789,255255255;39221224";		
		parametroValorVazio = "";
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarImagemDtoQuandoRecursoExistir() {		
		imagemDto = service.contarElementosDaMatriz(cores);
		Assertions.assertNotNull(imagemDto);
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarApenasUmElementoQuandoTodasAsCoresForemIguais() {
		imagemDto = service.contarElementosDaMatriz(coresIguais);
		Assertions.assertEquals(1, imagemDto.getResultado().size());
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaLancarIllegalArgumentExceptionQuandoParametroForInvalido() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.contarElementosDaMatriz(parametroValorInvalido);
		});		
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaLancarIllegalArgumentExceptionQuandoParametroForVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.contarElementosDaMatriz(parametroValorVazio);
		});		
	}

}
