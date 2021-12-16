public class AutoSaver extends DialogHandler{
    private Saver saver;
    private BottomMenuPanel b;
    public AutoSaver(Saver saver, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.saver = saver;
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

                writeLog("Sessione corrente salvata in un file di backup.");
                try
                {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e1){}
                writeLog(" ");
            }
        }
    }
}
