package Builders;

import Shakes.Shake;

public class ChocolateShakeBuilder implements Builder{

    private Shake shake = new Shake();

    @Override
    public void setShakeType() {
        shake.addShakeType("Chocolate Shake");
    }

    @Override
    public void setPrice() {
        shake.setPrice(230);
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

    public void addIngredients(String ingredient)
    {
       this.shake.addIngredient(ingredient);
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

    public Shake getChocolateShake()
    {
        return this.shake;
    }


}
