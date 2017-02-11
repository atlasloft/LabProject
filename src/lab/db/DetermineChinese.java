package lab.db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by minute on 2017/2/6.
 */
public class DetermineChinese {

    public static boolean containsHanScript(String s) {
        for (int i = 0; i < s.length(); ) {
            int codepoint = s.codePointAt(i);
            i += Character.charCount(codepoint);
            if (Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Pattern p_str = Pattern.compile("[\\u4e00-\\u9fa5]+");
        String str = "english";
        Matcher m = p_str.matcher(str);
        if (m.find() && m.group(0).equals(str)) {
            System.out.println(true);
        }
    }
}
