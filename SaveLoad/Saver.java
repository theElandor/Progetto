package SaveLoad;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import Table.*;
import Graphics.DialogHandler;
import Graphics.BottomMenuPanel;

/**
 * Classe che gestisce il salvataggio del foglio di calcolo.<br>
 */
public class Saver extends DialogHandler
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private MyTableModel model;
    private String path;
    /**
     * Costruttore della classe.<br>
     * Viene chiamato il costruttore della superclasse e viene salvato il riferimento al model dal salvare.<br>
     */
    public Saver(MyTableModel model, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.model = model;
    }
    /**
     * Getter del model.
     * @return model riferimento al parametro model.
     */
    public MyTableModel getModel() {return model;}
    
    /**
     * Metodo che gestisce il salvataggio.<br>
     * Viene usato un'oggetto di tipo JFileChooser per far scegliere all'utente il percorso
     * in cui salvare il file. <br>
     * Vengono fatti diversi controlli sullo stato di avanzamento del salvataggio, in modo da
     * segnalare all'utente il tipo di errore che si è verificato.<br>
     * Alla fine del salvataggio viene impostato l'attributo saved del modello a true, e viene
     * anche salvato il path del salvataggio.<br>
     * @return esito del salvataggio.
     */
    public boolean save()
    {
        try
        {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser",".ser~");
            chooser.setFileFilter(filter);
            chooser.showSaveDialog(null);
            path=chooser.getSelectedFile().getAbsolutePath()+".ser";
            File temp = new File(path);
            if(temp.exists() && !temp.isDirectory())
            {
                int n = JOptionPane.showConfirmDialog(null, "Il file "+path+" esiste già. Sovrascrivere il file?", "Conferma Salvataggio", JOptionPane.YES_NO_OPTION);
                if(n == 1)
                    return false;
            }
        }
        catch(NullPointerException e)
        {
            throwErrorDialog("Salvataggio annullato.");
            return false;
        }
        try
        {
            fileOut = new FileOutputStream(new File(path));
            out = new ObjectOutputStream(fileOut);
        }
        catch(Exception e)
        {
            throwErrorDialog("Errore in fase di salvataggio del file.");
            return false;
        }
        try
        {
            out.writeObject(model.getTabella());
            out.writeObject(model.getValueTable());
        }
        catch(IOException e)
        {
            throwErrorDialog("Errore in fase di scrittura.");
            System.out.println(e);
            return false;
        }
        try
        {
            out.flush();
            out.close();
            fileOut.close();
        }
        catch(IOException e)
        {
            throwErrorDialog("Errore in fase di chiusura");
        }
        model.setSaved(true);
        model.setCurrentSave(path);
        JOptionPane.showMessageDialog(null, "File salvato correttamente.", "MessageBox: " + "FileSavedCorrectly", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    /**
     * Classe che gestisce la funzione del menù "Salva" e il salvataggio automatico.<br>
     * Se il file non e' ancora stato salvato allora viene chiamato il metodo save, altrimenti viene sovrascritto
     * il vecchio salvataggio.<br>
     * Backup viene passato come true se il metodo e' chiamato
     * dall'autosaver, altrimenti false.<br>
     * In questo modo uso lo stesso metodo per due casistiche diverse,
     * usando un parametro di supporto.<br>
     * Se Backup e' false, allora la funzione sovrascrive il salvataggio
     * precedente.<br> Se Backup e' true, allora la funzione crea un nuovo
     * file dal nome "model.getCurrentSave()+~".<br> La funzione
     * update_save viene chiamata automaticamente da un thread
     * ogni 30(10) secondi con il parametro Backup = true, in modo
     * da simulare un salvataggio automatico, utile in caso di crash.
     * @return esito del salvataggio.
     */
    public boolean update_save(boolean Backup)
    {
        if(model.getSaved())
        {
            if(!Backup) // se il metodo e' chiamato dall'autoSaver, allora non devo chiedere conferma all'utente.
            {
                int n = JOptionPane.showConfirmDialog(null, "Il file "+model.getCurrentSave()+" sta per essere sovrascritto. Continuare?", "Conferma Salvataggio", JOptionPane.YES_NO_OPTION);
                if(n == 1)
                    return false;
            }
            try
            {
                if(!Backup)
                    fileOut = new FileOutputStream(new File(model.getCurrentSave()));
                else
                    fileOut = new FileOutputStream(new File(model.getCurrentSave()+"~"));

                out = new ObjectOutputStream(fileOut);
                out.writeObject(model.getTabella());
                out.writeObject(model.getValueTable());
                out.close();
                fileOut.close();
            }
            catch(IOException e)
            {
                throwErrorDialog("Errore in fase di salvataggio.");
                return false;
            }
            writeLog(model.getCurrentSave()+" salvato.");
            return true;
        }
        else
        {
            return save();
        }
    }
}








