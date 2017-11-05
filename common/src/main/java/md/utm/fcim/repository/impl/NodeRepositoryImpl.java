package md.utm.fcim.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import md.utm.fcim.dto.NodeDescription;
import md.utm.fcim.repository.NodeRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeRepositoryImpl implements NodeRepository {

    public List<NodeDescription> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<NodeDescription> nodeDescriptions = new ArrayList<>();

        try {
            // Convert JSON string from file to Object
            nodeDescriptions = mapper.readValue(
                    new File("/home/veladii/IdeaProjects/Pad_Lab2/common/src/main/resources/nodes_config.json"),
                    new TypeReference<List<NodeDescription>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodeDescriptions;
    }
}
