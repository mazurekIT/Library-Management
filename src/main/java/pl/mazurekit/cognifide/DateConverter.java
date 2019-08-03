package pl.mazurekit.cognifide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private String fullDate;


    public DateConverter(String date) {
        if (date == null) {
            this.fullDate = "1970-01-01T00:00:00.000-0000";
        } else {
            while (date.length() < 10) {
                date = date + "-01";
            }
            this.fullDate = date + "T00:00:00.000-0000";
        }
    }


    public Long getUnixTimestamp() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            Date parse = dateFormat.parse(this.fullDate);
            return parse.getTime() / 1000L;
        } catch (ParseException e) {
            return 0L;
        }

    }
}
