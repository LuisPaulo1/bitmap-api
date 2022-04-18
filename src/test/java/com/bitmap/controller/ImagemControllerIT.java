package com.bitmap.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class ImagemControllerIT {
	
	@Autowired
	private MockMvc mockMvc;
		
	private String cores;
	private String parametroValorInvalido;
	private String parametroVazio;	
	private String parametroTamanhoInvalido;
	
	@BeforeEach
	void setUp() throws Exception {	
		cores = "84147255,123456789,255255255,000,3981154,255226106,39221224";
		parametroValorInvalido = "841r47255,1234-56789,255255255;39221224";	
		parametroTamanhoInvalido = "84147255,123456789,255255255,84147255,000,3981154,255226106,39221224,84147255,123456789,255255255,84147255,000,3981154,255226106,255000222,000";
		parametroVazio = "";				
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
	public void contarElementosDaMatrizDeveriaRetornarBadRequestQuandoNomeDoParametroForDiferenteDeVetor() throws Exception {
		
		ResultActions result =
				mockMvc.perform(get("/imagens")
					.param("vetor123", cores)	
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
