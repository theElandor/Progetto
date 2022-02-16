package Graphics;
import java.util.*;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JViewport; 
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.JTableHeader; 
import javax.swing.table.TableModel;
/**
 * Classe che "blocca" la prima colonna della tabella.
 */
public class FrozenTablePane extends JScrollPane{     
    public FrozenTablePane(JTable table, int colsToFreeze){     
        super(table);       
        TableModel model = table.getModel();
        /**
         * Creo un vettore da un elemento da passare al
         * costruttore del DefaultTableModel, in modo
         * da settare l'header della prima colonna a vuoto.
         * Altrimenti di default metterebbe A.
         */
        Vector<String> vec = new Vector<String>(1);   
        vec.add(" ");    
        //Si crea il table model della tabella bloccata.
        TableModel frozenModel = new DefaultTableModel(vec,model.getRowCount());       
        //Vengono inseriti i valori nella prima colonna.
        for (int i = 0; i < model.getRowCount(); i++) {       
            for (int j = 0; j < colsToFreeze; j++) {         
                String value = (String) model.getValueAt(i, j);         
                frozenModel.setValueAt(value, i, j);       
            }     
        }
    //Si crea la table con il model appena creato.
    JTable frozenTable = new JTable(frozenModel);
    //Si rimuove la prima colonna (bloccata) dal resto della tabella.
    for (int j = 0; j < colsToFreeze; j++) {
    table.removeColumn(table.getColumnModel().getColumn(0));
    }     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //Si formatta correttamente la nuova tabella.
    JTableHeader header = table.getTableHeader();     
    frozenTable.setBackground(header.getBackground());     
    frozenTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
    frozenTable.setEnabled(false);     
    JViewport viewport = new JViewport();    
    viewport.setView(frozenTable); 
    viewport.setPreferredSize(frozenTable.getPreferredSize());   
    setRowHeaderView(viewport);   
    setCorner(JScrollPane.UPPER_LEFT_CORNER, 
            frozenTable.getTableHeader()); 
    }
}
