package Server;

import Stock.IStock;
import Observer.IStockObserver;
import Stock.Stock;
import Wrapper.DataWrapper;
import Wrapper.SocketWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientHandle {

    //Client.Client Request handle
    public void clientRequestHandle(String name, SocketWrapper client, HashMap<String, IStock> stockList, Admin admin) throws IOException, ClassNotFoundException {


        while (true) {
            Object data = null;

            data = client.read();

            DataWrapper dw = (DataWrapper) data;

            if (dw.command.equals("S")) {
                String stockName = (String) dw.data;
                IStock stock = stockList.get(stockName);


                if (stock != null) {
                    stockList.remove(stockName);

                    IStockObserver observer = (IStockObserver) dw.subscriber;
                    stock.subscribe(observer);
                    stockList.put(stockName, stock);

                    SocketWrapper client_socket = Admin.clientMap.get(name);

                    if (client_socket != null) {
                        System.out.println(stock);
                        Object obj = (Object) stock;

                        client_socket.write(new DataWrapper("S", "success", obj));

                    } else {
                        System.out.println("no client socket found!");
                    }

                } else {
                    SocketWrapper client_socket = Admin.clientMap.get(name);

                    client_socket.write(new DataWrapper("S", "unsuccess", "unsuccess"));

                }

            } else if (dw.command.equals("U")) {
                String stockName = (String) dw.data;
                IStock stock = stockList.get(stockName);

                if (stock != null) {
                    stockList.remove(stockName);

                    IStockObserver observer = (IStockObserver) dw.subscriber;
                    stock.unSubscribe(observer);
                    stockList.put(stockName, stock);

                    SocketWrapper client_socket = Admin.clientMap.get(name);

                    if (client_socket != null) {

                        client_socket.write(new DataWrapper("U", "success", stock));

                    } else {
                        System.out.println("No client socket found!");
                    }

                } else {

                    SocketWrapper client_socket = Admin.clientMap.get(name);

                    client_socket.write(new DataWrapper("U", "unsuccess", "unsuccess"));

                }

            } else if (dw.command.equals("V")) {
                SocketWrapper client_socket = Admin.clientMap.get(name);

                List<String> subscribedList = (List<String>) dw.subscriber;

                List<IStock> updatedList = new ArrayList<>();

                HashMap<String, IStock> allStocks = admin.getStockList();

                for (String stockName : subscribedList) {
                    IStock iStock = allStocks.get(stockName);

                    IStock newStock = new Stock(iStock.getName(), iStock.getQuantity(), iStock.getPrice());

                    if (iStock != null) {
                        updatedList.add(newStock);
                    }

                }

                if (client_socket != null) {

                    System.out.println(updatedList.size());
                    client_socket.write(new DataWrapper("V", "updatedList", updatedList));

                } else {
                    System.out.println("socket client is not found!");
                }

            }

        }

    }


}
