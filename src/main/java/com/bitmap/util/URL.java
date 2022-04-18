package com.bitmap.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

	public static List<Integer> decodeIntegerList(String s) {
		try {
			return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		}catch (IllegalArgumentException e) {			
			throw new IllegalArgumentException("O valor do parâmetro informado está com um padrão de formato inválido. "
					+ "Infome um formato válido utilizando valores numéricos, sem espaços em branco e separados por virgula. Ex: 84147255 ou 84147255,39221224,255255255");
		}
	}
}
