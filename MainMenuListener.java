import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainMenuListener implements ActionListener
{
    private Saver s;
    private Loader l;
    public MainMenuListener(MyTableModel model)
    {
        s = new Saver(model);
        l = new Loader(model);
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
            s.update_save();
        }
    }
}