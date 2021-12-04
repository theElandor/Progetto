public class Cell
{
    protected String param;
    public Cell()
    {
        this("");
    }
    public Cell(String param)
    {
        this.param = param;
    }
    /*
    * Getter*/
    public String getParam()
    {
        return param;
    }
    /**
     * Setter*/
   public void setParam(String param)
   {
       this.param = param;
   }
   /*
   * Metodo che ritorna:
   * 1) Se la cella deve specializzarsi in StringCell
   * 2) Se la cella deve specializzarsi in IntCell
   * 3) Se la cella deve specializzarsi in FormulaCell*/
   public int SpecializeCell()
   {
       int return_value;
       try
       {return_value = Integer.parseInt(param);
           return_value = 2;}
       catch (NumberFormatException e)
       {
           if(Character.compare(param.charAt(0), '=') == 0)
               return_value = 3;
           else
               return_value = 1;
       }
       return return_value;
   }
}