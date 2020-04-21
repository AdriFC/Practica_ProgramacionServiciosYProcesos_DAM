package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //Atributos
    private final int PUERTO = 9876;
    private ServerSocket server;
    private Socket client;

    //Constructor de la clase
    public Server () throws IOException {
        server = new ServerSocket(PUERTO);
        client = new Socket();
    }

    //Función para establecer la conexión con el cliente
    public void connect() throws IOException {
        while (true){
            client = server.accept();          //El servidor se queda esperando la petición de un cliente

            DataInputStream entrada = new DataInputStream(client.getInputStream());
            DataOutputStream salida = new DataOutputStream(client.getOutputStream());
            salida.writeUTF("¿Como te llamas?");
            String mensajeCliente;
            try {
                while(!(mensajeCliente = entrada.readUTF()).isEmpty())
                    System.out.println(mensajeCliente);
            }catch (EOFException ex){
                System.out.println("El ciente finalizó la comunicación");
            }
        }
    }
}

