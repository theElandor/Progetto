import java.util.*;
/***
 * Classe che incapsula una hash map.
 *
 */
public class ValueTable {
    private Map m;
    public ValueTable() {
        m = new HashMap<String, Integer>();
    }
    public void put(String key, Integer value)
    {
        m.put(key, value);
        debug();
    }
    public Object get(String key)
    {
        return m.get(key);
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