package Stock;

import Observer.IStockObserver;

public class Stock extends IStock {
    public Stock(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void subscribe(IStockObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void unSubscribe(IStockObserver observer) {
        observerList.remove(observer);
    }


}
