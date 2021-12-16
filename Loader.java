import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class Loader extends DialogHandler
{
    private MyTableModel model;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Object tabella;
    private Object hashMap;
    private File selected;

    public Loader(MyTableModel model, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.model = model;
    }
    public void load()
    {
        try
        { 
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            selected = chooser.getSelectedFile();
            String extension = this.getExtension(selected);
            System.out.println(extension);
            if(!extension.equals("ser") && !extension.equals("ser~"))
            {
                throwErrorDialog("File non valido, carica un file con estensione .ser o .ser");
                return;
            }
        }
        catch(NullPointerException e)
        {
            throwErrorDialog("Caricamento annullato.");
            return;
        }
        try
        {
            fis = new FileInputStream(selected);
            ois = new ObjectInputStream(fis);
        }
        catch(Exception e)
        {
            throwErrorDialog("Errore in fase di caricamento.");
            return;
        }
        try
        {
            tabella = ois.readObject();
            hashMap = ois.readObject();
        }   
        catch(ClassNotFoundException | NullPointerException | IOException e)
        {
            throwErrorDialog("Errore nella lettura dell'oggetto.");
            return;
        }
        model.setTabella((Tabella)tabella);
        model.setValueTable((ValueTable)hashMap);
        model.setSaved(true);
        System.out.println(selected.toString());
        model.setCurrentSave(selected.toString());
        model.fireTableDataChanged();
    }
    public String getExtension(File file)
    {
        String path = file.toString();
        int index = path.lastIndexOf('.');
        return path.substring(index+1);
    }
}