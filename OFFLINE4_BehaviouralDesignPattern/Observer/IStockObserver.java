package Observer;

import Stock.IStock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class IStockObserver implements Serializable {
    public List<String> subscribedList = new ArrayList<>();

    public String name;

    public abstract void update(IStock stock);

    public abstract void view(IStock stock);
}
