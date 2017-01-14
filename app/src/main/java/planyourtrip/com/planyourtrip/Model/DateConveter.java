package planyourtrip.com.planyourtrip.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shrinivas on 14-01-2017.
 */

public class DateConveter{

    public static Date getDate(String s){
        if(s.contains("T")) {
            String time = s.substring(s.indexOf('T')+1, s.length());
            s = s.substring(0, s.indexOf('T'));
            SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try
            {
                Date date = sDF.parse(s+" " +time);

                System.out.println("date : "+sDF.format(date));

                return date;
            }
            catch (ParseException ex)
            {
                System.out.println("Exception "+ex);
            }
        } else {
            SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date date = sDF.parse(s);

                System.out.println("date : "+sDF.format(date));

                return date;
            }
            catch (ParseException ex)
            {
                System.out.println("Exception "+ex);
            }
        }
        return null;
    }
}
