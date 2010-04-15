package clientofserverreceiver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ray
 */
public class Main {
    static final int THREAD_NUMBER = 30;
    static final int EXECUTION_NUMBER = 1;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ExecutorService tExecService = Executors.newCachedThreadPool();
        for(int i = 0; i < THREAD_NUMBER; ++i){
            tExecService.execute(new RunnableTest(i));
            try { Thread.sleep(1); } catch(Exception ex) { }
        }
        tExecService.shutdown();
    }
}
