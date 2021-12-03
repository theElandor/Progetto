/**
 * Note generali.
 * Attualmente alloco tutti gli oggetti subito.
 * Si può pensare di dire al table model di controllare
 * se l'elemento i,j esiste. In tal caso si ritorna il contenuto
 * della cella, altrimenti si ritorna "". In tal modo non vengono creati oggetti inutilmente.
 */
import javax.swing.JPanel;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.Border;
public class Main
{
    public static void main(String args[])
    {
        MyFrame f = new MyFrame("Progetto");
        f.setVisible(true);
    }
}