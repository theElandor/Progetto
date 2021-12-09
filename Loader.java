import java.io.*;
import java.util.*;
public class Loader
{
    private MyTableModel model;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Object tabella;
    private Object hashMap;
    public Loader(MyTableModel model)
    {
        this.model = model;
    }
    public void load()
    {
        try
        {
            fis = new FileInputStream(new File("./backup.ser"));
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di caricamento.");
        }
        try
        {
            ois = new ObjectInputStream(fis);
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di creazione dell'o.i.s");
        }
        try
        {
            tabella = ois.readObject();
            hashMap = ois.readObject();
        }   
        catch(ClassNotFoundException c)
        {
            System.out.println("Errore nella lettura dell'oggetto.");
        }
        catch(IOException e)
        {
            System.out.println("Class not found");
        }
        model.setTabella((Tabella)tabella);
        model.setValueTable((ValueTable)hashMap);
        model.fireTableDataChanged();
    }
}