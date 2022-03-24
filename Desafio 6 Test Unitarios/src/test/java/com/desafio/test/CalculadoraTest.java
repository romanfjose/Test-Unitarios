package com.desafio.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.test.service.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraTest {
	@Autowired
	private CalculatorService calculatorService;
	
	@Test
	public void TestSumOfTwoNumbers() {
		
		int a = 12;
		int b = 1;
		int resultado;
		resultado = calculatorService.sum(a, b);
		
	//	assertEquals(25, resultado);
		
		assertThat(resultado).isEqualTo(25);
			
		
		
	}
	
	
}
