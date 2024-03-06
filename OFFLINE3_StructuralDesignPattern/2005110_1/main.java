import SpaceShipClient.SpaceShip;

import java.util.Scanner;

public class main {
        public static void main(String[] args) {

            SpaceShip spaceShip = new SpaceShip();

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine())
            {
                String commandLine = scanner.nextLine();

                String[] commandArr = commandLine.split(" ");

                String command = commandArr[0];

                switch (command.trim())
                {
                    case "login":
                    {
                        String userName =  commandArr[1];
                        String name = userName.substring(0,4);
                        spaceShip.Login(name);
                        break;
                    }

                    case "repair":
                    {
                       spaceShip.Repair();
                        break;
                    }

                    case "work":
                    {
                       spaceShip.Work();
                       break;
                    }

                    case "logout":
                    {
                        spaceShip.Logout();
                        break;
                    }
                }
            }
        }

}
