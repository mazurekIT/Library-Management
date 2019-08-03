package pl.mazurekit.cognifide;

import pl.mazurekit.cognifide.model.Json;
import pl.mazurekit.cognifide.model.VolumeInfo;

import java.io.IOException;
import java.util.List;

public interface BookListProvider {
    Json getAvailableBooks() throws IOException;
}
