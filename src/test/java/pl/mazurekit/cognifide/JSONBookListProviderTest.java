package pl.mazurekit.cognifide;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class JSONBookListProviderTest {

    @Test
    public void shouldGetProperSizeOfBooksList(){
        JSONBookListProvider jsonBookListProvider = new JSONBookListProvider(filePath());
        int expectedSizeOfBookList = 4;
        assertEquals(expectedSizeOfBookList,jsonBookListProvider.getAvailableBooks().size());
    }



    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("booksTest.json").getFile());
        return file.getAbsolutePath();
    }

}