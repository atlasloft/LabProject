package core;

/**
 * Created by minute on 2017/2/5.
 */
public class Record {
    String name;
    Long id;
    Long tel;
    Long qq;
    String major;
    String other;
    String password;

    public Record(String name, Long id, Long tel, Long qq, String major, String other, String password) {
        this.name = name;
        this.id = id;
        this.tel = tel;
        this.qq = qq;
        this.major = major;
        this.other = other;
        this.password = password;
    }

    public Record() {
    }

    @Override
    public String toString(){
        return " "+name+" "+id+" "+tel+" "+qq+" "+major+" "+other+" "+password;
    }
}
