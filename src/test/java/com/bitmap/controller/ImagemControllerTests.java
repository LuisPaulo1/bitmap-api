package com.bitmap.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.bitmap.controller.dto.ImagemDto;
import com.bitmap.service.ImagemService;

@WebMvcTest(ImagemController.class)
public class ImagemControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ImagemService service;
		
	private ImagemDto imagemDto;
	private String cores;
	private String parametroValorInvalido;
	private String parametroVazio;	
	private String parametroTamanhoInvalido;
	
	@BeforeEach
	void setUp() throws Exception {		
		imagemDto = new ImagemDto();
		cores = "84147255,123456789,255255255,000,3981154,255226106,39221224";
		parametroValorInvalido = "841r47255,1234-56789,255255255;39221224";
		parametroTamanhoInvalido = "84147255,123456789,255255255,84147255,000,3981154,255226106,39221224,84147255,123456789,255255255,84147255,000,3981154,255226106,255000222,000";
		parametroVazio = "";		
		
		when(service.contarElementosDaMatriz(cores)).thenReturn(imagemDto);
		when(service.contarElementosDaMatriz(parametroValorInvalido)).thenThrow(IllegalArgumentException.class);
		when(service.contarElementosDaMatriz(parametroVazio)).thenThrow(IllegalArgumentException.class);
		when(service.contarElementosDaMatriz(parametroTamanhoInvalido)).thenThrow(ConstraintViolationException.class);
		
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarStatusOkQuandoRecursoExistir()  throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/imagens")
					.param("vetor", cores)	
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpectAll(status().isOk());
		
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarBadRequestQuandoValorDoParametroForInvalido() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/imagens")
					.param("vetor", parametroValorInvalido)	
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpectAll(status().isBadRequest());
		
	}
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarBadRequestQuandoValorDoParametroForVazio() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/imagens")
					.param("vetor", parametroVazio)	
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpectAll(status().isBadRequest());
		
	}	
	
	
	@Test
	public void contarElementosDaMatrizDeveriaRetornarBadRequestQuandoTamanhoDoParametroForInvalido() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/imagens")
					.param("vetor", parametroTamanhoInvalido)	
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpectAll(status().isBadRequest());
		
	}

}
