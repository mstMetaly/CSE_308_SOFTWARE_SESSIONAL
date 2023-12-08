package Builders;

import Shakes.Shake;

public class CoffeShakeBuilder implements Builder{
    private Shake shake = new Shake();

    @Override
    public void setShakeType() {
        shake.addShakeType("Coffe Shake");
    }

    @Override
    public void setPrice() {
        shake.setPrice(250);
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

    public Shake getCoffeShake()
    {
        return this.shake;
    }


}
