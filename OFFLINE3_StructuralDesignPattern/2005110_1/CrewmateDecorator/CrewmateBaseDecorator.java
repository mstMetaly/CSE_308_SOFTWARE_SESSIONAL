package CrewmateDecorator;

import SpaceShipComponent.Passenger;

public class CrewmateBaseDecorator implements Passenger{
    Passenger crewmate = null;

    CrewmateBaseDecorator(Passenger crewmate)
    {
        this.crewmate = crewmate;
    }

    public void repair()
    {
        crewmate.repair();
    }

    public void work()
    {
        crewmate.work();
    }

    public void logout()
    {
        crewmate.logout();
    }
}
