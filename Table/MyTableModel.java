package Table;/*
 * Di base non creo tutte le celle subito, quando viene inserito un
 * valore, creo la cella adatta identificando quel valore.
 */
import Cells.Cell;
import Cells.FormulaCell;
import Cells.IntCell;
import Cells.ValueTable;

import javax.swing.table.AbstractTableModel;
public class MyTableModel extends AbstractTableModel
{
    // sarebbe meglio usare la codifica ASCII
    // da cambiare in futuro.
    char[] alphabet = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    // setValueAt(Object , int, int) per settare il valore di una cella.
    private Tabella t;
    private ValueTable v;
    /**
     * Parametro che serve a capire se il model è già stato salvato.*/
    private Boolean saved;
    /**
     * Parametro che tiene in memoria il nome del salvataggio
     * in memoria corrispondente alla struttura dati.
     */
    private String currentSave;

    public MyTableModel(Tabella t)
    {
        this.t = t;
        saved = false;
        v = new ValueTable();
    }
    public int getColumnCount() {return(t.getCols());}
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
    public Boolean getSaved()
    {
        return this.saved;
    }
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }
    @Override
    public void setValueAt(Object aValue, int row, int col)   
    {
        Cell temp = new Cell((String) aValue, v, row, col);
        // o qui o nel costruttore devo chiamare
        // temp.resetTableValue(row, col);
        // a questo punto ha piu senso farlo nel costruttore.
        // Altrimenti se modifico una cella che prima conteneva
        // già un valore, questo non viene modificato.
        int job = temp.SpecializeCell();
        switch(job)
        {
            case 2:
                temp = new IntCell((String) aValue,v, row, col);
                break;
            case 3:
                temp = new FormulaCell((String) aValue,v,row,col);
                break;
        }
        t.AddCellAt(row,col,temp);
        fireTableDataChanged();
    }
    public String getRawDataAt(int row, int col) {return t.getCella(row, col).getRaw();}
    public Cell getCellAt(int row, int col) {return t.getCella(row, col);}
    public ValueTable getValueTable() {return v;}
    /** 
     * Metodi usati dal loader quando carica
     * dati da un file.
     */
    public Tabella getTabella() {return t;}
    public void setTabella(Tabella t) {this.t = t;}
    public void setValueTable(ValueTable v) {this.v = v;}
    public void setSaved(boolean val) {this.saved = val;}
    public void setCurrentSave(String name){this.currentSave = name;}
    public String getCurrentSave(){return this.currentSave;}
}