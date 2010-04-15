package control.impl;
import java.io.IOException;
import java.net.Socket;
import model.Errors;
import utils.Log;

/**
 * The reader of socket connections
 * @author riza
 */
public class SocketReader {
    public static byte[] readSocket(Socket pSocket) {
        try {
           return getMessageFromSocket(pSocket);
        } catch(Exception ex) {
            Log.severe(Errors.READ_SOCKET, ex.getMessage(), ex);
        }
        return null;
    }

    /**
     * when a client connects, this function will be called.
     * Given the socket of the client itself, the user must provide of
     * how the message will be read from client
     * @param pSocket
     * @return the message from client in array of byte
     */
    /**
     * TODO: Change the implementation of this.. or not, its up to you
     */
    private static byte[] getMessageFromSocket(Socket pSocket) throws IOException {
        byte [] b = new byte[1000];
        int tLength = pSocket.getInputStream().read(b);
        byte [] tReturn = new byte[tLength];
        for(int i = 0; i < tLength; ++i) {
            tReturn[i] = b[i];
        }
        return tReturn;
    }
}
