package es.utilidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

class LectorFicheroTest {

	private final LectorFichero lector = new LectorFichero();

	private static final List<String> ESPERADAS = List.of("linea uno", "línea dos con tilde", "", "linea cuatro");

	@Test
	void leeTodasLasLineasDeUnaRuta() {
		assertEquals(ESPERADAS, lector.leerLineas("src/test/resources/ejemplo.txt"));
	}

	@Test
	void leeTodasLasLineasDeUnInputStream() {
		String contenido = String.join("\n", ESPERADAS);
		var entrada = new ByteArrayInputStream(contenido.getBytes(StandardCharsets.UTF_8));
		assertEquals(ESPERADAS, lector.leerLineas(entrada));
	}

	@Test
	void ficheroInexistenteLanzaExcepcion() {
		assertThrows(UncheckedIOException.class, () -> lector.leerLineas(Path.of("no-existe.txt")));
	}
}
