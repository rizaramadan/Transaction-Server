package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author riza
 */
public class DateTime {

    /**
     * format yyyy-mm-dd => 2010-03-03
     * @see java.text.SimpleDateFormat
     * @param pFormat
     * @return
     */
    public static String getCurrentDateTime(String pFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(pFormat);
        Calendar c1 = Calendar.getInstance(); // today
        return sdf.format(c1.getTime());
    }
}
