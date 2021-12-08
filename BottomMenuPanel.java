import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
public class BottomMenuPanel extends JPanel
{
    private JLabel l;
    public BottomMenuPanel()
    {
        super();
        l = new JLabel("Bottom Space");
        add(l);
    }
}
