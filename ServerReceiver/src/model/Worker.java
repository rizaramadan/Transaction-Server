package model;

import control.impl.SocketReader;
import java.net.Socket;
import utils.Log;

/**
 * The Worker that acually do the work, :)
 * @author riza
 */
public abstract class Worker implements Runnable {

    private static Server mServerParrent;
    private QueueElement mQueueElement;

    public QueueElement GetQueueElement() { return mQueueElement; }
    public void SetQueueElement(QueueElement pQueueElement) {
        mQueueElement = pQueueElement;
    }

    public static void setServerParent( Server mParent ) {
        mServerParrent = mParent;
    }
    public static Server getServerParent(){ return mServerParrent; }

    /**
     * A method that responsible for writing the response to client
     * @param pSocket
     * @param pMessageResponse
     * @throws IOException
     */
    private static void reply(Socket pSocket, String pMessageResponse)  {
        try {
            pSocket.getOutputStream().write(pMessageResponse.getBytes());
        } catch(Exception ex) {
            Log.warning(Errors.WRITING_RESPONSE, ex.getMessage());
        }
    }

    /**
     * get the message from the queue element. The actual reading is defined
     * in control.implementation.SocketReader
     * @param pQueueElement
     * @return the string of the message
     */
    public static String GetMessage(QueueElement pQueueElement) {
        try {
            Socket tSocket = pQueueElement.getSocket();
            byte[] tMessages = SocketReader.readSocket(tSocket);

            String tBuffer = new String(tMessages);
            Log.write("message received:\nlength: "+tMessages.length+", Message:\n"+tBuffer);
            return tBuffer;
            //return tBuffer.toString();
        } catch(Exception ex) {
            Log.warning(Errors.GET_MESSAGE_FROM_SOCKET,"failed to get message from socket",ex);
            return "";
        }
    }

    public Worker()  {
        mQueueElement = null;
    }
    
    abstract public String Process(String pMessage);

    public void run() {
        while(true){
            QueueElement tQueueElement = null;
            String tMessageString  = null;
            try {
                tQueueElement = getServerParent().takeRequestQueue(this);
                SetQueueElement(tQueueElement);
                tMessageString = tQueueElement.getString();
                String tMessageResponse = Process(tMessageString);
                if(tMessageResponse != null)
                {
                    reply(tQueueElement.getSocket(), tMessageResponse);
                }
            } catch(Exception ex) {
                Log.warning(Errors.WORKER_RUN ,ex.getMessage(),ex);
            }
        } 
    }
}
