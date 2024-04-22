import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversorDeMonedas {
    private String monedaBase;
    private String monedaDestino;
    private double tasaDeCambio;
    private double montoBase;
    private double montoDestino;
    private List<String> historialConversiones = new ArrayList<>();


    public ConversorDeMonedas() {
    }

    public void ingresarDatos(SolicitudUsuario solicitud, double monto){
        this.monedaBase = solicitud.base_code();
        this.monedaDestino = solicitud.target_code();
        this.tasaDeCambio = solicitud.conversion_rate();
        this.montoBase = monto;
        this.montoDestino = montoBase * tasaDeCambio;
    }

    public void resultadoConversion(){
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        String palabra = montoBase==1?"equivale":"equivalen";
        System.out.println("\n++++++++++++++++++++++++++++++");
        System.out.println(String.format("%.2f %s ", montoBase, monedaBase) + palabra +
                        String.format(" a %.2f %s", montoDestino, monedaDestino));
        System.out.println("++++++++++++++++++++++++++++++\n");
        historialConversiones.add(String.format("%.2f %s ", montoBase, monedaBase) + palabra +
                String.format(" a %.2f %s ", montoDestino, monedaDestino) +
                "- Fecha y hora: " + tiempo.format(ahora));

    }

    public void mostrarHistorial(){
        System.out.println("HISTORIAL DE CONVERSIONES");
        for(String transaccion : historialConversiones){
            System.out.println(transaccion);
        }
    }




}
