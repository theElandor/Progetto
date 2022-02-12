package Cells;

import java.io.Serializable;
import java.util.*;
/***
 * Classe che incapsula una hash map.
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