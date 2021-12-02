import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
public class TablePanel extends JPanel
{
    private Tabella t;
    public TablePanel()
    {
        super();
        t = new Tabella();
        MyTableModel dataModel = new MyTableModel(t);
        JTable t = new JTable(dataModel);
        add(t);
    }
}