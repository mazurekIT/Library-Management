package pl.mazurekit.cognifide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateConverter { //TODO Check if it works properly
    private String fullDate;


    public DateConverter(String date) {
        if (date == null) {
            this.fullDate = "1970-01-01T00:00:00";
        } else {
            while (date.length() < 10) {
                date = date + "-01";
            }
            this.fullDate = date + "T00:00:00";
        }
    }


    public Long getUnixTimestamp() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date parse = dateFormat.parse(this.fullDate);
            return (parse.getTime() / 1000L)+3600;
        } catch (ParseException e) {
            return 0L;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateConverter that = (DateConverter) o;
        return Objects.equals(fullDate, that.fullDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullDate);
    }
}
