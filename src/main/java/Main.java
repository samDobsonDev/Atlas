import Altas.WindowManager;

public class Main {

    public static void main(String[] args) {

        // This variable (which is of type WindowManager) calls the getNewWindow function.
        // The getNewWindow function creates a new WindowManager object, and returns it.
        // display = WindowManager object
        WindowManager display = WindowManager.getNewWindow();

        display.run();
    }

}
