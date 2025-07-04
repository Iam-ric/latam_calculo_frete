package com.example.demo;

import com.example.demo.exception.ExceptionCalculoFrete;
import com.example.demo.model.CalculaFreteDTO;
import com.example.demo.service.CalculaFreteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LatamCalculoFreteApplicationTests {

	//Criar testes unitários para as funcionalidades utilizando JUnit.

	private final CalculaFreteService service = new CalculaFreteService();

	@Test
	public void testCalculoFreteNormal() {
		CalculaFreteDTO req = new CalculaFreteDTO();
		req.setPeso(10);
		req.setDistancia(100);
		req.setTipoTransporte("Normal");

		double valor = service.calcularFrete(req);
		assertEquals(5 + 100 * 0.5 + 10 * 2, valor);
	}

	@Test
	public void testCalculoFreteExpresso() {
		CalculaFreteDTO req = new CalculaFreteDTO();
		req.setPeso(5);
		req.setDistancia(50);
		req.setTipoTransporte("Expresso");

		double valor = service.calcularFrete(req);
		assertEquals(10 + 50 + 5 * 5, valor);
	}

	@Test
	public void testErroPesoNegativo() {
		CalculaFreteDTO req = new CalculaFreteDTO();
		req.setPeso(-1);
		req.setDistancia(10);
		req.setTipoTransporte("Normal");

		assertThrows(ExceptionCalculoFrete.class, () -> service.calcularFrete(req));
	}

	@Test
	public void testErroTipoInvalido() {
		CalculaFreteDTO req = new CalculaFreteDTO();
		req.setPeso(10);
		req.setDistancia(10);
		req.setTipoTransporte("Turbo");

		assertThrows(ExceptionCalculoFrete.class, () -> service.calcularFrete(req));
	}

}
