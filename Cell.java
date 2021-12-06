import javax.naming.event.ObjectChangeListener;

public class Cell
{
    protected String raw; // raw data
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
     * @return
     */
    public String getRenderedValue()
    {
        return raw;
    }
   /*
   * Metodo che ritorna:
   * 1) Se la cella deve specializzarsi in StringCell
   * 2) Se la cella deve specializzarsi in IntCell
   * 3) Se la cella deve specializzarsi in FormulaCell*/
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
    public String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }
    /**
     * Metodo per togliere dalla tabella contenente i valori numerici
     * eventuali valori pre-memorizzati.*/
    public void resetValueInTable()
    {
        String col = getCharForNumber(this.col);// devo trasformarla
        String row = Integer.toString(this.row);
        String result = col+row;
        v.remove(col);
    }
}