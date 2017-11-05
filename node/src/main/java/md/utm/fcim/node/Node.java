package md.utm.fcim.node;

import md.utm.fcim.dto.NodeDescription;
import md.utm.fcim.node.tcp.TCPServer;

public class Node {

    private NodeDescription nodeDescription;

    public Node(NodeDescription nodeDescription) {
        this.nodeDescription = nodeDescription;
        System.out.println(nodeDescription);
        this.run();
    }

    private void run() {
        new TCPServer(nodeDescription).start();

    }




}
