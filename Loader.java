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
    /**
     * Metodo che svolge la funzionalita' principale della classe.
     * Ritorna false se esce con errore, se invece il caricamento avviene 
     * correttamente ritorna true.
     */
    public boolean load()
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
                throwErrorDialog("File non valido, carica un file con estensione .ser o .ser~");
                return false;
            }
        }
        catch(NullPointerException e)
        {
            throwErrorDialog("Caricamento annullato.");
            return false;
        }
        try
        {
            fis = new FileInputStream(selected);
            ois = new ObjectInputStream(fis);
        }
        catch(Exception e)
        {
            throwErrorDialog("Errore in fase di caricamento.");
            return false;
        }
        try
        {
            tabella = ois.readObject();
            hashMap = ois.readObject();
        }   
        catch(ClassNotFoundException | NullPointerException | IOException e)
        {
            throwErrorDialog("Errore nella lettura dell'oggetto.");
            return false;
        }
        model.setTabella((Tabella)tabella);
        model.setValueTable((ValueTable)hashMap);
        model.setSaved(true);
        System.out.println(selected.toString());
        model.setCurrentSave(selected.toString());
        model.fireTableDataChanged();
        return true;

    }
    public String getExtension(File file)
    {
        String path = file.toString();
        int index = path.lastIndexOf('.');
        return path.substring(index+1);
    }
}