package lab.PureUI;

/**
 * Created by minute on 2017/2/6.
 */
public class Controller {
    View view = new View();


    public Controller(View view) {
        this.view = view;
        view.init();
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

    }
}
