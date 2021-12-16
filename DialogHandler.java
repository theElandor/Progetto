import javax.swing.JOptionPane;
public abstract class DialogHandler extends Thread
{
    private BottomMenuPanel logPanel;
    public DialogHandler(BottomMenuPanel logPanel)
    {
        this.logPanel = logPanel;
    }
    public void throwErrorDialog(String error)
    {
        JOptionPane.showMessageDialog(null, error, "MessageBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    public void writeLog(String message)
    {
        logPanel.getLog().setText(message);
    }
}