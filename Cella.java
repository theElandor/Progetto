public class Cella
{
    private String param;
    public Cella(String content)
    {
        this.param = content;
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