public class FormulaCell extends Cell
{
    private int value;
    public FormulaCell(String raw)
    {
        super(raw);
        System.out.println("Creazione cella formula");
    }
    @Override
    public Integer getRenderedValue()
    {
        // da modificare
        value = 100;
        return value;
    }
}