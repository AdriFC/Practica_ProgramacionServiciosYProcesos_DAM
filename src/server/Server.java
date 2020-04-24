package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //Atributos
    private final int PUERTO = 9876;           //Constante en la que se guarda el puerto
    private ServerSocket server;               //Objecto con el que levantamos el servidor
    private Socket client;                     //Objecto de tipo socket con el que vamos a establecer la comunicación con el cliente

    //Constructor de la clase
    public Server () throws IOException {
        server = new ServerSocket(PUERTO);     //Inicializamos el socket del servidor con el puerto a utilizar
        client = new Socket();                 //Inicializamos el socket de comunicación con los clientes
    }

    //Función para establecer la conexión con el cliente
    public void connect() throws IOException {
        while (true){                          //Este bucle while se ejecuta infinitamente hasta que se cierre la aplicación (mientra, siempre)
            client = server.accept();          //El servidor se queda esperando la petición de un cliente

            DataInputStream entrada = new DataInputStream(client.getInputStream());
            DataOutputStream salida = new DataOutputStream(client.getOutputStream());
            salida.writeUTF("Bienvenido, ¿Cómo te llamas?");
            System.out.println(entrada.readUTF());
            salida.writeUTF("¿Cuántas tareas has de realizar?");

            //Variable para guardar el número de tareas
            int numTareas = entrada.readInt();
            System.out.println(numTareas);

            //Creamos un array de tareas
            Tarea [] tareas = new Tarea[numTareas];

            //Recogemos las tareas a realizar
            for (int i = 1; i <= numTareas; i++ ){
                Tarea miTarea = new Tarea();
                salida.writeUTF("Introducción de la tarea: " + i);
                salida.writeUTF("Introduce la descripción: ");
                miTarea.setDescripción(entrada.readUTF());                 //Recibo descripción de tarea y lo guardo en el array
                salida.writeUTF("Introduce el estado de la tarea: ");
                miTarea.setEstado(entrada.readUTF());                      //Recibo estado tarea y lo guardo en el array
                tareas[i-1] = miTarea;
            }

            salida.writeUTF("Listado de tareas: ");
            for (int i = 0; i <numTareas; i++){                            //Con este bucle envío al cliente strings con las tareas
                salida.writeUTF("Tarea: " + tareas[i].getDescripción() + ", con estado " + tareas[i].getEstado());
            }
        }
    }
}

