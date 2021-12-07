import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTextField;
public class MyJTable extends JTable
{
    MyTableModel data;
    public MyJTable(MyTableModel dataModel)
    {
        super(dataModel);
        this.data= dataModel;
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
}