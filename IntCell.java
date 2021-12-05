public class IntCell extends Cell
{
    private int value;
    public IntCell(String raw)
    {
        super(raw);
        System.out.println("Creazione cella int");
    }
    @Override
    public String getRenderedValue()
    {
        value = Integer.parseInt(raw);
        return raw;
    }
    public Integer getValue()
    {
        return value;
    }
}