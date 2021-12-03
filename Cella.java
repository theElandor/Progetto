/*
* Ragionamento:
* public abstract class Cella
*   -->
*   -->
*
* */

public class Cella
{
    private String param;
    public Cella(String content)
    {
        this.param = content;
        System.out.println("Creazione di una cella.");
    }
    public Cella()
    {
        this("");
    }
    public String getParam()
    {
        return param;
    } 
    public void setParam(String val)
    {
        param = val;
    }
}