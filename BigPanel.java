import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class BigPanel extends JPanel
{
    private TablePanel p;
    private TopMenuPanel m;
    private TopMenuPanel b;
    public BigPanel()
    {
        super();
        p = new TablePanel();
        m = new TopMenuPanel();
        b = new TopMenuPanel();
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
        this.add(m, BorderLayout.NORTH);
	    this.add(b, BorderLayout.SOUTH);
    }
}