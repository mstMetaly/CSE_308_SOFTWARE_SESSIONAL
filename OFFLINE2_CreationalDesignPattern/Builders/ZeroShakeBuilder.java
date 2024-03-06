package Builders;

import Shakes.Shake;

public class ZeroShakeBuilder  implements Builder{
    private Shake shake = new Shake();

    @Override
    public void setShakeType() {
        this.shake.addShakeType("Zero Shake");
    }

    @Override
    public void setPrice() {
        this.shake.setPrice(240);
    }

    @Override
    public void addMilk() {
        this.shake.addIngredient("Milk");
    }

    @Override
    public void makeLactoseFree() {
        this.shake.addCustomIngredient("Almond milk");
        this.shake.setExtraPrice(60);
    }

    @Override
    public void addCandyOnTop() {
        this.shake.addCustomIngredient("Candy on top");
        this.shake.setExtraPrice(50);
    }

    @Override
    public void addCookieOnTop() {
        this.shake.addCustomIngredient("Cookie on top");
        this.shake.setExtraPrice(40);
    }

    public void addIngredients(String ingredient)
    {
        this.shake.addIngredient(ingredient);
    }

    public Shake getZeroShake()
    {
        return  this.shake;
    }
}
