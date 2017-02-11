package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by minute on 2017/2/6.
 */
public class Determiner {

    public static boolean isPureChinese(String str){
        Pattern p_str = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Matcher m = p_str.matcher(str);
        if (m.find() && m.group(0).equals(str)) {
            return true;
        }
        return false;
    }
}
