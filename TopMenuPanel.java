import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
public class TopMenuPanel extends JPanel
{
    private JLabel l;
    public TopMenuPanel()
    {
        super();
        l = new JLabel("Top Space");
        add(l);
    }
}