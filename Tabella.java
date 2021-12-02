import java.util.*;
/**
 * Matrice che contiene le celle.
 * E' un array di array.
 */
public class Tabella
{
    private int rows = 50;
    private int cols = 20;
    private String debug = "";
    private ArrayList<ArrayList<Cella>> mat;
    Cella vuota;
    public Tabella()
    {
        mat = new ArrayList<ArrayList<Cella>>();
        for(int i = 0 ; i < rows; i++)
        {
            ArrayList<Cella> singleList = new ArrayList<Cella>();
            for(int j = 0 ; j < cols ; j++)
            {
                if(i == 0)
                {
                   vuota = new Cella(Integer.toString(j));
                }
                else
                {
                    vuota = new Cella(debug);
                }
                singleList.add(vuota);
            }
            mat.add(singleList);
        }
    }
    public Cella getCella(int i, int j)
    {
        return mat.get(i).get(j);
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