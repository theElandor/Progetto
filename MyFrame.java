import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class MyFrame extends JFrame
{
    private BigPanel p;
    public MyFrame()
    {
        this("");
    }
    public MyFrame(String titolo)
    {
        super(titolo);
        setBounds(0,0,1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p = new BigPanel();
        this.add(p);    
    }
}
