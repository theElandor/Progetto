package Table;
import Cells.Cell;
import java.io.Serializable;
import java.util.*;
/**
 * Classe che implementa una matrice di celle.<br>
 * Classe che sta alla base della struttura del programma: contiene
 * una matrice di celle programmabili.<br>
 */
public class Tabella implements Serializable
{
    private int rows = 99;
    private int cols = 27;
    private ArrayList<ArrayList<Cell>> mat;
    /**
     * Costruttore della classe.
     * Viene allocata una Lista di Liste di celle di lunghezza prefissata.<br>
     * La lista appena creata viene riempita di celle vuote, in modo che possano essere
     * visualizzabili fin da subito.<br>
     */
    public Tabella()
    {
        mat = new ArrayList<ArrayList<Cell>>(50);
        for(int i = 0 ; i < rows; i++)
        {
            ArrayList<Cell> singleList = new ArrayList<Cell>(26);
            for(int j = 0 ; j < cols; j++)
            {
                Cell nuova = null;
                singleList.add(nuova);
            }
            mat.add(singleList);
        }
    }
    /**
     * Metodo per aggiungere una nuova cella alla matrice.<br>
     * Prima viene deallocata la vecchia cella, poi viene aggiunta la nuova cella.<br>
     * @param row indice di riga.
     * @param col indice di colonna.
     * @param temp riferimento alla cella da aggiungere.
     */
    public void AddCellAt(int row, int col, Cell temp)
    {
        mat.get(row).remove(col);
        mat.get(row).add(col, temp);
    }
    /**
     * Metodo per ottenere un riferimento alla cella in posizione (i,j).<br>
     * @param i indice di riga.
     * @param j indice di colonna.
     * @return riferimento alla cella indicata.
     */
    public Cell getCella(int i, int j)
    {
        try
        {
            return mat.get(i).get(j);
        }
        catch(IndexOutOfBoundsException e)
        {
            return null;
        }
    }
    /**
     * Getter dell'attriubuto rows.<br>
     * @return numero di righe della tabella.
     */
    public int getRows()
    {
        return this.rows;
    }
    /**
     * Getter dell'attributo cols.<br>
     * @return numero di colonne della tabella.
     */ 
    public int getCols()
    {
        return this.cols;
    }
}
