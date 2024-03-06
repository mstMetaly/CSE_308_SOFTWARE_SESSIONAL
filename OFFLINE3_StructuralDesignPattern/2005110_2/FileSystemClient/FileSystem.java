package FileSystemClient;

import FileSystemComponent.FileSystemComponent;
import FileSystemComposite.Drive;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileSystem {
    FileSystemComponent currentDirectory;
    List<FileSystemComponent> drives;

    public FileSystem(String name)
    {
        currentDirectory = new Drive(name);
        drives = new ArrayList<FileSystemComponent>();
    }

    //1.Changing Directory
    public void ChangeDirectory(String name)
    {
       FileSystemComponent current = null;

       for(FileSystemComponent component  : drives)
       {
           current = component.ChangeDirectory(name , component);
       }

       if(current!= null)
       {
           if(current.getType().equals("File"))
           {
               System.out.println("Sorry!the name is a file!!");
           }
           else{
               currentDirectory =current;
           }
       }
       else{
           System.out.println("No such directory exist!");
       }

    }


    //2.Details
    public void Details(String name)
    {
        for(FileSystemComponent component : drives)
        {
            component.Details(name , component);
        }
    }

    //3.Listing
    public void Listing()
    {
        currentDirectory.Listing();
    }

    //4.Delete
    public void Delete(String name)
    {
        currentDirectory.Delete(name);
    }

    //5.Recursive Delete
    public void RecursiveDelete(String name)
    {
        for(FileSystemComponent component : drives)
        {
            component.RecursiveDelete(name , component);
        }

    }

    //6.Jump to Root
    public void JumpToRoot()
    {
        currentDirectory = drives.get(0);
    }

    //7.Makedir
    public void Makedir(String name)
    {
        currentDirectory.Makedir(name);
    }

    //8.Touch
    public void  Touch(String name , int size)
    {
        currentDirectory.Touch(name , size);
    }

    //9.MakeDrive
    public void Makedrive(String name)
    {
        FileSystemComponent drive = new Drive(name);
        drives.add(drive);

        Collections.sort(drives, Comparator.comparing(fileSystemComponent -> fileSystemComponent.getName().substring(0, 1)));
    }


}
