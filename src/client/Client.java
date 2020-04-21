package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    //Atributos
    private Socket socket;      //Socket necesario para cliente

    //Constructor sin parámetros (ya los conocemos), obligatorio que pueda lanzar IOException (En caso de no poder conectarse al servidor)
    public  Client () throws IOException {
        socket = new Socket("localhost", 9876);
    }

    //Función que hace la conexión con el servidor, obligatorio que pueda lanzar IOException (En caso de no poder conectarse comunicarse con el servidor)
    public void connect () {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());     //Recogida de datos del servidor
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());   //Envio de datos al servidor
        }catch (IOException ex){
            System.err.println("No se pudo abrir la conexión de forma correcta");
        }
    }
}
