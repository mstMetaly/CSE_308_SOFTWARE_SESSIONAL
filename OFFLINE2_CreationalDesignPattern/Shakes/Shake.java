package Shakes;

import java.util.ArrayList;

public  class Shake {
        private  String shakeType;
        private double price;

        private double extraPrice;
        private ArrayList<String> ingredientList = new ArrayList<String>();
        private ArrayList<String> customIngredientList = new ArrayList<String>();


        public Shake()
        {

        }


        public String getShakeType() {
            return shakeType;
        }

        public void addShakeType(String type)
        {
        this.shakeType = type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price)
         {
        this.price = price;
        }

        public double getExtraPrice()
        {
            return this.extraPrice;
        }

        public void setExtraPrice(double price)
        {
            this.extraPrice += price;
        }

        public void addIngredient(String ingredient)
        {
            ingredientList.add(ingredient);
        }

        public void addCustomIngredient(String ingredient)
        {
            customIngredientList.add(ingredient);
        }
        public void print(){
            System.out.println("\tName : "+shakeType);

            System.out.println("\tIngredients : ");
            System.out.println("\t\tBase Ingredients:");
            for(String ingredient : ingredientList)
            {
                System.out.println("\t\t-->"+ingredient);
            }
            if(customIngredientList.size()!= 0)
            {
                System.out.println("\t\tCustomized Ingredients : ");
                for(String custom : customIngredientList)
                {
                    System.out.println("\t\t-->"+custom);
                }
                System.out.println("\tRegular price : "+price);
                for(String custom : customIngredientList)
                {
                    if(custom.equalsIgnoreCase("Almond milk"))
                    {
                        System.out.println("\tSugar free : "+60 );
                    }
                    else if(custom.equalsIgnoreCase("Candy on top"))
                    {
                        System.out.println("\tCandy added on top  : "+50 );
                    }
                    else if(custom.equalsIgnoreCase("Cookie on top"))
                    {
                        System.out.println("\tCookie added on top : "+40);
                    }
                }
                System.out.println("\tIncreased Price : "+(price+extraPrice));

            }
            else{
                System.out.println("\tRegular price : "+ price);
            }

        }

}
