package com.bitmap.service.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bitmap.util.URL;

public class VetorSizeValidator implements ConstraintValidator<VetorSize, String> {

	private int tamanhoMaximo;	
	
	@Override
	public void initialize(VetorSize constraintAnnotation) {
		this.tamanhoMaximo = constraintAnnotation.max();
	}
	
	@Override
	public boolean isValid(String vetor, ConstraintValidatorContext context) {
		
		if(vetor != null && vetor.isBlank())
			return true;
			
		try {
			List<Integer> elementos = URL.decodeIntegerList(vetor);			
			return elementos.size() <= this.tamanhoMaximo;			
		}catch (IllegalArgumentException e) {
			return true;
		}		
	}

}
