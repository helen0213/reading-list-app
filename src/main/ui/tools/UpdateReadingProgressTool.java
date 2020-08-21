package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateReadingProgressTool extends Tool {
    // a tool that can be used to update reading progress
    public UpdateReadingProgressTool(ReadingListApp list, JComponent parent) {
        super(list, parent);
    }

    @Override
    //EFFECTS: create a button with name "Update progress"
    protected void createButton(JComponent parent) {
        button = new JButton("Update progress");
        addToParent(parent);
    }

    @Override
    //EFFECTS: adds a listener for this tool
    protected void addListener() {
        button.addActionListener(new UpdateReadingProgressToolClickHandler());
    }

    //handles mouse click on the button
    private class UpdateReadingProgressToolClickHandler implements ActionListener {

        // MODIFIES: list.window
        // EFFECTS: changes list.window to 3
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(3);
        }
    }
}
