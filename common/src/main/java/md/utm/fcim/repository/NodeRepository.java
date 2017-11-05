package md.utm.fcim.repository;

import md.utm.fcim.dto.NodeDescription;

import java.util.List;

public interface NodeRepository {
    List<NodeDescription> findAll();
}
