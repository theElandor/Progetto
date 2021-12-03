import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class MyFrame extends JFrame
{
    private TablePanel p;
    private TopMenuPanel m;
    private TopMenuPanel b;
    private JScrollPane pane;
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
	b = new TopMenuPanel();
	pane = new JScrollPane(p);
        this.setLayout(new BorderLayout());
        this.add(pane, BorderLayout.CENTER);
        this.add(m, BorderLayout.NORTH);
	this.add(b, BorderLayout.SOUTH);
    }
}
