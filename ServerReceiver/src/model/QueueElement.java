package model;

import java.net.Socket;

/**
 * The queue element. String member is for the stateful connection, which
 * IS the case, so it contains the message from client.
 * The socket is the client socket. Needed to send back the response.
 * @author riza
 */
public class QueueElement {
    private Socket mSocket;
    private String mString;

    public QueueElement(Socket pSocket, String pString) {
        mSocket = pSocket;
        mString = pString;
    }

    /**
     * @return the mSocket
     */
    public Socket getSocket() {
        return mSocket;
    }

    /**
     * @param mSocket the mSocket to set
     */
    public void setSocket(Socket mSocket) {
        this.mSocket = mSocket;
    }

    /**
     * @return the mString
     */
    public String getString() {
        return mString;
    }

    /**
     * @param mString the mString to set
     */
    public void setString(String mString) {
        this.mString = mString;
    }
}
