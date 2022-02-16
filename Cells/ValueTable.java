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
    /**
     * Costruttore della classe. Uso dei generics.<br>
     * Viene allocata un HashMap che contiene chiavi di tipo stringa e valori interi.<br>
     */
    public ValueTable() {m = new HashMap<String, Integer>();}
    public void put(String key, Integer value)
    {
        m.put(key, value);
    }
    public Integer get(String key)
    {
        return (Integer) m.get(key);
    }
    public void remove(String key)
    {
        m.remove(key);
    }
}
