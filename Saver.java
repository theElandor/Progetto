import javax.swing.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import javax.swing.JFileChooser;

public class Saver
{
    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private MyTableModel model;
    private BottomMenuPanel b;
    private String path;

    /**
     * Nel costruttore prendo anche il riferimento al bottom panel.
     * In tal modo, usando l'espressione b.getLog().setText() si può
     * settare il texField nello spazio apposito in basso a sinistra,
     * corrispondente al menù di log.
     */
    public Saver(MyTableModel model, BottomMenuPanel b)
    {
        this.b = b;
        this.model = model;
    }
    public void save()
    {
        try
        {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            path=chooser.getSelectedFile().getAbsolutePath()+".ser";
            fileOut = new FileOutputStream(new File(path));
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
        model.setCurrentSave(path);
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
        if(model.getSaved())
        {
            try
            {
                fileOut = new FileOutputStream(new File(model.getCurrentSave()));
                out = new ObjectOutputStream(fileOut);
                out.writeObject(model.getTabella());
                out.writeObject(model.getValueTable());
                out.close();
                fileOut.close();
            }
            catch(IOException e)
            {
                System.out.println("Errore in fase di salvataggio.");
            }
            b.getLog().setText(model.getCurrentSave()+" salvato.");
        }
        else
        {
            save();
        }
    }
}