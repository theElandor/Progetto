package Graphics;

import java.awt.*;
import javax.swing.*;
import Menu.MainMenuListener;
/**
 * Frame del foglio di calcolo, a cui e' associato un Menu' principale di scelta multipla.
 * Contiene un'oggetto di tipo Graphics.BigPanel.
 * A questa classe e' associato un WindowListener, in modo da poter lanciare la finestra di dialogo
 * che chiede all'utente conferma prima di uscire.
 */
public class MyFrame extends JFrame
{
    private BigPanel p;
    private MainMenuListener listener;
    public MyFrame()
    {
        this("");
    }
    public MyFrame(String titolo)
    {
        super(titolo);
        setBounds(0,0,1280,720);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        p = new BigPanel();

        listener = new MainMenuListener(p.getTablePanel().getDataModel(), p.getBottomMenuPanel());


        JMenuItem m11 = new JMenuItem("Salva");
        JMenuItem m12 = new JMenuItem("Salva con nome");
        JMenuItem m13 = new JMenuItem("Carica");

        JMenu m1 = new JMenu("File");
        //JMenu m2 = new JMenu("Modifica");

        m1.add(m11);
        m1.add(m12);
        m1.add(m13);

        //m2.add(m21);

        JMenuBar mb = new JMenuBar();
        mb.add(m1);
        //mb.add(m2);

        this.setJMenuBar(mb);
        m11.addActionListener(listener);
        m12.addActionListener(listener);
        m13.addActionListener(listener);
        // m21.addActionListener(listener);

        this.add(p, BorderLayout.CENTER);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(p,
                        "Sei sicuro di uscire?", "Conferma uscita.",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
