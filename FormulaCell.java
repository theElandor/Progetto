import java.lang.*;
public class FormulaCell extends Cell
{
    private Tabella t;
    private int value;
    // private String raw = "A1+B2"
    // x=3, y=1;
    public FormulaCell(String raw, Tabella t)
    {
        super(raw);
        this.t = t;
        System.out.println("Creazione cella formula");
    }
    @Override
    /**
     * Codice che dalla formula memorizzata
     * sotto forma di stringa in Raw ritorna 
     * il valore intero dell'operazione
     */
    public String getRenderedValue()
    {
        if(raw.equals("=Errore"))
            return "Formula non valida";
        else
            return Integer.toString(12);
    }
    public Integer getValue()
    {
        return value;
    }
}