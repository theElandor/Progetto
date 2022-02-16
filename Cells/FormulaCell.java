package Cells;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Classe che gestisce le celle contenenti formule.<br>
 * Per comodità sono stati definiti 3 attributi di tipo stringa, che rappresentano
 * gli errori stampabili all'interno della cella.
 */
public class FormulaCell extends Cell
{

    private String BadSyntaxError = "BadSyntaxError";
    private String NullValueFoundError = "NullValueFound: e' stata inserita una cella non esistente o una cella inserita non contiene valori.";
    private String InvalidOperatorFoundError = "InvalidOperatorFoundError";
    /**
     * Costruttore della classe.
     */
    public FormulaCell(String raw, ValueTable v, int row, int col)
    {
        super(raw, v, row , col);
    }
    /**
     * Metodo che renderizza il valore della cella data la formula.
     * Per prima cosa vengono estrapolati i dati utili dalla stringa: si individua
     * la posizione del carattere corrispondente all'operatore aritmetico e si ottengono i due operandi, che verranno elaborati
     * in base all'operatore stesso. <br>
     * Se l'operatore non viene trovato o i due operatori non soddisfano le condizioni dettate dal pattern, il metodo ritorna errore.<br>
     * Se la sintassi della formula è corretta, si cercano i valori indicati all'interno della ValueTable. <br>
     * Se una delle celle non contiene nessun valore, quindi non esiste ancora all'interno della tabella, viene ritornato un
     * NullValueFoundError.<br>
     * Se tutte le operazioni vanno a buon fine, il nuovo valore calcolato viene inserito all'interno della ValueTable e ritornato
     * come stringa per essere renderizzato.<br>
     */
    @Override
    public String getRenderedValue()
    {
        int OperatorIndex  = -1;
        for(int i = 0 ; i < raw.length(); i++)
        {
            char temp  = raw.charAt(i);
            if(temp == '+' || temp == '-' || temp == '*')
                OperatorIndex = i;
        }
        if(OperatorIndex == -1){return BadSyntaxError;}
        String first = raw.substring(1,OperatorIndex);
        String second = raw.substring(OperatorIndex+1);
        Pattern p = Pattern.compile("([A-Z][1-9][0-9]?)|0|[1-9][0-9]*");
        Matcher first_part = p.matcher(first);
        Matcher second_part= p.matcher(second);

        Integer first_int = null;
        Integer second_int = null;

        if(!first_part.matches() && second_part.matches())
            return InvalidOperatorFoundError;
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
                return NullValueFoundError;
        }
        if(second_int == null)
        {
            second_int = v.get(second);
            if(second_int == null)
                return NullValueFoundError;
        }
        int result = 0;
        Character operator;
        operator = raw.charAt(OperatorIndex);
        switch(operator)
        {
            case '+':
                result = first_int + second_int;
                break;
            case '-':
                result = first_int - second_int;
                break;
            case '*':
                result = first_int * second_int;
                break;
            default:
                break;
        }
        v.put(getCharForNumber(col)+(row+1), result);
        return Integer.toString(result);
    }
}
