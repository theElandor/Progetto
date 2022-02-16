package Graphics;
import javax.swing.JPanel;
import java.awt.*;
import Table.*;
/**
 * Classe personalizzata che estende JPanel.
 * Serve principalmente per contenere la tabella.<br>
 * Grazie alla classe FrozenTablePane la prima colonna viene "bloccata",
 * anche quando la tabella viene mossa orizzontalmente.<br>
 */
public class TablePanel extends JPanel
{
    private Tabella t;
    private MyTableModel dataModel;
    /**
     * Costruttore della classe.<br>
     * Vengono creati la tabella e il dataModel, e viene "bloccata" la prima colonna della tabella.
     */
    public TablePanel()
    {
        super();
        t = new Tabella();
        dataModel = new MyTableModel(t);
        MyJTable t = new MyJTable(dataModel);
        FrozenTablePane frozen = new FrozenTablePane(t,1);
        this.setLayout(new BorderLayout());
        this.add(frozen, BorderLayout.CENTER);
    }
    /**
     * Getter del riferimento alla tabella.<br>
     * @return t riferimento alla tabella.
     */
    public Tabella getTabella(){return t;}
    /**
     * Getter del riferimento al dataModel.<br>
     * @return dataModel riferimento al dataModel.<br>
     */
    public MyTableModel getDataModel() {return dataModel;}
}
