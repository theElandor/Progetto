import java.io.*;
import java.util.*;
public class Saver
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private MyTableModel model;
    public Saver(MyTableModel model)
    {
        this.model = model;
    }
    public void save()
    {
        try
        {
            fileOut = new FileOutputStream(new File("./backup.ser"));
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di salvataggio.");
        }
        try
        {
            out = new ObjectOutputStream(fileOut);
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di salvataggio.");
        }
        try
        {
            out.writeObject(model.getTabella());
            out.writeObject(model.getValueTable());
        }
        catch(IOException e)
        {
            System.out.println("Errore in scrittura.");
            System.out.println(e);
        }
        try
        {
            out.flush();
            out.close();
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di chiusura");
        }
        try
        {
            fileOut.close();
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di chiusura");
        }
    }
}