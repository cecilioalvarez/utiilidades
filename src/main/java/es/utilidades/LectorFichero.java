package es.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LectorFichero {

    public List<String> leerLineas(String ruta) {
        return leerLineas(Path.of(ruta));
    }

    public List<String> leerLineas(Path ruta) {
        try {
            return Files.readAllLines(ruta, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo leer el fichero: " + ruta, e);
        }
    }

    /** Lee las líneas de un contenido ya abierto, por ejemplo un fichero subido. */
    public List<String> leerLineas(InputStream entrada) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(entrada, StandardCharsets.UTF_8))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo leer el fichero", e);
        }
    }
}
