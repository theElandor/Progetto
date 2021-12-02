import javax.swing.table.AbstractTableModel;
public class MyTableModel extends AbstractTableModel
{
    private Tabella t;
    // in qualche modo devo poter vedere la
    // struttura dati. Provo a passarla con il costruttore
    public MyTableModel(Tabella t)
    {
        this.t = t;
    }
    public int getColumnCount()
    {
        return(t.getCols());
    }
    /**
     * In questo caso ritorno rubrica.size()
     */
    public int getRowCount()
    {
        return(t.getRows());
    }
    public Object getValueAt(int row, int col)
    {   // devo restituire un oggetto
        // il valore dipende dalla colonna in cui sono
        
        return t.getCella(row, col).getParam();
    }
    public String getColumnName(int col)
    {
        return Integer.toString(col+1);
    }
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }

}