package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadingListTool extends Tool {
    // a tool that can be used to display the reading list
    public ReadingListTool(ReadingListApp list, JComponent parent) {
        super(list, parent);
    }

    @Override
    //EFFECTS: create a button with name "Reading List"
    protected void createButton(JComponent parent) {
        button = new JButton("Reading List");
        addToParent(parent);
    }


    @Override
    //EFFECTS: add a listener for this tool
    protected void addListener() {
        button.addActionListener(new ReadingListToolClickHandler());
    }

    //handles mouse click on the button
    private class ReadingListToolClickHandler implements ActionListener {

        // MODIFIES: list.window
        // EFFECTS: changes list.window to 4
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(4);
        }
    }
}
