package ui.windows;

import ui.AppData;

import javax.swing.*;
import java.awt.*;

//a window that displays the report of interest
public class ReportOfInterestWindow extends Display {

    private AppData list;

    //EFFECTS: construct a ReportOfInterestWindow in booklist
    public ReportOfInterestWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        displayReport();
    }

    //EFFECTS: displays the report of interest
    private void displayReport() {
        add(Box.createVerticalStrut(40));
        add(new JLabel("Report of Interest"));
        add(Box.createVerticalStrut(30));
        String report = "Your favorite genre is : " + list.booksList.getMostInterestedGenre();
        add(new JLabel(report));
    }
}
