import Altas.WindowManager;

public class Main {

    public static void main(String[] args) {

        // This variable (which is of type WindowManager) calls the getNewWindow method.
        // The getNewWindow method creates a new WindowManager object, and returns it.
        // display = WindowManager object
        WindowManager display = WindowManager.createWindowObject();

        display.run(); // The WindowManager object calls the run method. This is a method that initialises the window and starts the window loop
    }

}
