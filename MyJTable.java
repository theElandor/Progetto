import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.management.RuntimeMBeanException;
import javax.swing.JTable;
import javax.swing.JTextField;
public class MyJTable extends JTable
{
    MyTableModel data;
    public MyJTable(MyTableModel dataModel)
    {
        super(dataModel);
        this.data= dataModel;
        this.setAutoCreateRowSorter(true);
    }
    @Override
    public boolean editCellAt(int row, int column, EventObject e){
        boolean ans = super.editCellAt(row, column,e);
        if (ans){
            if(data.getCellAt(row, column+1) != null)
            {
                JTextField editor = (JTextField)getEditorComponent();
                if(editor != null)
                {
                    System.out.println("DATA "+data.getRawDataAt(row,column+1));
                    editor.setText(data.getRawDataAt(row,column+1)); 
                }
            } 
        }
        return ans;
    }
    /**
     * Metodo implementato per il toolTip quando si passa con il mouse
     * su una cella. In caso di cella vuota, si ritorna null per non mostrare il tooltip.
     * */
    public String getToolTipText(MouseEvent e)
    {
        String tip = null;
        Point p = e.getPoint();
        int rowIndex = rowAtPoint(p);
        int colIndex = columnAtPoint(p);
        try
        {
            tip = getValueAt(rowIndex, colIndex).toString();
            if(tip.equals(""))
            {
                throw(new RuntimeException());
            }
        }
        catch(RuntimeException e1){return null;}
        return tip;
    }
}