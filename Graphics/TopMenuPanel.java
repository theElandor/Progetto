package Graphics;

import javax.swing.JPanel;
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