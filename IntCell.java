/**
 * Classe figlia della classe Cell.
 * Serve a gestire le celle che contengono dei valori interi.
 */
public class IntCell extends Cell
{
    private int value;
    /**
     * Costruttore della classe.
     * @param raw Il numero intero passato come semplice stringa
     * @param v la HashMap contenente i valori numerici del foglio di calcolo
     * @param row indice di riga della cella
     * @param col indice di colonna della cella
     * Dopo che il valore è stato convertito a intero, viene immediatamente 
     * messo all'interno della hashMap, dove poi potrà essere processato dalle
     * formule. In questo modo sono necessari meno controlli da parte delle 
     * celle che gesticono le formule per effettuare calcoli.
     */
    public IntCell(String raw, ValueTable v, int row, int col)
    {
        super(raw, v, row, col);
        value = Integer.parseInt(raw);
        v.put(getCharForNumber(col)+(row+1), value);
    }
    /**
     * Funzione che ritorna i dati da stampare sul foglio di calcolo. In questo
     * caso si può semplicemente stampare il valore sotto forma di stringa.
     */
    @Override
    public String getRenderedValue()
    {
        return raw;
    }
}
