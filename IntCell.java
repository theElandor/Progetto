public class IntCell extends Cell
{
    private int value;
    public IntCell(String raw, ValueTable v, int row, int col)
    {
        super(raw, v, row, col);
        System.out.println("Creazione cella int");
        value = Integer.parseInt(raw);
        v.put(getCharForNumber(col)+(row+1), value);
    }
    @Override
    public String getRenderedValue()
    {
        return raw;
    }
}