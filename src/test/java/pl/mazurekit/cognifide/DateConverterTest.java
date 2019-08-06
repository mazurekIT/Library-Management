package pl.mazurekit.cognifide;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateConverterTest {

    @Test
    public void nullDateFormatShouldReturnProperUnixTimestamp() {
        DateConverter actual = new DateConverter(null);
        assertEquals(new Long(0), actual.getUnixTimestamp());
    }

    @Test
    public void yearDateFormatShouldReturnProperUnixTimestamp() {
        DateConverter actual = new DateConverter("2000");
        assertEquals(new Long(946684800), actual.getUnixTimestamp());
    }

    @Test
    public void yearMontDateFormatShouldReturnProperUnixTimestamp() {
        DateConverter actual = new DateConverter("2000-02");
        assertEquals(new Long(949363200), actual.getUnixTimestamp());
    }

    @Test
    public void fullDateFormatShouldReturnProperUnixTimestamp() {
        DateConverter actual = new DateConverter("2000-02-03");
        assertEquals(new Long(949536000), actual.getUnixTimestamp());
    }


}