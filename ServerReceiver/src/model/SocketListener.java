package model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import utils.Log;

/**
 * Class dan handle Socket Listener
 * @author riza
 */
class SocketListener implements Runnable {

    protected ServerSocket mServerSocket;
    protected Properties mProperties;
    protected Server mServerParent;

    public SocketListener(Properties pProperties, ServerSocket pServerSocket, Server pServerParent ) {
        mProperties = pProperties;
        mServerSocket = pServerSocket;
        mServerParent = pServerParent;
    }
    
    public void run() {
        try {
            int tPort = Integer.parseInt(mProperties.getProperty(Config.Port));
            mServerSocket = new ServerSocket(tPort);
            Socket tClientSocket = null;
            while(true) {
                tClientSocket = mServerSocket.accept();
                tClientSocket.setKeepAlive(true);
                tClientSocket.setReuseAddress(true);
                Log.write("client trying to connect");
                mServerParent.receiveConnection(tClientSocket);
                Log.write("put request to queue");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            Log.severe(Errors.SOCKET_LISTENING, ex.getMessage());
        }
    }
}
