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
    public abstract void RenderCell();
}
