package ui.tools;

import ui.ReadingListApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportOfInterestTool extends Tool {
    // a tool that can be used to display the report of interest
    public ReportOfInterestTool(ReadingListApp list, JComponent parent) {
        super(list, parent);
    }

    @Override
    //EFFECTS: create a button with name "Report of interest"
    protected void createButton(JComponent parent) {
        button = new JButton("Report of interest");
        addToParent(parent);
    }

    @Override
    //EFFECTS: adds a listener for this tool
    protected void addListener() {
        button.addActionListener(new ReportOfInterestToolClickHandler());
    }


    //handles mouse click on the button
    private class ReportOfInterestToolClickHandler implements ActionListener {

        // MODIFIES: list.window
        // EFFECTS: changes list.window to 2
        @Override
        public void actionPerformed(ActionEvent e) {
            list.windowChanger(2);
        }
    }
}
