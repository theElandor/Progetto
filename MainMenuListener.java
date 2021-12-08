import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainMenuListener implements ActionListener
{
    private Saver s;
    public MainMenuListener(Tabella t, ValueTable v)
    {
        s = new Saver(t.getMat());
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salva"))
        {
            System.out.println("Salvataggio");
            s.save();
        }
        else if(e.getActionCommand().equals("Carica"))
        {
            System.out.println("Caricamento");
        }
    }
}