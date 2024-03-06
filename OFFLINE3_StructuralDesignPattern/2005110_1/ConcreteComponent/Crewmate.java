package ConcreteComponent;

import SpaceShipComponent.Passenger;

public class Crewmate implements Passenger {

    public Crewmate()
    {
        System.out.println("Welcome Crewmate!");
    }
    public void repair()
    {
        System.out.println("Repairing the spaceship.");
    }

    public void work()
    {
        System.out.println("Doing research");
    }

    public void logout()
    {
        System.out.println("Bye Bye crewmate.");
    }
}
