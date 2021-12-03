import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.Dimension;
public class TablePanel extends JPanel
{ // devo creare un JScrollPane contenente la tabella.
    private Tabella t;
    public TablePanel()
    {
        super();
        t = new Tabella();
        MyTableModel dataModel = new MyTableModel(t);
        JTable t = new JTable(dataModel);
	t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	add(t);
    }
}
