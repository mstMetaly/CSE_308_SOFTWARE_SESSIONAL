package FileSystemComponent;

import FileSystemLeaf.File;

import java.util.Iterator;
import java.util.List;

public abstract class FileSystemComponent {
    private String name ;
    private int size;
    private String type;
    private String directory;
    private int component_count;
    private String creation_time;

    public List<FileSystemComponent>components;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public int getComponent_count() {
       return components.size();
    }

    public void setComponent_count(int component_count) {
        this.component_count = component_count;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }


    public abstract FileSystemComponent ChangeDirectory(String name, FileSystemComponent root);

    public abstract void Details(String name , FileSystemComponent root);

    public abstract void Listing();


   public abstract void Delete(String name);


    public void RecursiveDelete(String name , FileSystemComponent parent) {}

    public abstract void  Makedir(String name);

    public abstract void Touch(String name , int size);



    public void recursiveDelete(FileSystemComponent root, FileSystemComponent parent) {
        Iterator<FileSystemComponent> iterator = root.components.iterator();

        while (iterator.hasNext()) {
            FileSystemComponent component = iterator.next();

            if (component.getType().equals("File")) {
                iterator.remove();
            } else {
                // It's a folder, recursively delete its contents first
                component.recursiveDelete(component, root);
            }
        }

        // Remove the root folder after deleting its contents
        parent.components.remove(root);
    }



    public void printDetails()
    {
        System.out.println("Name: "+name);
        System.out.println("Type: "+ type);
        System.out.println("Size: "+ getSize() + "KB");
        System.out.println("Directory: "+ directory);
        System.out.println("Component Count: "+ getComponent_count());
        System.out.println("Creation time: "+ creation_time);
    }

}
