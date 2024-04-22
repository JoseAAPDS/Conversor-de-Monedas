# Challenge Conversor de Monedas

## Descripción
Este programa convierte una moneda a otra, elegidas por el usuario. Luego se conecta a una API (https://www.exchangerate-api.com/) para obtener la tasa de cambio y muestra el resultado en la consola. Fue desarrollado como parte de la formación **Java orientado a Objetos**, impartido por **Alura Latam** como parte del programa **Oracle Next Education**.  En la 
formación se estudiaron los conceptos de la **programación orientada a objetos** como:
  - Clases, objetos e instancias.
  - Encapsulación.
  - Abstracción.
  - Herencia.
  - Polimorfismo.

## Características Principales

![image](https://github.com/JoseAAPDS/Conversor-de-Monedas/assets/147453435/7b872d20-2f93-4ab4-a55a-f1d218c65687)

Menú de opciones. Se pueden elegir entre ocho monedas y combinar cualquier par que se desee.

![image](https://github.com/JoseAAPDS/Conversor-de-Monedas/assets/147453435/adea38f3-f4c9-4edc-9c8a-dab9adbbef25)

Interacción con el usuario.

![image](https://github.com/JoseAAPDS/Conversor-de-Monedas/assets/147453435/96d29604-a6ac-4d08-9489-218da79119bb)

Muestra la conversión de las monedas elegidas por el usuario y el monto especificado.

![image](https://github.com/JoseAAPDS/Conversor-de-Monedas/assets/147453435/60500ce5-1abf-4df9-9646-03679d6c6f05)

Historial de las conversiones realizadas con la fecha y hora en que fueron realizadas.

## Clases y métodos

  - Principal: La clase principal contiene el método **main**.  Solicita los datos al usuario y los envia a la clase **InteraccionUsuario**, la cual revisa la 
    validez de los datos y genera la URL con los mismos para hacer la solicitud a la API.  La URL es enviada a la clase ComunicacionConApi, la cual recibe el
    archivo Json y los recibe el record **SolicitudUsuario**, el cuál se devuelve a la clase principal para pasarlo a la clase ConversorDeMonedas, el cuál guarda
    los datos devueltos por la API, realiza la conversión, devuelve el resultado y guarda la conversión en el historial.
  - InteraccionUsuario:  Recibe los datos del usuario.  El método **validarOpcion** válida que los datos ingresados por el usuario correspondan a las opciones del
    menú.  El método obtenerUri, forma y devuelve la URL con los datos ingresados por el usuario. 
  - ComunicacionConApi:  El método **obtenerArchivo** recibe una URL, genera una solicitud para la API, recibe la respuesta y usa Gson para extraer la información al record
    SolicitudUsuario.
  - SolicitudUsuario:  Es un record que almacena los datos recibido en el archivo Json desde la API.
  - ConversorDeMonedas: Contiene el método **ingresarDatos**, toma los datos de **SolicitudUsuario** y los almacena en las variables de la clase y hace la conversión de monedas.
    El método **resultadoConversion** muestra el resultado de la conversión en la consola y finalmente el método **mostrarHistorial** muestra el historial de conversiones en la consola.

## Autor

  ### José Armando Acevedo
  
  www.linkedin.com/in/josé-acevedo-pilz-136179246
  




