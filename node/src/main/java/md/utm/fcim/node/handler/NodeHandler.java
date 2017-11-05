package md.utm.fcim.node.handler;

import md.utm.fcim.node.Node;
import md.utm.fcim.repository.NodeRepository;
import md.utm.fcim.repository.impl.NodeRepositoryImpl;

public class NodeHandler {

    private NodeRepository nodeRepository;

    public NodeHandler() {
        this.nodeRepository = new NodeRepositoryImpl();
    }

    public void createNodes() {
        this.nodeRepository.findAll()
                .forEach(nodeDescription -> {
                    new Thread(() -> {
                        new Node(nodeDescription);
                    }).start();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
