package Graphics;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Classe che contiene i due pannelli principali del foglio di calcolo, ossia il Graphics.TablePanel e il Graphics.BottomMenuPanel.<br>
 * Sono presenti i getter dei due parametri della classe, usati per interagire direttamente coi pannelli interessati.
 */
public class BigPanel extends JPanel
{
    private TablePanel p;
    private BottomMenuPanel b;
    /**
     * Costruttore della classe.
     * Aggiunge il pannello che contiene la tabella, e un pannello inferiore che contiene
     * la finestra di log.<br>
     */
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
