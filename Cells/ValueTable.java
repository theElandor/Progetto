package Cells;
import java.io.Serializable;
import java.util.*;
/***
 * Classe che incapsula una Hash Map.<br>
 * Serve a contenere valori numerici associati alle celle.<br>
 * Le chiavi sono stringhe, ad esempio: "B3", mentre i valori sono interi.<br>
 */
@SuppressWarnings({"unsafe","unchecked"})
public class ValueTable implements Serializable {
    private Map m;
    public ValueTable() {
        m = new HashMap<String, Integer>();
    }
    public void put(String key, Integer value)
    {
        m.put(key, value);
        debug();
    }
    public Integer get(String key)
    {
        return (Integer) m.get(key);
    }
    public void remove(String key)
    {
        m.remove(key);
    }
    /**
     * Funzione per stampare la hasmap formattata.*/
    public void debug()
    {
        System.out.println("-------------");
        m.entrySet().forEach(System.out::println);
        System.out.println("-------------");
    }
}
