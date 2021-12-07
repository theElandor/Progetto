import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// editCellAT metodo di JTable

public class FormulaCell extends Cell
{
    private int value;
    // private String raw = "A1+B2"
    public FormulaCell(String raw, ValueTable v, int row, int col)
    {
        super(raw, v, row , col);
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
        // grazie ad un primo controllo fatto dalla funzione
        // specialize, so già che il primo carattere è un uguale.
        if(raw.length() < 6 || raw.length() > 8)
            return "Number of characters out of bound.";
        else
        {
            return getCellValue();
        }
    }
    public String getCellValue()
    {
        int OperatorIndex  = -1;
        for(int i = 0 ; i < raw.length(); i++)
        {
            char temp  = raw.charAt(i);
            if(temp == '+' || temp == '-' || temp == '*')
                OperatorIndex = i;
        }
        /**
         * Rimarrebbe da risolvere il caso in cui l'utente
         * inserisce gli identificativi delle colonne come lettere
         * minuscole.*/
        String first = raw.substring(1,OperatorIndex);
        String second = raw.substring(OperatorIndex+1);
        Pattern p = Pattern.compile("[A-Z][1-9][0-9]?");
        Matcher first_part = p.matcher(first);
        Matcher second_part= p.matcher(second);
        if(!first_part.matches() && second_part.matches())
            return "InvalidSyntax";
        else
        { // controllo le caselle se contengono valori validi
            if(v.get(first) == null || v.get(second) == null)
                return "NullValueFound";
        }
        int result = 0;
        if(raw.charAt(OperatorIndex) == '+')
        {
            result = v.get(first)+v.get(second);
        }
        if(raw.charAt(OperatorIndex) == '-')
        {
            result =  v.get(first)-v.get(second);
        }
        if(raw.charAt(OperatorIndex) == '*')
        {
            result =  v.get(first)*v.get(second);
        }
        v.put(getCharForNumber(col)+(row+1), result);
        return Integer.toString(result);
    }
    public Integer getValue()
    {
        return value;
    }
}