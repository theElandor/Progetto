public class FormulaCell extends DynamicCell
{
    public FormulaCell(String param)
    {
        super(param);
        System.out.println("Creazione cella formula");
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