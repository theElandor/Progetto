import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
public class Loader
{
    private MyTableModel model;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Object tabella;
    private Object hashMap;
    private File selected;

    public Loader(MyTableModel model)
    {
        this.model = model;
    }
    public void load()
    {
        try
        {
            JFileChooser chooser = new JFileChooser();
            System.out.println("Ho creato il file chooser");
            selected = chooser.getSelectedFile();
            System.out.println("Ho eseguto il selected");
        }
        catch(NullPointerException e)
        {
            System.out.println("Erore nel getSelectedFile()");
        }
        try
        {
            fis = new FileInputStream(selected);
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