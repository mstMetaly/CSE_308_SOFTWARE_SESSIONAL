package Server;

import Stock.IStock;
import Observer.IStockObserver;
import Stock.Stock;
import Wrapper.DataWrapper;
import Wrapper.SocketWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private HashMap<String, IStock> stockList = new HashMap<>();

    //client socket
    public static HashMap<String, SocketWrapper> clientMap = new HashMap<>();

    public void createStock() {
        IStock p1 = new Stock("P1", 3, 40.00);

        IStock p2 = new Stock("P2", 4, 30.00);
        IStock p3 = new Stock("P3", 5, 80.00);
        IStock p4 = new Stock("P4", 6, 25.00);
        IStock p5 = new Stock("P5", 7, 15.00);
        IStock p6 = new Stock("P6", 9, 50.00);


        stockList.put("P1", p1);
        stockList.put("P2", p2);
        stockList.put("P3", p3);
        stockList.put("P4", p4);
        stockList.put("P5", p5);
        stockList.put("P6", p6);
    }


    public HashMap<String, IStock> getStockList() {
        return this.stockList;
    }

    public void adminRequestHandle(Scanner sc) throws IOException {

        while (true) {
            String commandLine = sc.nextLine();
            String[] tokens = commandLine.split(" ");
            String command = tokens[0];

            if (command.equals("I")) {
                //increase stock price
                String stockName = tokens[1];
                int increasePrice = Integer.parseInt(tokens[2]);

                IStock stock = stockList.get(stockName);

                if (stock != null) {
                    stockList.remove(stockName);
                    stock.increasePrice(increasePrice);
                    stockList.put(stockName, stock);

                    //notify all observers
                    List<IStockObserver> observerList = stock.getObserverList();

                    for (IStockObserver observer : observerList) {
                        String name = observer.name;
                        SocketWrapper clientSocket = clientMap.get(name);

                        if (clientSocket != null) {
                            try {
                                IStock stock1 = new Stock(stock.getName(), stock.getQuantity(), stock.getPrice());

                                clientSocket.write(new DataWrapper("update", "I", stock1));

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }


                } else {
                    System.out.println("stock is null in admin!");
                }

            } else if (command.equals("D")) {
                //decrease stock price
                String stockName = tokens[1];
                int decreasePrice = Integer.parseInt(tokens[2]);

                IStock stock = stockList.get(stockName);

                if (stock != null) {
                    stockList.remove(stockName);
                    stock.decreasePrice(decreasePrice);
                    stockList.put(stockName, stock);
                    //notify all observers

                    List<IStockObserver> observerList = stock.getObserverList();

                    for (IStockObserver observer : observerList) {
                        String name = observer.name;
                        SocketWrapper clientSocket = clientMap.get(name);

                        if (clientSocket != null) {
                            try {
                                clientSocket.write(new DataWrapper("update", "D", stock));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }


                }

            } else if (command.equals("C")) {
                //change stock count
                String stockName = tokens[1];
                int changeCount = Integer.parseInt(tokens[2]);

                IStock stock = stockList.get(stockName);

                if (stock != null) {
                    stockList.remove(stockName);
                    stock.changeCount(changeCount);
                    stockList.put(stockName, stock);
                    //notify all observers

                    List<IStockObserver> observerList = stock.getObserverList();

                    for (IStockObserver observer : observerList) {
                        String name = observer.name;
                        SocketWrapper clientSocket = clientMap.get(name);

                        if (clientSocket != null) {
                            try {
                                clientSocket.write(new DataWrapper("update", "C", stock));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }


                }

            }

        }

    }


}
