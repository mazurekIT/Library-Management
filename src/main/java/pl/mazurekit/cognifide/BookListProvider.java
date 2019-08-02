package pl.mazurekit.cognifide;

import pl.mazurekit.cognifide.model.VolumeInfo;

import java.util.List;

public interface BookListProvider {
    List<VolumeInfo> getAvailableBooks();
}
