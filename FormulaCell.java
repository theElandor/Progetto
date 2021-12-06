import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaCell extends Cell
{
    private int value;
    // private String raw = "A1+B2"
    // x=3, y=1;
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
            return "Syntax Error";
        else
            if(ValidateSyntax() == true)
                return "Valida";
            else
                return "Syntax Error";
    }
    public boolean ValidateSyntax()
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
        Pattern p = Pattern.compile("[A-Z][1-9]{1,2}");
        Matcher first_part = p.matcher(first);
        Matcher second_part= p.matcher(second);
        return (first_part.matches() && second_part.matches());
    }
    public Integer getValue()
    {
        return value;
    }
}