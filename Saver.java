import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class Saver extends DialogHandler
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private MyTableModel model;
    private String path;

    /**
     * Nel costruttore prendo anche il riferimento al bottom panel.
     * In tal modo, usando l'espressione b.getLog().setText() si può
     * settare il texField nello spazio apposito in basso a sinistra,
     * corrispondente al menù di log.
     */
    public Saver(MyTableModel model, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.model = model;
    }
    public MyTableModel getModel()
    {
        return model;
    }
    public void save()
    {
        // Quando la save viene chiamata per la prima volta, viene
        // creato il thread che chiama l'autosave ogni X secondi.
        try
        {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            path=chooser.getSelectedFile().getAbsolutePath()+".ser";
            File temp = new File(path);
            if(temp.exists() && !temp.isDirectory())
            {
                int n = JOptionPane.showConfirmDialog(null, "Il file "+path+" esiste già. Sovrascrivere il file?", "Conferma Salvataggio", JOptionPane.YES_NO_OPTION);
                if(n == 1)
                    return;
            }
        }
        catch(NullPointerException e)
        {
            throwErrorDialog("Salvataggio annullato.");
            return;
        }
        try
        {
            fileOut = new FileOutputStream(new File(path));
            out = new ObjectOutputStream(fileOut);
        }
        catch(Exception e)
        {
            throwErrorDialog("Errore in fase di salvataggio del file.");
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
    }
    /**
     * Se il file non e' ancora stato salvato allora
     * viene chiamato il metodo "save()". Altrimenti
     * viene sovrascritto il vecchio salvataggio, come
     * in excel.
     * Se Backup e' false, allora la funzione sovrascrive il salvataggio
     * precedente. Se Backup e' true, allora la funzione crea un nuovo
     * file dal nome "model.getCurrentSave()+~". La funzione
     * update_save viene chiamata automaticamente da un thread
     * ogni 30 secondi con il parametro Backup = true, in modo
     * da simulare un salvataggio automatico, utile in caso di crash.
     */
    public void update_save(boolean Backup)
    {
        if(model.getSaved())
        {
            if(!Backup) // se il metodo è chiamato dall'autoSaver, allora non devo chiedere conferma all'utente.
            {
                int n = JOptionPane.showConfirmDialog(null, "Il file "+model.getCurrentSave()+" sta per essere sovrascritto. Continuare?", "Conferma Salvataggio", JOptionPane.YES_NO_OPTION);
                if(n == 1)
                    return;
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
            }
            writeLog(model.getCurrentSave()+" salvato.");
        }
        else
        {
            save();
        }
    }
}








