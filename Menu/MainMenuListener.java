package Menu;

import Graphics.BottomMenuPanel;
import SaveLoad.*;
import Table.*;
import java.awt.event.*;
public class MainMenuListener implements ActionListener
{
    private Saver s;
    private Loader l;
    public MainMenuListener(MyTableModel model, BottomMenuPanel b)
    {
        s = new Saver(model, b);
        l = new Loader(model,b);
        AutoSaver autoSaver = new AutoSaver(s,b);
        autoSaver.start(); //viene fatto partire il thread del salvataggio automatico.
    }
    public void actionPerformed(ActionEvent e)
    {
        String choice = e.getActionCommand();
        switch(choice)
        {
            case "Salva con nome":
                System.out.println("Salvataggio...");
                s.save();
                break;
            case "Salva":
                s.update_save(false);
                break;
            case "Carica":
                System.out.println("Caricamento...");
                l.load();
                break;
            default:
                break;
        }
    }
}