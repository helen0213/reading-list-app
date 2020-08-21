package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveTool extends Tool {
    // a tool that can be used to save the data
    public SaveTool(ReadingListApp list, JComponent parent) {
        super(list,parent);
    }

    @Override
    //EFFECTS: create a button with name "Save list"
    protected void createButton(JComponent parent) {
        button = new JButton("Save list");
        addToParent(parent);
    }

    @Override
    //EFFECTS: adds a listener for this tool
    protected void addListener() {
        button.addActionListener(new SaveToolClickHandler());
    }

    //handles mouse click on the button
    private class SaveToolClickHandler implements ActionListener {

        // MODIFIES: list.window
        // EFFECTS: changes list.window to 6
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(6);
        }
    }
}
