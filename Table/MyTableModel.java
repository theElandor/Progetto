package Table;
import Cells.Cell;
import Cells.FormulaCell;
import Cells.IntCell;
import Cells.ValueTable;
import javax.swing.table.AbstractTableModel;
/**
 * Classe che gestisce i dati all'interno della tabella.
 * Contiene i riferimenti alle due strutture dati principali, ossia 
 * la Tabella (che contiene le celle) e la ValueTable ( HashMap che modella l'associazione cella-valore numerico)<br>
 * L'attributo saved indica se esiste o meno un salvataggio dell'attuale tabella.<br>
 * L'attributo currentSave contiene il path del salvataggio sotto forma di stringa.<br>
 */
public class MyTableModel extends AbstractTableModel
{
    char[] alphabet = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private Tabella t;
    private ValueTable v;
    private Boolean saved;
    private String currentSave;
    /**
     * Costruttore della classe.<br>
     * @param t Tabella da cui estrarre i dati sulle celle.<br>
     */
    public MyTableModel(Tabella t)
    {
        this.t = t;
        saved = false;
        v = new ValueTable();
    }
    /**
     * Metodo che ritorna il numero di colonne della tabella.<br>
     */
    public int getColumnCount() {return(t.getCols());}
    /**
     * Metodo che ritorna il numero di righe della tabella.<br>
     */
    public int getRowCount() {return(t.getRows());}
    /**
     * Grazie al comportamento polimorfico delle celle, è sufficiente chiamare il metodo getRenderedValue sulla
     * cella selezionata per ottenere il suo contenuto, che può essere il risultato di una formula o una semplice stringa.<br>
     * @param row
     * @param col
     * @return il contenuto della cella.<br>
     */
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
    /**
     * Metodo che ritorna il nome della colonna.<br>
     * @param col indice di colonna
     * @return nome della colonna
     */
    public String getColumnName(int col)
    {
        return Character.toString(Character.toUpperCase(alphabet[col]));
    }
    /**
     * Getter dell'attributo saved<br>
     * @return this.saved
     */
    public Boolean getSaved(){return this.saved;}
    public boolean isCellEditable(int row, int col){return true;}
    /**
     * Metodo che gestisce l'inserimento delle celle all'interno della Tabella.<br>
     * Si usa il metodo di supporto SpecializeCell, per individuare il tipo di cella adatto
     * per i dati che ha inserito l'utente.<br>
     * La nuova cella viene inserita all'interno della Tabella.<br>
     * La tabella viene aggiornata per renderizzare correttamente il nuovo dato inserito.<br>
     * @param aValue dato inserito dall'utente nella cella
     * @param row indice di riga della cella selezionata
     * @param col indice di colonna della cella selezionata
     */
    @Override
    public void setValueAt(Object aValue, int row, int col)   
    {
        Cell temp = new Cell((String) aValue, v, row, col);
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
    /**
     * Metodo che ritorna il dato memorizzato in una cella come stringa.<br>
     * @param row indice di riga.
     * @param col indice di colonna.
     * @return dato memorizzato nella cella come semplice stringa.
     */
    public String getRawDataAt(int row, int col) {return t.getCella(row, col).getRaw();}
    /**
     * Metodo che ritorna la cella dati l'indice di riga e di colonna.<br>
     * @param row indice di riga.
     * @param col indice di colonna.
     * @return riferimento alla cella indicata.
     */
    public Cell getCellAt(int row, int col) {return t.getCella(row, col);}
    /**
     * Getter della ValueTable.<br>
     * @return riferimento alla ValueTable.
     */
    public ValueTable getValueTable() {return v;}
    /**
     * Getter della Tabella. <br>
     * @return riferimento alla Tabella.
     */
    public Tabella getTabella() {return t;}
    /**
     * Metodo usato dalla classe Loader per impostare una nuova Tabella letta da file. <br>
     * @param t oggetto di tipo Tabella letto da file.
     */	   
    public void setTabella(Tabella t) {this.t = t;}
    /**
     * Metodo usato dalla classe Loader per impostare una nuova ValueTable letta da file. <br>
     * @param v oggetto di tipo ValueTable letto da file.
     */
    public void setValueTable(ValueTable v) {this.v = v;}
    /**
     * Metodo usato dalla classe Loader per impostare il valore dell'attributo saved. <br>
     * @param val true o false.
     */
    public void setSaved(boolean val) {this.saved = val;}
    /**
     * Metodo usato dalla classe Loader per impostare il valore dell'attributo currentSave. <br>
     * @param name percorso del salvataggio corrispondente all'attuale istanza.
     */
    public void setCurrentSave(String name){this.currentSave = name;}
    /**
     * Getter dell'attributo currentSave.<br>
     * @return percorso del salvataggio.
     */
    public String getCurrentSave(){return this.currentSave;}
}
