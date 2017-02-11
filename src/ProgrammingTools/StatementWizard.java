package ProgrammingTools;

/**
 * Created by minute on 2017/2/6.
 */
public class StatementWizard {
    public static void generate(String... str) {
        String[] result = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            result[i] = "props.getProperty(\"" + str[i]+"\")";
        }
        for (String s :
                result) {
            System.out.println(s);
        }
    }

    public static void generate2(int count){
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = "data[i]["+i+"] = rs.get();";
        }
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        generate2(7);
        generate("user", "password", "url");
    }
}
