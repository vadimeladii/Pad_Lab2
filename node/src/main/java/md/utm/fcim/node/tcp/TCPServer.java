package md.utm.fcim.node.tcp;

import md.utm.fcim.dto.NodeDescription;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private ServerSocket serverSocket;
    private NodeDescription nodeDescription;

    public TCPServer(NodeDescription nodeDescription) {
        this.nodeDescription = nodeDescription;
        try {
            serverSocket = new ServerSocket(nodeDescription.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + this.nodeDescription.getPort() + "...");

                Socket accept = serverSocket.accept();

                new Thread(() -> {
                    new ClientConnection(accept, nodeDescription);
                }).start();

            } catch (IOException e) {
                System.out.println("Client was disconnected");
            }
        }
    }
}
