import java.util.*;
/**
 * Matrice che contiene le celle.
 * E' un array di array.
 */
public class Tabella
{
    private int rows = 40;
    private int cols = 20;
    public Tabella()
    {
        ArrayList<ArrayList<Cella>> mat = new ArrayList<ArrayList<Cella>>();
        for(int i = 0 ; i < rows; i++)
        {
            ArrayList<Cella> singleList = new ArrayList<Cella>();
            for(int j = 0 ; j < cols ; j++)
            {
                Cella vuota = new Cella();
                singleList.add(vuota);
            }
            mat.add(singleList);
        } 
    }
}