package ui;

import ui.tools.*;
import ui.windows.*;

import javax.swing.*;
import java.awt.*;

//the user interface of the app
public class ReadingListApp extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    public AppData bookList = new AppData();
    public Display currentDisplay;

    //EFFECTS: construct a new ReadingList
    public ReadingListApp() {
        super("Reading List");
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this ReadingList will operate, and populates the tools to be used
    //           to manipulate this app
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        createTools();
        createWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //REQUIRES: window is in the range [1,6]
    //MODIFIES: this
    //EFFECTS: changes the window displaying based on window
    public void windowChanger(int window) {
        currentDisplay.removeAll();
        currentDisplay = changeWindow(window);
        add(currentDisplay, BorderLayout.CENTER);
        currentDisplay.setLayout(new BoxLayout(currentDisplay, BoxLayout.Y_AXIS));
        revalidate();
    }

    //REQUIRES: window is in the range [1,6]
    //MODIFIES: this
    //EFFECTS: returns the display corresponding to window
    public Display changeWindow(int window) {
        Display display;
        if (window == 1) {
            display = new NewBookWindow(bookList);
        } else if (window == 2) {
            display = new ReportOfInterestWindow(bookList);
        } else if (window == 3) {
            display = new UpdateProgressWindow(bookList);
        } else if (window == 4) {
            display = new ReadingListWindow(bookList);
        } else if (window == 5) {
            display = new DeleteWindow(bookList);
        } else {
            display = new SaveWindow(bookList);
        }
        return display;
    }

    // MODIFIES: this
    // EFFECTS:  instantiates all tools
    private void createTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0, 1));
        toolArea.setSize(200, HEIGHT);
        add(toolArea, BorderLayout.WEST);

        ReadingListTool readingListTool = new ReadingListTool(this, toolArea);

        NewBookTool addBookTool = new NewBookTool(this, toolArea);

        ReportOfInterestTool reportTool = new ReportOfInterestTool(this, toolArea);


        UpdateReadingProgressTool updateTool = new UpdateReadingProgressTool(this, toolArea);

        SaveTool saveTool = new SaveTool(this, toolArea);

        DeleteTool deleteTool = new DeleteTool(this, toolArea);

        toolArea.add(Box.createVerticalGlue());
        toolArea.add(Box.createVerticalGlue());
        toolArea.add(Box.createVerticalGlue());
        toolArea.add(Box.createVerticalGlue());
        toolArea.add(Box.createVerticalGlue());
    }

    // MODIFIES: this
    // EFFECTS:  instantiates the windows
    private void createWindow() {
        currentDisplay = new ReadingListWindow(bookList);
        add(currentDisplay, BorderLayout.CENTER);
        currentDisplay.setLayout(new BoxLayout(currentDisplay, BoxLayout.Y_AXIS));
        validate();
    }

    public static void main(String[] args) {
        new ReadingListApp();
    }

}
