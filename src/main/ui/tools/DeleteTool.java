package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTool extends Tool {

    // a tool that can be used to delete books in the reading list
    public DeleteTool(ReadingListApp list, JComponent parent) {
        super(list, parent);
    }

    @Override
    //EFFECTS: create the button with name "Delete Book"
    protected void createButton(JComponent parent) {
        button = new JButton("Delete Book");
        addToParent(parent);
    }

    @Override
    //EFFECTS: adds a listener for this tool
    protected void addListener() {
        button.addActionListener(new DeleteToolClickHandler());
    }

    //handles mouse click on the button
    private class DeleteToolClickHandler implements ActionListener {

        //MODIFIES: list
        // EFFECTS: changes list.window to 5
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(5);
        }
    }
}
