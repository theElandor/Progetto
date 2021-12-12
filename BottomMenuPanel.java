import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BottomMenuPanel extends JPanel
{
    /**
     * TextField di log usata per mostrare messaggi generici di monitoraggio.
     */
    private JTextField log;
    public BottomMenuPanel()
    {
        super();
        this.setLayout(new BorderLayout());
        log = new JTextField(50);
        log.setEditable(false);
        add(log, BorderLayout.WEST);
    }
    /**
     * getter del log, i metodi delle altre classi devono poterlo modificare.
     */
    public JTextField getLog(){return log;}
}
