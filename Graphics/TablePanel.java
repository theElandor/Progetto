package Graphics;

import javax.swing.JPanel;
import java.awt.*;
import Table.*;

public class TablePanel extends JPanel
{
    private Tabella t;
    private MyTableModel dataModel;
    public TablePanel()
    {
        super();
        t = new Tabella();
        dataModel = new MyTableModel(t);
        MyJTable t = new MyJTable(dataModel);
        FrozenTablePane frozen = new FrozenTablePane(t,1);
        //p = new JScrollPane(frozen);
        this.setLayout(new BorderLayout());
        this.add(frozen, BorderLayout.CENTER);
    }
    public Tabella getTabella()
    {
        return t;
    }
    public MyTableModel getDataModel()
    {
        return dataModel;
    }
}
