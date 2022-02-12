package SaveLoad;

import java.io.*;
import javax.swing.JFileChooser;
import Graphics.DialogHandler;
import Graphics.BottomMenuPanel;
import Table.*;
import Cells.ValueTable;
/**
 * Classe che gestisce il caricamento dei file di salvataggio.
 */
public class Loader extends DialogHandler
{
    private MyTableModel model;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Object tabella;
    private Object hashMap;
    private File selected;
    /**
     * Costruttore della classe.
     * @param model Il TableModel attualmente in uso, che verrà sovrascritto.
     * @param logPanel Il Pannello inferiore per mostrare messaggi di controllo.
     */
    public Loader(MyTableModel model, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.model = model;
    }
    /**
     * Metodo che svolge la funzionalita' principale della classe.<br>
     * Ritorna false se esce con errore, se invece il caricamento avviene 
     * correttamente ritorna true.<br>
     * Fa uso di un JFileChooser per far scegliere all'utente il file da caricare,
     * poi esegue i controlli sull'estensione.<br>
     * Sono consentiti soltanto file con estensione .ser o -ser~.<br>
     * Legge da file le due strutture dati fondamentali, cioè la tabella delle celle e 
     * la Cells.ValueTable contenente i valori numerici.<br>
     * Se la lettura avviene con successo, le due strutture dati vengono inserite all'interno del
     * TableModel.<br>
     * Vengono poi salvate due informazioni: il path del salvataggio corrispondente alla corrente istanza
     * della tabella, e un booleano che indica l'esistenza di questo salvataggio, per semplicità.
     * In tal modo quando il SaveLoad.Saver dovrà effettuare delle operazioni di salvataggio, dovrà soltanto leggere quella
     * stringa.<br>
     * Inoltre l'SaveLoad.AutoSaver effettuerà un salvataggio di backup soltanto se l'attuale istanza della tabella è già stata
     * salvata.(Può facilmente ottenere questa informazione valutando se il booleano è True / False).<br>
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
        model.setCurrentSave(selected.toString());
        model.fireTableDataChanged();
        return true;

    }
    /**
     * @param file File caricato.
     * @return Stringa corrispondente all'estensione del file.
     */
    public String getExtension(File file)
    {
        String path = file.toString();
        int index = path.lastIndexOf('.');
        return path.substring(index+1);
    }
}
