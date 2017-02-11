package core;

/**
 * Created by minute on 2017/2/5.
 */
public class RgstEnter {
    public void enter(){
        RgstView rgstView = new RgstView();
        RgstModel rgstModel = new RgstModel();
        RgstController rgstController = new RgstController(rgstModel, rgstView);
        rgstView.setVisible(true);

    }
//    public static void main(String[] args) {
//        new RgstEnter().enter();
//    }
}
