package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public String formatDate(String inputDate) {
        if (inputDate == null) {
            return null; 
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);  
        try {
            Date date = sdf.parse(inputDate);
            return sdf.format(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
