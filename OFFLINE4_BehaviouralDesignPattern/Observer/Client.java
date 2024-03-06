package Observer;

import Wrapper.SocketWrapper;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        try {
            SocketWrapper server = new SocketWrapper("127.0.0.1", 3000);
            server.write(name);

            StockObserver client = new StockObserver(name);
            client.clientRead(sc, server);
            client.clientWrite(sc, server);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}