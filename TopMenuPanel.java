import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
public class TopMenuPanel extends JPanel
{
    private JLabel l;
    private JButton save;
    private JButton load;
    public TopMenuPanel()
    {
        super();
        l = new JLabel("Menù principale");
        save = new JButton("Salva");
        load = new JButton("Carica");
        add(l);
        add(save);
        add(load);
    }
}