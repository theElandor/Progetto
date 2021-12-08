import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainMenuListener implements ActionListener
{
    private Saver s;
    private Loader l;
    public MainMenuListener(Tabella t, ValueTable v, MyTableModel model)
    {
        s = new Saver(t.getMat());
        l = new Loader(model);
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