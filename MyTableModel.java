/**
 * Di base non creo tutte le celle subito, quando viene inserito un
 * valore, creo la cella adatta identificando quel valore.
 */
import javax.swing.table.AbstractTableModel;
public class MyTableModel extends AbstractTableModel
{
    // sarebbe meglio usare la codifica ASCII
    // da cambiare in futuro.
    char[] alphabet = {'X','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
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
    {
        if(col == 0)
        {
            return Integer.toString(row+1);
        }
        else
        {
            Cell temp;
            temp = t.getCella(row,col);
            if(temp == null)
            {
                return "";
            }
            return temp.getRenderedValue();
        }
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
        Cell temp = new Cell((String) aValue);
        int job = temp.SpecializeCell();
        switch(job)
        {
            case 2:
                temp = new IntCell((String) aValue);
                break;
            case 3:
                temp = new FormulaCell((String) aValue);
                break;
        }
        t.AddCellAt(row,col,temp);
    }
}