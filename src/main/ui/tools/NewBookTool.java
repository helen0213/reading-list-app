package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookTool extends Tool {

    // a tool that can be used to add books to the reading list
    public NewBookTool(ReadingListApp list, JComponent parent) {
        super(list, parent);
    }

    @Override
    //EFFECTS: create a button with name "Add new book"
    protected void createButton(JComponent parent) {
        button = new JButton("Add new book");
        addToParent(parent);
    }


    @Override
    //EFFECTS: adds a listener for this tool
    protected void addListener() {
        button.addActionListener(new NewBookToolClickHandler());
    }

    //handles mouse click on the button
    private class NewBookToolClickHandler implements ActionListener {

        // MODIFIES: list.window
        // EFFECTS: changes list.window to 1
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(1);
        }
    }
}
