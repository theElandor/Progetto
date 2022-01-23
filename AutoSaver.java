/**
 * Classe che gestisce il salvataggio automatico.
 * Classe che estende il DialogHandler, in modo da ereditare i metodi
 * per comunicare messaggi all'utente attraverso la finestra di log.
 */
public class AutoSaver extends DialogHandler{
    private Saver saver;
    private BottomMenuPanel b;
    /**
     * Costruttore della classe.
     * Chiama il costruttore della classe padre che vuole il logPanel come parametro.
     * Tiene un riferimento al saver per usare i metodi che gestiscono il salvataggio.
     */
    public AutoSaver(Saver saver, BottomMenuPanel logPanel)
    {
        super(logPanel);
        this.saver = saver;
    }
    /**
     * Metoto specifico che gestisce il salvataggio automatico.
     * Prima di chiamare il metodo update_save, si controlla se il file 
     * è un file di backup generato dal metodo stesso.
     * In tal caso, il salvataggio automatico non viene effettuato. 
     */    
    public void run(){
        while(true)
        {
            try
            {
                sleep(10000); //effettuo un salvataggio ogni 10 secondi
            }
            catch(InterruptedException e){System.out.println("Interrupted");}
            if(saver.getModel().getSaved() && !saver.getModel().getCurrentSave().endsWith("~"))
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
