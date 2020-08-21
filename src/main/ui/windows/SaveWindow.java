package ui.windows;

import ui.AppData;

import javax.swing.*;
import java.awt.*;

//a window that displays when the data is saved
public class SaveWindow extends Display {

    private AppData list;

    //EFFECTS: construct a SaveWindow in booklist
    public SaveWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        list.saveBooks();
        displaySavePage();
    }

    //EFFECTS: draws the page that display save page
    private void displaySavePage() {
        add(Box.createVerticalStrut(40));
        add(new JLabel("your reading list has been saved"));
    }
}
