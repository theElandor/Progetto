
import java.util.*;
/**
 * Matrice che contiene le celle.
 * E' un array di array.
 */
public class Tabella
{
    private int rows = 50;
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
                // domanda: perchè se non inizializzo tutte le caselle
                // con delle celle nulle (senza allocare memoria quindi)
                // mi va in IndexOutOfBound ? IDK.
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
