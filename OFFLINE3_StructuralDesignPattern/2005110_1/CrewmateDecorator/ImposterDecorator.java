package CrewmateDecorator;

import SpaceShipComponent.Passenger;

public class ImposterDecorator extends CrewmateBaseDecorator{
    public ImposterDecorator(Passenger crewmate) {
        super(crewmate);
        System.out.println("We won\'t tell anyone; you are an imposter.");
    }

    @Override
    public void repair()
    {
        super.repair();
        System.out.println("Damaging the spaceship");
    }

    @Override
    public void work()
    {
        super.work();
        System.out.println("Trying to kill a crewmate." +
                "Successfully killed a crewmate.");
    }

    public void logout()
    {
        super.logout();
        System.out.println("See you again Comrade Imposter.");
    }
}
