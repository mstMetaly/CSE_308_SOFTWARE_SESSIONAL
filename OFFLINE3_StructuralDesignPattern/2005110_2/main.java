import FileSystemClient.FileSystem;
import FileSystemLeaf.File;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        FileSystem fileSystem = new FileSystem("This PC");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine())
        {
            String commandLine = scanner.nextLine();

            String[] commandArr = commandLine.split(" ");

            String command = commandArr[0];

            switch (command.trim())
            {
                case "cd":
                {
                    String name = commandArr[1];
                    if(name.equals("~"))
                    {
                        fileSystem.JumpToRoot();
                    }
                    else{
                        String nameArr[] = name.split(":");
                        name = nameArr[0];
                        fileSystem.ChangeDirectory(name);
                    }

                    break;
                }

                case "ls":{
                    String name = commandArr[1];
                    fileSystem.Details(name);
                    break;
                }

                case "list":{
                    fileSystem.Listing();
                    break;
                }

                case "delete":{
                    String  check = commandArr[1];

                    if(check.equals("-r"))
                    {
                        String name = commandArr[2];
                        fileSystem.RecursiveDelete(name);
                        break;
                    }
                    else
                    {
                        fileSystem.Delete(check);
                        break;
                    }

                }

                case "mkdir":{
                    String  name = commandArr[1];
                    fileSystem.Makedir(name);
                    break;
                }

                case "touch":{
                    String name = commandArr[1];
                    int size = Integer.parseInt(commandArr[2]);
                    fileSystem.Touch(name ,size);
                    break;
                }

                case "mkdrive":{
                    String  name = commandArr[1];
                    fileSystem.Makedrive(name);
                    break;
                }
                default:{
                    System.out.println("Wrong command line!");
                }

            }

        }


    }

}
