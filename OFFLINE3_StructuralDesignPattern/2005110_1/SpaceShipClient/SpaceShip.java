package SpaceShipClient;

import SpaceShipComponent.Passenger;
import ConcreteComponent.Crewmate;
import CrewmateDecorator.ImposterDecorator;

public class SpaceShip {
    Passenger passenger = null;

    public SpaceShip()
    {
        System.out.println("Spaceship started!");
    }

    public void Login(String name)
    {
        String name2 = name.substring(0,3);
        if(name.equalsIgnoreCase("crew"))
        {
            passenger = new Crewmate();
        }
        else if(name2.equalsIgnoreCase("imp"))
        {
            Passenger crewmate = new Crewmate();
            passenger = new ImposterDecorator(crewmate);
        }
        else{
            System.out.println("Login first!");
        }
    }

    public void Repair()
    {
        if(passenger != null)
        {
            passenger.repair();
        }
        else
        {
            System.out.println("Login first!");
        }
    }

    public void Work()
    {
        if(passenger != null)
        {
            passenger.work();
        }
        else
        {
            System.out.println("Login first!");
        }

    }

    public void Logout()
    {
        if(passenger != null)
        {
            passenger.logout();
            passenger = null;
        }
        else {
            System.out.println("Login first!");
        }
    }

}
