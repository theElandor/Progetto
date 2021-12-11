import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Creazione del pannello principale
        p = new BigPanel();

        /**
         * Creo il listener, devo passargli attraverso
         * i getter la Tabella e la Value Table.
         */
        listener = new MainMenuListener(p.getTablePanel().getDataModel());


        // Creazione del menù principale del frame
        JMenuItem m11 = new JMenuItem("Salva");
        JMenuItem m12 = new JMenuItem("Salva con nome");
        JMenuItem m13 = new JMenuItem("Carica");
        JMenuItem m14 = new JMenuItem("Nuovo");
        JMenu m1 = new JMenu("File");
        m1.add(m14);
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
    }
}
