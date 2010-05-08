package model.impl;

import model.Worker;

/**
 * The point of this class is the function process.
 * process will receive the message sent from client.
 * @author riza
 */
public class UserWorker extends Worker {

    /**
     * This function will be called if a client send a readable message
     * The user must provide a string that will be returned that client
     * @param pMessage the message from client
     * @return message that will be sent back to client
     */
    /**
     * TODO: Change the implementation of this
     * surely your application is more than a simple hello world, hehe
     */
    @Override
    public String process(String pMessage) {
        return "Hello World!";
    }

}
