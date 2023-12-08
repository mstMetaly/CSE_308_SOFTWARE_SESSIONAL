import Builders.*;
import Director.Director;
import Shakes.Shake;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {


        Director director = new Director();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Order Shake!!!");
        System.out.println("1. 'Press 'o' for giving an order ");
        System.out.println("2.  Press 'e' to close the order.....\n");

        boolean currentOrder = false;
        ArrayList<Shake>orderList = new ArrayList<Shake>();

        while(true)
        {
            String choice = scanner.nextLine();

            switch (choice.trim())
            {
                case "o":
                {
                        currentOrder=true;

                        System.out.println(".....Now you can order!!.....");
                        System.out.println("Select as S1/S2/S3 like this way...... ");
                        System.out.println("\tS1. Chocolate  Shake");
                        System.out.println("\tS2. Coffee Shake");
                        System.out.println("\tS3. Strawberry Shake");
                        System.out.println("\tS4. Vanilla Shake");
                        System.out.println("\tS5. Zero Shake");

                        while (currentOrder) {
                            String order = scanner.nextLine().trim();

                            switch (order) {

                                case "S1": {
                                    ChocolateShakeBuilder chocolateBuilder = new ChocolateShakeBuilder();

                                    System.out.println("Do you want to customize??(yes/no)");
                                    String answer = scanner.next();

                                    if(answer.equalsIgnoreCase("Yes"))
                                    {
                                        String lineChange = scanner.nextLine();
                                        System.out.println("Enter customization options (comma-separated): ");
                                        System.out.println("\t1. Make lactose free");
                                        System.out.println("\t2. Add candy on top");
                                        System.out.println("\t3. Add cookies on top");

                                        String line = scanner.nextLine();
                                        String[] customInput = line.split(",");

                                        director.customizeShake(chocolateBuilder,customInput);
                                        System.out.println("Order for customized Chocolate Shake placed....");
                                    }
                                    else
                                    {
                                        System.out.println("Order for regular Chocolate Shake placed....");
                                    }

                                    director.constructChocolateShake(chocolateBuilder);
                                    Shake chocolateShake = chocolateBuilder.getChocolateShake();
                                    orderList.add(chocolateShake);
                                    break;
                                }


                                case "S2": {
                                    CoffeShakeBuilder coffeShakeBuilder = new CoffeShakeBuilder();

                                    System.out.println("Do you want to customize??(yes/no)");
                                    String answer = scanner.next();

                                    if(answer.equalsIgnoreCase("Yes"))
                                    {
                                        String lineChange = scanner.nextLine();
                                        System.out.println("Enter customization options (comma-separated): ");
                                        System.out.println("\t1. Make lactose free");
                                        System.out.println("\t2. Add candy on top");
                                        System.out.println("\t3. Add cookies on top");

                                        String line = scanner.nextLine();
                                        String[] customInput = line.split(",");

                                        director.customizeShake(coffeShakeBuilder,customInput);
                                        System.out.println("Order for customized Coffe Shake placed....");
                                    }
                                    else
                                    {
                                        System.out.println("Order for regular Coffe Shake placed....");
                                    }

                                    director.constructChocolateShake(coffeShakeBuilder);
                                    Shake coffeShake = coffeShakeBuilder.getCoffeShake();
                                    orderList.add(coffeShake );
                                    break;
                                }


                                case "S3": {
                                    StrawberryShakeBuilder strawberryShakeBuilder = new StrawberryShakeBuilder();

                                    System.out.println("Do you want to customize??(yes/no)");
                                    String answer = scanner.next();

                                    if(answer.equalsIgnoreCase("Yes"))
                                    {
                                        String lineChange = scanner.nextLine();
                                        System.out.println("Enter customization options (comma-separated): ");
                                        System.out.println("\t1. Make lactose free");
                                        System.out.println("\t2. Add candy on top");
                                        System.out.println("\t3. Add cookies on top");

                                        String line = scanner.nextLine();
                                        String[] customInput = line.split(",");

                                        director.customizeShake(strawberryShakeBuilder, customInput);
                                        System.out.println("Order for customized Coffe Shake placed....");
                                    }
                                    else
                                    {
                                        System.out.println("Order for regular Coffe Shake placed....");
                                    }

                                    director.constructChocolateShake(strawberryShakeBuilder);
                                    Shake strawberryShake = strawberryShakeBuilder.getStrawberryShake();
                                    orderList.add(strawberryShake );
                                    break;
                                }


                                case "S4": {
                                    VanillaShakeBuilder vanillaShakeBuilder = new VanillaShakeBuilder();

                                    System.out.println("Do you want to customize??(yes/no)");
                                    String answer = scanner.next();

                                    if(answer.equalsIgnoreCase("Yes"))
                                    {
                                        String lineChange = scanner.nextLine();
                                        System.out.println("Enter customization options (comma-separated): ");
                                        System.out.println("\t1. Make lactose free");
                                        System.out.println("\t2. Add candy on top");
                                        System.out.println("\t3. Add cookies on top");

                                        String line = scanner.nextLine();
                                        String[] customInput = line.split(",");

                                        director.customizeShake(vanillaShakeBuilder, customInput);
                                        System.out.println("Order for customized Coffe Shake placed....");
                                    }
                                    else
                                    {
                                        System.out.println("Order for regular Coffe Shake placed....");
                                    }


                                    director.constructChocolateShake(vanillaShakeBuilder);
                                    Shake vanillaShake = vanillaShakeBuilder.getVanillaShake();
                                    orderList.add(vanillaShake );
                                    break;
                                }


                                case "S5": {
                                    ZeroShakeBuilder zeroShakeBuilder = new ZeroShakeBuilder();

                                    System.out.println("Do you want to customize??(yes/no)");
                                    String answer = scanner.next();

                                    if(answer.equalsIgnoreCase("Yes"))
                                    {
                                        String lineChange = scanner.nextLine();
                                        System.out.println("Enter customization options (comma-separated): ");
                                        System.out.println("\t1. Make lactose free");
                                        System.out.println("\t2. Add candy on top");
                                        System.out.println("\t3. Add cookies on top");

                                        String line = scanner.nextLine();
                                        String[] customInput = line.split(",");

                                        director.customizeShake(zeroShakeBuilder, customInput);
                                        System.out.println("Order for customized Coffe Shake placed....");
                                    }
                                    else
                                    {
                                        System.out.println("Order for regular Coffe Shake placed....");
                                    }

                                    director.constructChocolateShake(zeroShakeBuilder);
                                    Shake zeroShake = zeroShakeBuilder.getZeroShake();
                                    orderList.add(zeroShake );
                                    break;
                                }


                                case "e": {
                                    if (orderList.size() == 0) {
                                        System.out.println("Please order at least one shake!!");
                                    } else {
                                        System.out.println("Your order is closed. Details....\n");

                                        int orderCount = 1;
                                        double totalPrice = 0;

                                        for(Shake shake : orderList)
                                        {
                                            System.out.println("\n<Order No . "+ orderCount+">");
                                            shake.print();
                                            orderCount++;
                                            totalPrice+= (shake.getPrice()+shake.getExtraPrice());
                                        }

                                        System.out.println("\n\nTotal :" + totalPrice);
                                        orderList.clear();
                                        currentOrder = false;
                                    }

                                    break;
                                }


                                case "o":{
                                    if(currentOrder) {
                                        System.out.println("You already have an ongoing order....");
                                        break;
                                    }
                                }

                            }

                        }
                    break;

                    }

                default:{
                    System.out.println("Please follow the menu to give an order!!");
                    break;
                }


            }

        }

    }

}
