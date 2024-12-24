package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {

    public static String getUniqueString(String s){
        return s + new SimpleDateFormat(" ddMMyyyy-HHmmss").format(new Date());
    }
}
