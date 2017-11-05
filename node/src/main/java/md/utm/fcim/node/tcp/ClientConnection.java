package md.utm.fcim.node.tcp;

import md.utm.fcim.dto.NodeDescription;
import md.utm.fcim.dto.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import static java.lang.Thread.currentThread;

public class ClientConnection {

    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ClientConnection(Socket socket, NodeDescription nodeDescription) {
        try {
            this.socket = socket;
            objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendToClient(nodeDescription.getUsers());
    }

    public void sendToClient(List<User> users) {
        try {
            System.out.println("Send message to client -> " + users);
            getObjectOutputStream().writeObject(users);
            getObjectOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public void closeConnection() {
        try {
            objectInputStream.close();
            this.socket.close();
            currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    @Override
    public String toString() {
        return "ClientConnection{" +
                "socket=" + socket +
                ", objectOutputStream=" + objectOutputStream +
                ", objectInputStream=" + objectInputStream +
                '}';
    }
}
