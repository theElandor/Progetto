package Graphics;

import java.awt.*;
import javax.swing.*;
import Menu.MainMenuListener;
/**
 * Frame del foglio di calcolo, a cui e' associato un Menu' principale di scelta multipla.
 * Contiene un'oggetto di tipo Graphics.BigPanel.<br>
 * A questa classe e' associato un WindowListener, in modo da poter lanciare la finestra di dialogo.<br>
 * che chiede all'utente conferma prima di uscire.<br>
 */
public class MyFrame extends JFrame
{
    private BigPanel p;
    private MainMenuListener listener;
    public MyFrame() {this("");}
    /**
     * Costruttore della classe.<br>
     * Vengono aggiunti alla schermata principale tutti i componenti grafici necessari.<br>
     * Viene creato il Listener del menù principale.<br>
     * Viene fatto l'override del metodo WindowClosing, per lanciare una finestra di conferma 
     * prima che il programma venga terminato.<br>
     */ 
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

        m1.add(m11);
        m1.add(m12);
        m1.add(m13);

        JMenuBar mb = new JMenuBar();
        mb.add(m1);

        this.setJMenuBar(mb);
        m11.addActionListener(listener);
        m12.addActionListener(listener);
        m13.addActionListener(listener);

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
