package Stock;

import Observer.IStockObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class IStock implements Serializable {
    protected List<IStockObserver> observerList = new ArrayList<>();
    protected String name;
    protected int quantity;
    protected double price;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public abstract void subscribe(IStockObserver observer);

    public abstract void unSubscribe(IStockObserver observer);

    public void increasePrice(int price) {
        this.price += price;
    }

    public void decreasePrice(int price) {
        this.price -= price;
    }

    public void changeCount(int count) {
        this.quantity = count;
    }

    public List<IStockObserver> getObserverList() {
        return this.observerList;
    }
}
