import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
/**
 * Classe che contiene i due pannelli principali del foglio di calcolo, ossia il TablePanel e il BottomMenuPanel.
 * Sono presenti i getter dei due parametri della classe, usati per interagire direttamente coi pannelli interessati.
 */
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
    public TablePanel getTablePanel(){return p;}
    public BottomMenuPanel getBottomMenuPanel(){return b;}
}