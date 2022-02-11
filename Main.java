import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.Border;
/**
 * Classe che inizializza il programma.
 * Crea soltanto il frame, il resto si avvia di conseguenza.
 */
public class Main
{
    public static void main(String args[])
    {
        System.out.println("-----DEBUG_CONSOLE----");
        MyFrame f = new MyFrame("Progetto");
        f.setVisible(true);
    }
}
