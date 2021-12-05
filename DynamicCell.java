public abstract class DynamicCell extends Cell{
    protected int value;
    public DynamicCell(String param)
    {
        super(param);
    }
    public int getValue()
    {
        return value;
    }
    /**
     * Metodo implementato da IntCell e FormulaCell:
     * IntCell trasforma il suo campo stringa in
     * intero e lo assegna al suo parametro interno.
     * 
     * FormulaCell fa il parsing della stringa e 
     * assegna al suo parametro interno il valore
     * corretto in base alla formula.
     */
    public abstract void RenderCell();
}
