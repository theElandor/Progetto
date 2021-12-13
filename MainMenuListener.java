
import javax.swing.*;
import java.awt.event.*;
public class MainMenuListener implements ActionListener
{
    private Saver s;
    private Loader l;
    public MainMenuListener(MyTableModel model, BottomMenuPanel b)
    {
        s = new Saver(model, b);
        l = new Loader(model);
        AutoSaver autoSaver = new AutoSaver(s,b);
        autoSaver.start(); // faccio partire il thread del salvataggio automatico.
    }
    public void actionPerformed(ActionEvent e)
    {
        // meglio fare uno switch case.
        // creando una variabile di appoggio.
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Salva con nome"))
        {
            System.out.println("Salvataggio");
            s.save();
        }
        else if(e.getActionCommand().equals("Carica"))
        {
            System.out.println("Caricamento");
            l.load();
        }
        else if(e.getActionCommand().equals("Salva"))
        {
            s.update_save(false);
        }
        else if(e.getActionCommand().equals("Ordina colonne..."))
        {
            Object[] possibilities = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            Character c = (Character)JOptionPane.showInputDialog(null, "Seleziona una colonna...", "MessageBox: " + "ColumnChooser", JOptionPane.INFORMATION_MESSAGE, null,possibilities,"Colonne");
            // c viene preso correttamente.

        }
    }
}