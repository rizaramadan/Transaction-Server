package control;

import model.Server;

/**
 *
 * @author riza
 */
public class Main {
    public static void main(String [] args) {
        //while(true) {
            try {
                Server tServer = new Server(true);
                tServer.start();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("\n Restarting Server");
            }
        //}
    }
}
