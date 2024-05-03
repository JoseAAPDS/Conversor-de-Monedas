import java.util.Scanner;

public class InteraccionUsuario {
    private String menu = """
             ************* Conversor de Moneda *************
               Código  Nombre                 País
            1- ARS	   Peso Argentino	      Argentina
            2- BRL	   Real Brasileño	      Brasil
            3- COP	   Peso Colombiano   	  Colombia
            4- USD	   Dólar Estadounidense	  Estados Unidos
            5- GTQ	   Quetzal	              Guatemala
            6- MXN     Peso Mexicano          México
            7- EUR	   Euro	                  Unión Europea
            8- GBP	   Libra Esterlina	      Reino Unido
            9- Salir
            ***********************************************
                  Convertir de moneda1 ----> moneda2
            *********************************************** 
            """;
    private Scanner ingresoTeclado = new Scanner(System.in);
    private String direccionBase = "https://v6.exchangerate-api.com/v6/" + ${USER_KEY} + "/pair";
    private String[] monedas = {"ARS","BRL","COP","USD","GTQ","MXN","EUR","GBP"};


    // métodos

    public int validarOpcion(int opcion){
        if (opcion >= 1 && opcion <= 9) {
            return opcion;
        } else {
            System.out.println("Opción Inválida \n");
            System.exit(0);
        }
        return opcion;
    }

    public String obtenerUri(int opcion1, int opcion2, double monto){
        return direccionBase + "/" + monedas[opcion1-1] + "/" + monedas[opcion2-1] +
                "/" + monto;
    }

    //métodos getters

    public String getMenu(){
        return menu;
    }


}
