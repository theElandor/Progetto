import Graphics.MyFrame;

/**
 * Classe che inizializza il programma.
 * Crea il Frame e lo rende visibile, il resto si avvia automaticamente
 */
public class Main
{
    public static void main(String args[])
    {
        MyFrame f = new MyFrame("Foglio di Calcolo");
        f.setVisible(true);
    }
}
