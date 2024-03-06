package Observer;

import Stock.IStock;
import Wrapper.DataWrapper;
import Wrapper.SocketWrapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockObserver extends IStockObserver {
    public StockObserver(String name) {
        this.name = name;
    }

    //client read from server
    public void clientRead(Scanner sc, SocketWrapper server) {
        //client reads
        new Thread(() -> {

            try {

                while (true) {

                    Object data = server.read();
                    DataWrapper dw = (DataWrapper) data;

                    if (dw.command.equals("S")) {
                        String message = (String) dw.data;

                        if (message.equals("success")) {
                            System.out.println("Subscribed sucessfully!");
                            IStock stock = (IStock) dw.subscriber;

                            subscribedList.add(stock.getName());
                            System.out.println("after subscribe :" + subscribedList.size());
                        } else if (message.equals("unsuccess")) {
                            System.out.println("Not Subscribed sucessfully!");
                        }

                    } else if (dw.command.equals("U")) {
                        String message = (String) dw.data;

                        if (message.equals("success")) {
                            System.out.println("unSubscribed sucessfully!");
                            IStock stock = (IStock) dw.subscriber;

                            subscribedList.remove(stock.getName());
                        } else if (message.equals("unsuccess")) {
                            System.out.println("Not Subscribed sucessfully!");
                        }
                    } else if (dw.command.equals("V")) {
                        List<IStock> updatedList = (List<IStock>) dw.subscriber;

                        for (IStock stock : updatedList) {
                            this.view(stock);
                        }
                    } else if (dw.command.equals("update")) {
                        String check = (String) dw.data;
                        IStock updatedStock = (IStock) dw.subscriber;

                        if (check.equals("I")) {
                            System.out.println(updatedStock.getName() + "  increased stock price!!");
                            System.out.println(updatedStock.getName() + "       " + updatedStock.getPrice());
                        } else if (check.equals("D")) {
                            System.out.println(updatedStock.getName() + "  decreased stock price!!");
                            System.out.println(updatedStock.getName() + "       " + updatedStock.getPrice());
                        } else if (check.equals("C")) {
                            System.out.println(updatedStock.getName() + "  changed stock quantity!!");
                            System.out.println(updatedStock.getName() + "       " + updatedStock.getQuantity());
                        }

                    }

                }

            } catch (IOException e) {
                System.out.println("Server.Server disconnected!");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    server.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

    }


    public void clientWrite(Scanner sc, SocketWrapper server) throws IOException {
        //client writes
        while (true) {
            String commandLine = sc.nextLine();
            String[] tokens = commandLine.split(" ");
            String command = tokens[0];

            if (command.equals("S")) {
                //subscribe
                String stockName = tokens[1];
                server.write(new DataWrapper(command, stockName, this));
            } else if (command.equals("U")) {
                //unSubscribe
                String stockName = tokens[1];
                server.write(new DataWrapper(command, stockName, this));
            } else if (command.equals("V")) {

                List<String> newList = new ArrayList<>();

                for (String st : subscribedList) {
                    newList.add(st);
                }

                server.write(new DataWrapper(command, this, newList));
            }

        }
    }


    @Override
    public void update(IStock stock) {
        System.out.println(stock.getName() + "      " + stock.getQuantity() + "       " + stock.getPrice());
    }

    public void view(IStock stock) {
        System.out.println(stock.getName() + "      " + stock.getQuantity() + "       " + stock.getPrice());
    }


}
