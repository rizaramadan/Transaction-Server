package clientofserverreceiver;

import java.net.Socket;

/**
 *
 * @author riza
 */
public class RunnableTest implements Runnable{
 private int ThreadNumber;

    public RunnableTest(int i) {
        ThreadNumber = i;
    }

    public void run() {
        try {
            for(int i = 0; i < Main.EXECUTION_NUMBER; ++i) {
                Socket t = new Socket("localhost", 35568);
                t.getOutputStream().write(1);
                byte [] tResponse = new byte[100];
                t.getInputStream().read(tResponse);
                String tResponsString = new String(tResponse);
                System.out.println("Response from thread:"+
                        ThreadNumber+",exec:"+i+","+ tResponsString);
                t.close();
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
