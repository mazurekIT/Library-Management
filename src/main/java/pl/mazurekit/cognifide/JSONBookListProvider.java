package pl.mazurekit.cognifide;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.model.VolumeInfo;

import java.io.File;
import java.util.List;

public class JSONBookListProvider implements BookListProvider {

    private String filePath;

    private String testfile = "{\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"7tkN1CYzn2cC\",\n" +
            "   \"etag\": \"pfjjxSpetIM\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"A Hypervista of the Java Landscape\",\n" +
            "    \"publisher\": \"InfoStrategist.com\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781592432172\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1592432174\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.0.1.0.preview.3\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.pl/books?id=7tkN1CYzn2cC&dq=java&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/A_Hypervista_of_the_Java_Landscape.html?hl=&id=7tkN1CYzn2cC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"PL\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"PL\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.pl/books/download/A_Hypervista_of_the_Java_Landscape-sample-epub.acsm?id=7tkN1CYzn2cC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.pl/books/download/A_Hypervista_of_the_Java_Landscape-sample-pdf.acsm?id=7tkN1CYzn2cC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=7tkN1CYzn2cC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   }\n" +
            "  }";

    public JSONBookListProvider(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public List<VolumeInfo> getAvailableBooks() {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        try {
            List<Book> books = mapper.readValue(testfile, new TypeReference<List<Book>>() {
            });


        } catch (Exception e) {
            //TODO make it good
            e.printStackTrace();
        }

        return null;

    }


}
