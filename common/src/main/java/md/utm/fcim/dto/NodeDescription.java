package md.utm.fcim.dto;

import java.io.Serializable;
import java.util.List;

public class NodeDescription implements Serializable {

    private Long id;
    private String host;
    private Integer port;
    private List<DependencyNode> dependencies;
    private List<User> users;

    public NodeDescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<DependencyNode> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<DependencyNode> dependencies) {
        this.dependencies = dependencies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "NodeDescription{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", dependencies=" + dependencies +
                ", users=" + users +
                '}';
    }
}
