package Altas;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class WindowManager{

    private final int width;
    private final int height;
    private final String title;
    private long glfwWindow;

    // Constructor Method. Private so this is a singleton method, only the WindowManager class can create it, not objects created from the class
    private WindowManager(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    // Method to create an object from the WindowManager class, then return it. Passing in the arguments specified in the constructor
    public static WindowManager getNewWindow() {
        return new WindowManager(1920, 1080, "AtlasEngine");
    }

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set(); // Sets System.err as a default implementation to display any error messages

        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE); // the window will be maximized

        // Create the window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
    }

    public void loop() {

    }
}
