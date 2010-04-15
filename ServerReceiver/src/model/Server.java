package model;

import control.impl.SocketReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import model.impl.UserWorker;
import utils.Log;

/**
 * The main class that handle the functionality of the server
 * @author riza
 */

public class Server {

    private ExecutorService mExecutorService;
    private ExecutorService mExecutorSocketReading;
    ArrayBlockingQueue<QueueElement> mRequestQueue;
    private ServerSocket mServerSocket;
    private Config mConfig;

    public Server(boolean pUseQueue) {
        
        //the sequence DOES MATTER
        mConfig = new Config();
        mConfig.loadConfiguration();
        initializeQueue();
    }

    public void start() {
        //the sequence DOES MATTER
        initializeThreadPool();
        startListening();
    }

    /**
     * initializing the queue, with the capacity based on configuration
     */
    private void initializeQueue()  {
        try {
            int tQueueCapacity = mConfig.getQueueCapacity();
            boolean tQueueFairness = mConfig.getQueueFairness();
            mRequestQueue = new ArrayBlockingQueue<QueueElement>
                            (tQueueCapacity, tQueueFairness);
        } catch(Exception ex) {
            Log.severe(Errors.INITIALIZE_QUEUE,
                    "queue failed to initialize, exiting", ex);
            System.exit(-1);
        }
    }

    /**
     * Initialize thread pool. The thread already working
     */
    private void initializeThreadPool() {
        int tThreadNumber = mConfig.getThreadNumber();
        Worker.setServerParent(this);
        try {
            mExecutorService = Executors.newCachedThreadPool();
            for(int i = 0; i < tThreadNumber; ++i) {
                mExecutorService.execute(new UserWorker());
            }
            mExecutorSocketReading = Executors.newCachedThreadPool();
        } catch (Exception ex) {
            Log.warning(Errors.CREATE_THREAD_FAILED,
                    "threadppol failed to initialize, exiting",ex);
            System.exit(-1);
        }
        Log.write("pool initialized");
    }

    /**
     * Start the socket port listening
     */
    private void startListening() {
        SocketListener tSocketListener = new SocketListener(
                mConfig.getProperties(), mServerSocket, this);
        Thread tThread = new Thread(tSocketListener);
        tThread.start();
        Log.info("port opened at "+ mConfig.getPort() + ". Server ready");
    }

    /**
     * 
     * @param pSocket
     */
    public void ReceiveConnection(Socket pSocket) {
        final Socket tSocket = pSocket;
        mExecutorSocketReading.execute(new Runnable() {
            public void run() {
                try {
                    while(true) {
                        byte[] tMessages = SocketReader.readSocket(tSocket);
                        String tBuffer = new String(tMessages);
                        try {
                            mRequestQueue.put(new QueueElement(tSocket, tBuffer));
                        } catch (InterruptedException ex) {
                            Log.warning( Errors.CONNECTION_ERROR, null);
                        }
                    }
                } catch(Exception ex) {
                    Log.warning(Errors.MAINTAINED_SOCKET_ERROR, "Client Disconnecting");
                }
            }
        });
    }

    public QueueElement takeRequestQueue(Worker pWorker) {
        try {
            return mRequestQueue.take();
        } catch(Exception ex) {
            Log.severe(Errors.TAKING_REQUEST, ex.getMessage());
        }
        return null;
    }

    public int getAproximateLoad() {
        return mRequestQueue.remainingCapacity();
    }

    public Config getGlobalConfig() {
        return mConfig;
    }
}
