import javax.swing.table.AbstractTableModel;
public class MyTableModel extends AbstractTableModel
{
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    // setValueAt(Object , int, int) per settare il valore di una cella.
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
        return Character.toString(Character.toUpperCase(alphabet[col]));
    }
    public String getRowName(int row)
    {
	return Integer.toString(row+1);
    }
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }
    @Override
    public void setValueAt(Object aValue, int row, int col)   
    {
        Cella nuova = t.getCella(row, col);
        nuova.setParam((String) aValue);
    }
}
