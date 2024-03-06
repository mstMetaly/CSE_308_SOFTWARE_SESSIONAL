package Server;

import Wrapper.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


public class Server {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server started!");

        //create admin
        Admin admin = new Admin();
        admin.createStock();

        //client handler
        ClientHandle clientHandler = new ClientHandle();

        //server reads from client

        new Thread(() -> {

            while (true) {

                new Thread(()->{
                Socket clientSocket = null;

                try {
                    clientSocket = server.accept();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                SocketWrapper client = null;

                try {
                    client = new SocketWrapper(clientSocket);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {

                    String name = (String) client.read();

                    System.out.println(name + " connected");

                    Admin.clientMap.put(name, client);
                    clientHandler.clientRequestHandle(name, client, admin.getStockList(), admin);


                } catch (IOException e) {
                    System.out.println("Client.Client disconnected!");
                    System.out.println(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        client.closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();

            }

        }).start();


        new Thread(() -> {
            while (true) {
                try {
                    admin.adminRequestHandle(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }


}
