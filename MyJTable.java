import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.management.RuntimeMBeanException;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * Classe che estende JTable per avere alcune funzionalità personalizzate.
 */
public class MyJTable extends JTable
{
    MyTableModel data;

    /**
     * Semplice costruttore che chiama il metodo della classe padre, che necessita del dataModel 
     * come parametro. Per semplicità salvo il dataModel anche im un parametro locale.
     *
     * @param dataModel
     */
    public MyJTable(MyTableModel dataModel)
    {
        super(dataModel);
        this.data= dataModel;
    }
    @Override
    /**
     * Funzione che permette di visualizzare la formula quando la cella viene cliccata.
     * Accedendo al RawData della cella specificata, viene renderizzata direttamente
     * la stringa corrispondente alla formula, e non viene mostrato il valore numerico, 
     * che può essere un intero o un messaggio di errore.
     *
     * @param row indice di riga;
     * @param column indice di colonna;
     * @param e evento;
     * @return ans valore di ritorno della funzione della classe padre;
     */
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
     * Metodo per implementare il tooltip.
     * Grazie a questo metodo, quando l'utente passa con il mouse su una cella, può vedere il suo contenuto
     * senza dover necessariamente cliccare su di essa.
     * E' utile per mostrare i messaggi di errore all'interno delle celle contenenti formule.
     * @param e il mouseEvent;
     * @return tip stringa contenente il tooltip;
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
