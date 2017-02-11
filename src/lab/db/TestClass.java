package lab.db;

/**
 * Created by minute on 2017/2/6.
 */
public class TestClass {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(t1.i);
        System.out.println(t2.i);
        t1.i = 3;
        Test t3 = new Test();
        Test t4 = new Test();
        System.out.println(t3.i);
        System.out.println(t4.i);
    }
}

class Test {
    static int i = 5;
}

