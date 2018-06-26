package utiles;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTool {

    public static Date StringToDate(String dateString) {
        dateString = DateFromat(dateString);
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition parsePosition = new ParsePosition(0);
        Date brithdayDate = simpleDateFormat.parse(dateString, parsePosition);
        return brithdayDate;
    }

    private static String DateFromat(String date){
        char[] birthdayCharArray = date.toCharArray();
        birthdayCharArray[4]='-';
        birthdayCharArray[7]='-';
        System.out.println(birthdayCharArray.length);
        if (birthdayCharArray.length==11){
            birthdayCharArray[10]=' ';
        }
        date = new String(birthdayCharArray);
        return date;
    }
}
