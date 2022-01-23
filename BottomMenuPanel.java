import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
/**
 * Pannello che contiene la finestra di log.
 * Utile per mostrare messaggi di controllo, ad esempio
 * per informare l'utente del salvataggio automatico effettuato.  
 */
public class BottomMenuPanel extends JPanel
{
    /**
     * TextField di log usato per mostrare messaggi generici di monitoraggio.
     */
    private JTextField log;
    /**
     * Costruttore della classe.
     * Chiama il costruttore della classe padre.
     * Viene impostato il BorderLayout.
     * Viene creato un field di testo per i messaggi di monitoraggio.
     */
    public BottomMenuPanel()
    {
        super();
        this.setLayout(new BorderLayout());
        log = new JTextField(50);
        log.setEditable(false);
        add(log, BorderLayout.WEST);
    }
    /**
     * Getter della finestra di log.
     * Metodo usato per scrivere all'interno del JTextField.
     */
    public JTextField getLog(){return log;}
}
