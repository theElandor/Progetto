public class IntCell extends Cell
{
    private int value;
    public IntCell(String param)
    {
        super(param);
        System.out.println("Creazione cella int");
        value = Integer.parseInt(raw);
    }
    @Override
    public Integer getRenderedValue()
    {
        return value;
    }
}