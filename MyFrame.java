import javax.swing.JFrame;

public class MyFrame extends JFrame
{
    public MyFrame()
    {
        this("");
    }
    public MyFrame(String titolo)
    {
        super(titolo);
        setBounds(0,0,1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}