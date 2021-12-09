import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
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
        { // da mettere a posto, ciclo while brutto, da riscrivere.
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            selected = chooser.getSelectedFile();
            while(!this.getExtension(selected).equals("ser"))
            {
                JOptionPane.showMessageDialog(null, "File non valido, carica un file con estensione .ser.", "MessageBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
                chooser.showOpenDialog(null);
                selected = chooser.getSelectedFile();
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Errore nel getSelectedFile()");
        }
        try
        {
            fis = new FileInputStream(selected);
        }
        catch(IOException e)
        {
            System.out.println("Errore in fase di caricamento.");
        }
        catch (NullPointerException e)
        {
            System.out.println("Non è stato caricato nessun file.");
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
    public String getExtension(File file)
    {
        String path = file.toString();
        int index = path.lastIndexOf('.');
        return path.substring(index+1);
    }
}