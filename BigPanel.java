import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class BigPanel extends JPanel
{
    private TablePanel p;
    private BottomMenuPanel b;
    public BigPanel()
    {
        super();
        p = new TablePanel();
        b = new BottomMenuPanel();
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
	    this.add(b, BorderLayout.SOUTH);
    }

    /**
     * Vari getter dei pannelli. Vengono usati quando altre classi devono
     * modificarli per mostrare messaggi o per interagire con i componenti
     * in essi contenuti.
     */
    public TablePanel getTablePanel(){return p;}
    public BottomMenuPanel getBottomMenuPanel(){return b;}
}