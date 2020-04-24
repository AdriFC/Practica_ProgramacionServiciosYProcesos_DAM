package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //Atributos
    private Socket socket;                                                              //Socket necesario para cliente

    //Constructor sin parámetros (ya los conocemos), obligatorio que pueda lanzar IOException (En caso de no poder conectarse al servidor)
    public  Client () throws IOException {
        socket = new Socket("localhost", 9876);
    }

    //Función que hace la conexión con el servidor, obligatorio que pueda lanzar IOException (En caso de no poder conectarse comunicarse con el servidor)
    public void connect () {

        //Objecto scanner para introducir datos por teclado
        Scanner scanner = new Scanner(System.in);

        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());     //Recogida de datos del servidor
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());   //Envio de datos al servidor
            System.out.println(entrada.readUTF());                                      //Leer la pregunta nombre de cliente
            salida.writeUTF(scanner.nextLine());                                        //Escribe el nombre del cliente
            System.out.println(entrada.readUTF());                                      //Recibe la pregunta del número de tareas

            int numTareas = Integer.parseInt(scanner.nextLine());                       //Recoger el números de tareas
            salida.writeInt(numTareas);                                                 //Envía el número de tareas por el socket

            //Meter esto dentro de un bucle
            for (int i = 1 ; i <= numTareas; i++){
                System.out.println(entrada.readUTF());                                  //Recibo "Introducción de la tarea"
                System.out.println(entrada.readUTF());                                  //Recibo Introduce la descripción.
                salida.writeUTF(scanner.nextLine());                                    //Espero a que usuario introduzca descripción y la envío.
                System.out.println(entrada.readUTF());                                  //Recibo "Intoducción del estado de la tarea"
                salida.writeUTF(scanner.nextLine());                                    //Espero a que usuario introduzca estado y lo envío.
            }

            System.out.println(entrada.readUTF());                                      //Recibo "Listado de tareas"

            //Me preparo para recibir la lista de tareas
            for (int i = 0; i<=numTareas; i++){
                System.out.println(entrada.readUTF());
            }

            socket.close();

        }catch (IOException ex){
            System.err.println("No se pudo abrir la conexión de forma correcta");
        }
    }
}
