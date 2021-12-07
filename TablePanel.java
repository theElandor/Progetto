import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class TablePanel extends JPanel
{ // devo creare un JScrollPane contenente la tabella.
    private Tabella t;
    private JScrollPane p;
    public TablePanel()
    {
        super();
        t = new Tabella();
        MyTableModel dataModel = new MyTableModel(t);
        MyJTable t = new MyJTable(dataModel);
        FrozenTablePane frozen = new FrozenTablePane(t,1);
	    //frozen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //p = new JScrollPane(frozen);
        this.setLayout(new BorderLayout());
        this.add(frozen, BorderLayout.CENTER);
        //frozen.getTableHeader().setResizingAllowed(true);
    }
}
