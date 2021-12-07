import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.JTextField;
public class MyJTable extends JTable
{
    MyTableModel dataModel;
    public MyJTable(MyTableModel dataModel)
    {
        super(dataModel);
    }
    @Override
    public boolean editCellAt(int row, int column) {
        boolean ans = super.editCellAt(row, column);
        if (ans) { 
            JTextField editor = (JTextField)this.getEditorComponent();
            editor.requestFocusInWindow();
            editor.setText(dataModel.getRawDataAt(row,column));          
        }
        return ans;
    }
}