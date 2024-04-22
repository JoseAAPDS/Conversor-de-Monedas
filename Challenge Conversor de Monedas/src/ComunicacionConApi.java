import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ComunicacionConApi {

    public SolicitudUsuario obtenerArchivo(String direccion){
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().create();
            SolicitudUsuario pedidoUsuario = gson.fromJson(respuesta.body(), SolicitudUsuario.class);
            return pedidoUsuario;
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en conexión con API");
            throw new RuntimeException(e);
        }
    }
}
