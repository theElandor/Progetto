import javax.swing.*;
import java.io.*;
import javax.swing.JOptionPane;

import javax.swing.JFileChooser;

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
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            String path=chooser.getSelectedFile().getAbsolutePath();
            fileOut = new FileOutputStream(new File(path+".ser"));
        }
        catch(Exception e)
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
        model.setSaved(true); //dico al modello che è già stato salvato.
        JOptionPane.showMessageDialog(null, "File salvato correttamente.", "MessageBox: " + "FileSavedCorrectly", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Se il file non è ancora stato salvato allora
     * viene chiamato il metodo "save()". Altrimenti
     * viene sovrascritto il vecchio salvataggio, come
     * in excel.2
     */
    public void update_save()
    {

    }
}