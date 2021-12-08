import java.io.*;
import java.util.*;
public class Saver
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private ArrayList<ArrayList<Cell>> mat;
    public Saver(ArrayList<ArrayList<Cell>> mat)
    {
        this.mat = mat;
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
            out.writeObject(mat);
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