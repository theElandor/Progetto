package Cells;

import java.io.Serializable;

/**
 * Classe che rappresenta la singola cella del foglio di calcolo.<br>
 * Si può specializzare in 3 diversi sottotipi: <br>
 * 1) Una semplice cella contenente una stringa. (Cell) <br>
 * 2) Una cella che contiene un valore intero. (IntCell) <br>
 * 3) Una cella che contiene una formula aritmetica. (FormulaCell) <br>
 */
public class Cell implements Serializable
{
    protected String raw;
    protected ValueTable v;
    protected int row, col;

    public Cell(String raw, ValueTable v, int  row, int col)
    {
        this.v = v;
        this.raw = raw;
        this.row = row;
        this.col = col;
        resetValueInTable();
    }
    /**
     * Nel caso delle celle generiche la funzione
     * getRenderedValue ritorna semplicemente 
     * la stringa inserita dall'utente. 
     * @return valore della stringa.
     */
    public String getRenderedValue(){return getRaw();}
    public String getRaw() {return raw;}
    /**
     * Metoto che serve alla cella per potersi specializzare. Se la stringa contenuta nella cella 
     * può essere convertita con successo a un valore intero, allora la cella può specializzarsi in una Cells.IntCell.<br>
     * Se la stringa contenuta nella cella contiene un carattere "=" in prima posizione, allora verrà interpretata
     * come una formula. In tal caso, la cella potrà specializzarsi in una Cells.FormulaCell.<br>
     * I valori di ritorno servono al chiamante per poter allocare un oggetto del tipo adatto.
     */
    public int SpecializeCell()
   {
       int return_value;
       try
       {return_value = Integer.parseInt(raw);
           return_value = 2;}
       catch (NumberFormatException e)
       {
           if(Character.compare(raw.charAt(0), '=') == 0)
               return_value = 3;
           else
               return_value = 1;
       }
       return return_value;
   }
    /**
     * Metodo che ritorna la stringa corrispondente ad un intero,
     * basandosi sulla codifica ASCII.
     * @param i valore intero.
     * @return stringa corrispondente.
     */
    public String getCharForNumber(int i) {return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;}
    /**
     * Metodo che resetta il valore di una cella all'interno della ValueTable.<br>
     */
    public void resetValueInTable()
    {
        String col = getCharForNumber(this.col);// devo trasformarla
        String row = Integer.toString(this.row+1);
        String result = col+row;
        v.remove(result);
    }
}
