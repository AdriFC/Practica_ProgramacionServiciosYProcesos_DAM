package client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client = new Client();   //Creación de un objecto de tipo Cliente
        client.connect();               //Nos conectamos con nuestro objecto
    }
}
