public class AutoSaver extends Thread{
    private Saver saver;
    private BottomMenuPanel b;
    public AutoSaver(Saver saver, BottomMenuPanel b)
    {
        this.saver = saver;
        this.b = b;
    }
    public void run(){
        while(true)
        {
            try
            {
                sleep(10000); // ogni 10 secondi
            }
            catch(InterruptedException e){System.out.println("Interrupted");}
            if(saver.getModel().getSaved())
            {
                saver.update_save(true);

                b.getLog().setText("Sessione corrente salvata in un file di backup.");
                try
                {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e1){}
                b.getLog().setText(" ");
            }
        }
    }
}
