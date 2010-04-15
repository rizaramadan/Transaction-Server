ServerReceiver is like a stub for creating a transactional process. For a better understanding, here's the example:

when a client connect to server, a thread will be created for the purpose only to read data from a socket of that client. When a data receive, the reader will put the socket and the data into some kind of blocking request queue.
in the other hand, when a ServerReceiver is started, it creates a number of threads that eagerly take the head of the blocking request queue mention earlier. But since it was empty at that time, all those threads was put into blocking mode, so that CPU won't be bothered by it.
After the put operation was done, a lucky thread will take those request, process it, and sending the respond of the process back to the originator of that request.

The story above are already implemented in the stub, but still therea are 2 place that needs to be minded:
1. UserWorker. There's a method named "Process" that will be called when a Worker get a request
2. SocketReader. There's a method named "readSocket" thats called by the socket reader thread to read the socket. 

still, this stub already implemented those 2 method in a simple way. The process method is implemented so it will return "Hello, World!" what ever the request. The readSocket method is implemented by using SomeSocket.getInputStream().read(btye [] b) method. 