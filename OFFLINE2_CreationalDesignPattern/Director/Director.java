package Director;

import Builders.Builder;

public class Director {

    Builder shakeBuilder;
    boolean normalMilk = true;
    public void constructChocolateShake(Builder builder)
    {
        shakeBuilder = builder;
        shakeBuilder.setShakeType();
        shakeBuilder.setPrice();
        shakeBuilder.addIngredients("Sugar");
        shakeBuilder.addIngredients("Chocolate syrup");
        shakeBuilder.addIngredients("Chocolate ice cream");
        if(normalMilk)
        {
            shakeBuilder.addMilk();
        }
    }

    public void constructCoffeShake(Builder builder)
    {
        shakeBuilder = builder;
        shakeBuilder.setShakeType();
        shakeBuilder.setPrice();
        shakeBuilder.addIngredients("Sugar");
        shakeBuilder.addIngredients("Coffe");
        shakeBuilder.addIngredients("Jello");
        if(normalMilk)
        {
            shakeBuilder.addMilk();
        }
    }

    public void constructStrawberryShake(Builder builder)
    {
        shakeBuilder = builder;
        shakeBuilder.setShakeType();
        shakeBuilder.setPrice();
        shakeBuilder.addIngredients("Sugar");
        shakeBuilder.addIngredients("Strawberry syrup");
        shakeBuilder.addIngredients("Strawberry ice cream");
        if(normalMilk)
        {
            shakeBuilder.addMilk();
        }
    }

    public  void constructVanillaShake(Builder builder){
        shakeBuilder = builder;
        shakeBuilder.setShakeType();
        shakeBuilder.setPrice();
        shakeBuilder.addIngredients("Sugar");
        shakeBuilder.addIngredients("Vanilla flavoring");
        shakeBuilder.addIngredients("jello");
        if(normalMilk)
        {
            shakeBuilder.addMilk();
        }
    }

    public void constructZeroShake(Builder builder)
    {
        shakeBuilder = builder;
        shakeBuilder.setShakeType();
        shakeBuilder.setPrice();
        shakeBuilder.addIngredients("sweetener");
        shakeBuilder.addIngredients("vanilla flavoring");
        shakeBuilder.addIngredients("sugar-free jello");
        if(normalMilk)
        {
            shakeBuilder.addMilk();
        }
    }

    public void customizeShake(Builder builder , String[] customInput)
    {
        this.shakeBuilder  = builder;
        for(String custom : customInput)
        {
            if(custom.equalsIgnoreCase("1")){
                shakeBuilder.makeLactoseFree();
                normalMilk =  false;
            }
            else if(custom.equalsIgnoreCase("2"))
            {
                shakeBuilder.addCandyOnTop();
            } else if (custom.equalsIgnoreCase("3")) {
                shakeBuilder.addCookieOnTop();
            }
        }
    }


}
