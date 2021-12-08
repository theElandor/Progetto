import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainMenu extends JFrame //implements ActionListener
{
    public MainMenu()
    {
        this("");
    }
    public MainMenu(String title)
    {
        super(title);
        JMenuItem m11 = new JMenuItem("Salva");
        JMenuItem m12 = new JMenuItem("Salva con nome");
        JMenuItem m13 = new JMenuItem("Carica");
        JMenu m1 = new JMenu("File");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        JMenuBar mb = new JMenuBar();
        mb.add(m1);
        this.setJMenuBar(mb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}   