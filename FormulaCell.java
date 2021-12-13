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
    public String getRenderedValue()
    {
        return getCellValue();
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
        // controllo se per caso l'utente sta inserendo una formula senza
        // operatore.
        if(OperatorIndex == -1){return "BadSyntaxError";}
        String first = raw.substring(1,OperatorIndex);
        String second = raw.substring(OperatorIndex+1);
        Pattern p = Pattern.compile("([A-Z][1-9][0-9]?)|0|[1-9][0-9]*");
        // la sintassi è valida anche se un utente inserisce un valore intero.
        Matcher first_part = p.matcher(first);
        Matcher second_part= p.matcher(second);

        Integer first_int = null;
        Integer second_int = null;

        if(!first_part.matches() && second_part.matches())
            return "InvalidOperatorFound";
        try
        {
            first_int = Integer.parseInt(first);
        }
        catch(NumberFormatException e){}
        try
        {
            second_int = Integer.parseInt(second);
        }
        catch(NumberFormatException e) {}
        if(first_int == null)
        {
            first_int = v.get(first);
            if(first_int == null)
                return "NullValueFound: è stata inserita una cella non esistente o una cella inserita non contiene valori.";
        }
        if(second_int == null)
        {
            second_int = v.get(second);
            if(second_int == null)
                return "NullValueFound";
        }
        int result = 0;
        // da sostituire con uno switch case per l'operatore.
        /**
         * Invece di usare direttamente i get, uso due variabili
         * d'appoggio, in modo che possano essere settati direttamente
         * a valori interi. Quindi prima di fare il get, PROVO a
         * fare il cast ad int, dato che comumnque so che l'espressione
         * è valido. Se il cast va a buon fine, allora setto il corrispondente
         * operando al valore ritornato, altrimenti faccio il get.
         */
        if(raw.charAt(OperatorIndex) == '+')
        {
            result = first_int+second_int;
        }
        if(raw.charAt(OperatorIndex) == '-')
        {
            result = first_int+second_int;
        }
        if(raw.charAt(OperatorIndex) == '*')
        {
            result =  first_int*second_int;
        }
        v.put(getCharForNumber(col)+(row+1), result);
        return Integer.toString(result);
    }
    public Integer getValue()
    {
        return value;
    }
}