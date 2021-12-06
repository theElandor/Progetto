public class IntCell extends Cell
{
    private int value;
    private ValueTable v;
    int x , y;
    public IntCell(String raw, ValueTable v, int row, int col)
    {
        super(raw);
        this.v = v;
        System.out.println("Creazione cella int");
        x = row;
        y = col;
        value = Integer.parseInt(raw);
        v.put(getCharForNumber(y), value);
    }
    @Override
    public String getRenderedValue()
    {
        return raw;
    }
    public Integer getValue()
    {
        return value;
    }
}