import controller.Controller;
import model.Model;
import view.AnsiView;
import view.ConsoleView;

public class Main {

    public static void main(String[] args)
    {
//        Controller controller = new Controller(new ConsoleView(), new Model());
        Controller controller = new Controller(new AnsiView(), new Model());
        controller.run();
    }

}
