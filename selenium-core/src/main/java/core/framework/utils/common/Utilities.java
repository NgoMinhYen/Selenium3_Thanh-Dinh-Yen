package core.framework.utils.common;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utilities {
    private final static String ALPHA_NUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Find today with format
     */
    public static String toDate(String format) {
        LocalDateTime ldt = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(String.format("%s", format), Locale.ENGLISH).format(ldt);
    }

    /**
     * Find date with format and plus day
     */
    public static String fromDate(String format, int plusDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, plusDay);
        Date date = calendar.getTime();

        SimpleDateFormat format1      = new SimpleDateFormat(format);
        String           inActiveDate = null;

        inActiveDate = format1.format(date);

        return inActiveDate;
    }

    public static String getRandomString(int len) {
        StringBuilder builder = new StringBuilder();
        while (len-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
