public class FormulaCell extends DynamicCell
{
    public FormulaCell(String param)
    {
        super(param);
    }
    @Override
    /**
     * Questo metodo deve contenere la funzione che calcola
     * il valore da assegnare alla cella.
     */
    public void RenderCell()
    {
        value = 100;
    }
}