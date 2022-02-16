package Menu;

import Graphics.BottomMenuPanel;
import SaveLoad.*;
import Table.*;
import java.awt.event.*;
/**
 * Classe Listener del Menù principale.
 * Serve per rendere funzionali i pulsanti creati nel MainMenu.<br>
 */
public class MainMenuListener implements ActionListener
{
    private Saver s;
    private Loader l;
    /**
     * Costruttore della classe.<br>
     * Crea i due oggetti (Saver e Loader) che eseguono le operazioni di lettura e scrittura su file.<br>
     * Crea un'istanza della classe AutoSaver, che si occupa di gestire il salvataggio automatico della sessione corrente.<br>
     */
    public MainMenuListener(MyTableModel model, BottomMenuPanel b)
    {
        s = new Saver(model, b);
        l = new Loader(model,b);
        AutoSaver autoSaver = new AutoSaver(s,b);
        autoSaver.start(); //viene fatto partire il thread del salvataggio automatico.
    }
    /**
     * Metodo che si occupa della gestione dell'ActionEvent.<br>
     * In base al pulsante premuto, vengono invocati i metodi corrispondenti del Loader o del Saver.
     * @param e Oggetto ActionEvent che corrisponde al tasto premuto.<br>
     */
    public void actionPerformed(ActionEvent e)
    {
        String choice = e.getActionCommand();
        switch(choice)
        {
            case "Salva con nome":
                s.save();
                break;
            case "Salva":
                s.update_save(false);
                break;
            case "Carica":
                l.load();
                break;
            default:
                break;
        }
    }
}
