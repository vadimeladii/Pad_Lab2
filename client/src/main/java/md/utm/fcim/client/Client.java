package md.utm.fcim.client;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonValidator;
import md.utm.fcim.connection.tcp.impl.CreateConnection;
import md.utm.fcim.constant.FieldName;
import md.utm.fcim.constant.MethodName;
import md.utm.fcim.constant.OperationType;
import md.utm.fcim.dto.MessageDto;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jackson.JsonLoader;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, ProcessingException {
        CreateConnection connection = CreateConnection.getINSTANCE().build(
                new MessageDto(MethodName.SORTED, FieldName.AGE, OperationType.ASCENDING),
                "localhost",
                5555);


        String users = connection.getServerConnection().getUsers();

        String jsonSchema = FileUtils.readFileToString(
                new File("/home/veladii/IdeaProjects/Pad_Lab2/client/src/main/resources/schema.json"), "UTF-8");
        final JsonNode data = JsonLoader.fromString(users);
        final JsonNode schema = JsonLoader.fromString(jsonSchema);

        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonValidator validator = factory.getValidator();

        ProcessingReport report = validator.validate(schema, data);
        if (report.isSuccess()) {
            System.out.println(users);
        } else {
            System.out.println("Schema is not valid JSON error");
        }
    }
}
