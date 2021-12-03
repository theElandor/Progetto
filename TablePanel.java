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
        JTable t = new JTable(dataModel);
	    t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        p = new JScrollPane(t);
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
        t.getTableHeader().setResizingAllowed(true);
        // da mettere CENTER altrimenti ci sono problemi con
        // il resize
    }
}
