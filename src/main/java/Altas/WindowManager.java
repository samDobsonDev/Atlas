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
    public static WindowManager createWindowObject() {
        return new WindowManager(400, 225, "AtlasEngine");
    }

    // Method that initialises the window and starts the window loop
    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();
    }

    // Method to initialise the window
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
        glfwSetWindowSize(glfwWindow, 800, 450);
        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window.");
        }

        glfwMakeContextCurrent(glfwWindow); // Make the OpenGL context current

        glfwSwapInterval(1); // Enable V-Sync

        glfwShowWindow(glfwWindow); // Make the window visible

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
    }

    // Method to start the window loop
    public void loop() {
        // Run the rendering loop until the user has attempted to close the window or has pressed the ESCAPE key
        while (!glfwWindowShouldClose(glfwWindow)) {
            glClearColor(1.0f, 0.0f, 0.0f, 1.0f); // Sets the colour of the window
            glClear(GL_COLOR_BUFFER_BIT); // clean the framebuffer
            glfwSwapBuffers(glfwWindow); // swap the colour buffers
            glfwPollEvents(); // Poll for window events
        }
    }
}
