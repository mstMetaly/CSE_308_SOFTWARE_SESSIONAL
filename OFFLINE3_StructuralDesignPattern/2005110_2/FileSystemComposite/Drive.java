package FileSystemComposite;

import FileSystemComponent.FileSystemComponent;
import FileSystemLeaf.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Drive extends FileSystemComponent {

    public Drive(String name)
    {
        super.setName(name);
        super.setType("Drive");
        super.setDirectory(name + ":/");
        super.setComponent_count(0);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String time = dateFormat.format(currentDate);
        super.setCreation_time(time);
        components = new ArrayList<FileSystemComponent>();

    }

    public int getSize()
    {
        if(super.getType().equals("File"))
        {
            return super.getSize();
        }

        int totalSize =0 ;

        for(FileSystemComponent component : components)
        {
            totalSize+= component.getSize();
        }
        return totalSize;
    }


    public  FileSystemComponent ChangeDirectory(String name, FileSystemComponent root) {

        if(root.getName().equals(name))
            return root;

        for(FileSystemComponent component : root.components)
        {
            FileSystemComponent result = component.ChangeDirectory(name, component);
            if (result != null) {
                return result;
            }
        }
        return null;
    }


    @Override
    public void Details(String name , FileSystemComponent root) {

       if(root.getName().equals(name))
       {
           root.printDetails();
           return;
       }

       for(FileSystemComponent component : components)
       {
           if(component.getClass().getName().equals("FileSystemLeaf.File"))
           {
               continue;
           }
           else {
               component.Details(name , component);
           }
       }

    }


    public void Listing()
    {
        for(FileSystemComponent component: components)
        {
            System.out.println(component.getName() + "      "+ component.getSize() + "      "+ component.getCreation_time());
        }
    }

    public  void Delete(String name){
        int index =0;
        for(FileSystemComponent component : components)
        {
            if(component.getName().equals(name))
            {
                if(component.getClass().getName().equals("FileSystemLeaf.File"))
                {
                    components.remove(index);
                }
                else{
                    int comSize = component.getComponent_count();
                    if(comSize==0)
                    {
                        components.remove(index);
                    }
                    else{
                        System.out.println("Can't delete!");
                    }
                }
            }
            index++;
        }
    }


    public void RecursiveDelete(String name , FileSystemComponent parent)
    {
        for(FileSystemComponent component : parent.components)
        {
            if(component.getName().equals(name))
            {
                if(component.getType().equals("File"))
                {
                    System.out.println("Warning!!!!!!!");
                    parent.Delete(name);
                }
                else{
                    component.recursiveDelete(component , parent);
                }
                return;
            }

            else{
                if(component.getType().equals("File"))
                    continue;
                component.RecursiveDelete(name , component);
            }
        }
    }


    public void Makedir(String name)
    {
        FileSystemComponent folder = new Folder(name);
        folder.setDirectory(super.getDirectory());
        components.add(folder);
    }

    public void Touch(String  name , int size)
    {
        FileSystemComponent file = new File(name , size);
        file.setDirectory(super.getDirectory());
        components.add(file);
    }


}
