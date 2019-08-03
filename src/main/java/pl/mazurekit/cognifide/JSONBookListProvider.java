package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mazurekit.cognifide.model.Json;
import pl.mazurekit.cognifide.model.VolumeInfo;

import java.io.IOException;
import java.util.List;

public class JSONBookListProvider implements BookListProvider {

    private String filePath;

    public JSONBookListProvider(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public Json getAvailableBooks() throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(filePath);
//        JsonNode jsonNode1 = jsonNode.get("items");

        Json json = new Json();



        return null;

    }


}
