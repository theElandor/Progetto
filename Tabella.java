
import java.io.Serializable;
import java.util.*;
/**
 * Matrice che contiene le celle.
 * E' un array di array.
 */
public class Tabella implements Serializable
{
    private int rows = 99;
    private int cols = 27;
    private ArrayList<ArrayList<Cell>> mat;
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
     * Funzione che crea una cella con un determinato contenuto
     * alla posizione [row, col]
     */
    public void AddCellAt(int row, int col, Cell temp)
    {
        mat.get(row).remove(col);
        // devo fare il remove, altrimenti l'arrayList shifta gli elementi
        // per fare spazio all'elemento nuovo nel caso in cui una cella
        // viene ricreata.
        mat.get(row).add(col, temp);
    }
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
    public int getRows()
    {
        return this.rows;
    }
    public int getCols()
    {
        return this.cols;
    }
}
