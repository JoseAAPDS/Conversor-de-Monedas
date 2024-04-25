import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner ingresoTeclado = new Scanner(System.in);
        ConversorDeMonedas moneda = new ConversorDeMonedas();
        InteraccionUsuario usuario = new InteraccionUsuario();
        ComunicacionConApi comunicacion = new ComunicacionConApi();
        int opcion1;
        int opcion2;
        double monto;

        while (true) {
            System.out.println(usuario.getMenu());
            try {
                System.out.println("Elige una opción para moneda1");
                opcion1 = usuario.validarOpcion(ingresoTeclado.nextInt());
                if(opcion1 == 9){
                    break;
                }
                System.out.println("Elige una opción para moneda2");
                opcion2 = usuario.validarOpcion(ingresoTeclado.nextInt());
                if(opcion2 == 9){
                    break;
                } else {
                    System.out.println("Ingresa el monto que deseas convertir");
                    monto = ingresoTeclado.nextDouble();
                }

                String direccion = usuario.obtenerUri(opcion1, opcion2, monto);
                moneda.ingresarDatos(comunicacion.obtenerArchivo(direccion),monto);
                moneda.resultadoConversion();
            } catch (InputMismatchException e){
                System.out.println("Opción inválida \n");
            }
        }
        moneda.mostrarHistorial();
    }
}