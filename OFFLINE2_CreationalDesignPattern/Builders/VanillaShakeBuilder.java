package Builders;

import Shakes.Shake;

public class VanillaShakeBuilder implements Builder {
    private Shake shake = new Shake();

    @Override
    public void setShakeType() {
        shake.addShakeType("Vanilla Shake");
    }

    @Override
    public void setPrice() {
        shake.setPrice(190);
    }

    @Override
    public void addMilk() {
        this.shake.addCustomIngredient("Milk");
    }

    @Override
    public void makeLactoseFree() {
        this.shake.addIngredient("Almond milk");
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

    public Shake getVanillaShake()
    {
        return this.shake;
    }
}
