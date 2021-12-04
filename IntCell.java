public class IntCell extends DynamicCell
{
    public IntCell(String param)
    {
        super(param);
    }
    @Override
    public void RenderCell()
    {
        value = Integer.parseInt(this.getParam());
    }
}