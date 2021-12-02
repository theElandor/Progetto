import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class MyFrame extends JFrame
{
    private TablePanel p;
    private TopMenuPanel m;
    public MyFrame()
    {
        this("");
    }
    public MyFrame(String titolo)
    {
        super(titolo);
        setBounds(0,0,1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p = new TablePanel();
        m = new TopMenuPanel();
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
        this.add(m, BorderLayout.NORTH);
    }
}