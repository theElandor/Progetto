package Graphics;
import javax.swing.JOptionPane;
/**
 * Classe che implementa metodi utili per interfacciarsi con l'utente.<br>
 */
public abstract class DialogHandler extends Thread
{
    private BottomMenuPanel logPanel;
    /**
     * Costruttore della classe.<br>
     */
    public DialogHandler(BottomMenuPanel logPanel) {this.logPanel = logPanel;}
    /**
     * Metodo per aprire un ErrorDialog, per mostrare all'utente un messaggio d'errore.<br>
     * @param error errore da stampare.
     */
    public void throwErrorDialog(String error)
    {
        JOptionPane.showMessageDialog(null, error, "MessageBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Metodo che permette di scrivere nella finestra inferiore di log.<br>
     * @param message messaggio da stampare.
     */
    public void writeLog(String message)
    {
        logPanel.getLog().setText(message);
    }
}
