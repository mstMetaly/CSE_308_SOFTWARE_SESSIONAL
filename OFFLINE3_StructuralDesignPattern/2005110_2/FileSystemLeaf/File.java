package FileSystemLeaf;

import FileSystemComponent.FileSystemComponent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class File extends FileSystemComponent {

    public File(String name , int size)
    {
        super.setName(name);
        super.setType("File");
        super.setSize(size);
        super.setDirectory("");
        super.setComponent_count(0);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String time = dateFormat.format(currentDate);
        super.setCreation_time(time);

        components = new ArrayList<FileSystemComponent>();
    }


    @Override
    public FileSystemComponent ChangeDirectory(String name, FileSystemComponent root) {
        return null;
    }
    @Override
    public void Details(String name , FileSystemComponent root) {
        System.out.println(super.getName() + "." + super.getType() + "    "+ super.getSize() + "      " + super.getCreation_time());
    }

    public void Listing(){}

    public  void Delete(String name){}

    public void RecursiveDelete(String name , FileSystemComponent parent) {}

    public void Makedir(String name) {}

    public void Touch(String name , int size) {}

}
