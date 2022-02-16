package Menu;
import javax.swing.*;
/**
 * Classe che implementa il menù di selezione.
 */
public class MainMenu extends JFrame //implements ActionListener
{
    public MainMenu()
    {
        this("");
    }
    /**
     * Costruttore della classe, crea tutti i pulsanti necessari per implementare
     * un semplice menù di selezione.
     * @param title Titolo della finestra da passare al costruttore del JFrame.<br>
     */
    public MainMenu(String title)
    {
        super(title);
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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}   
