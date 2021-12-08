import java.io.*;
import java.util.*;
public class Saver
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private Tabella t;
    public Saver(Tabella t)
    {
        this.t = t;
    }
    public void save()
    {
        try
        {
            fileOut = new FileOutputStream("./backup.ser");
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
            out.writeObject(t);
        }
        catch(IOException e)
        {
            System.out.println("Errore in scrittura.");
            System.out.println(e);
        }
        try
        {
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