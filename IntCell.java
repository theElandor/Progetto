public class IntCell extends DynamicCell
{
    public IntCell(String param)
    {
        super(param);
        System.out.println("Creazione cella int");
    }
    @Override
    public void RenderCell()
    {
        value = Integer.parseInt(this.getParam());
    }
}